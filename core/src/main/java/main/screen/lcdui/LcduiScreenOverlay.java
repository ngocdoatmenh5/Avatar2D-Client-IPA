package main.screen.lcdui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ray3k.stripe.FreeTypeSkin;
import java.util.HashMap;
import java.util.Map;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import main.Canvas;
import main.screen.Main;
import main.screen.ScreenChild;
import main.screen.ScreenManager;
import main.screen.tab258.MainTab258;

/**
 * Scene2D renderer for J2ME {@link Form} / {@link List} (same approach as reference LibGDX client's ScreenChild menus).
 */
public final class LcduiScreenOverlay implements ScreenChild {
    private final Displayable displayable;
    private final Stage stage;
    private final Viewport viewport;
    private final Skin skin;
    private boolean visible;
    private final Map<javax.microedition.lcdui.TextField, TextField> textFields = new HashMap<>();
    private final Map<ChoiceGroup, ChoiceBinding> choiceGroups = new HashMap<>();
    private com.badlogic.gdx.scenes.scene2d.ui.List listWidget;
    private List listModel;

    private static final class ChoiceBinding {
        SelectBox<String> exclusive;
        CheckBox[] multiple;
    }

    public static void showOverlay(Displayable displayable) {
        dismissOverlay();
        MainTab258 tab = ScreenManager.instance.getActiveTab();
        if (tab == null) {
            return;
        }
        LcduiScreenOverlay overlay = new LcduiScreenOverlay(displayable);
        overlay.show();
    }

    public static void dismissOverlay() {
        MainTab258 tab = ScreenManager.instance.getActiveTab();
        if (tab == null) {
            return;
        }
        ScreenChild child = tab.screenChild;
        if (child instanceof LcduiScreenOverlay) {
            ((LcduiScreenOverlay) child).hide();
        }
    }

    private LcduiScreenOverlay(Displayable displayable) {
        this.displayable = displayable;
        this.viewport = new ScreenViewport();
        this.stage = new Stage(viewport);
        this.skin = new FreeTypeSkin(Gdx.files.internal("skin/skin.json"));
        buildUi();
    }

    private void buildUi() {
        Table root = new Table(skin);
        root.setFillParent(true);
        root.setBackground(skin.newDrawable("white"));
        stage.addActor(root);

        String title = displayable.getTitle();
        if (title != null && title.length() > 0) {
            Label titleLabel = new Label(title, skin);
            titleLabel.setColor(Color.valueOf("2E8B57"));
            root.add(titleLabel).colspan(2).pad(8).align(Align.center).fillX();
            root.row();
        }

        Table content = new Table(skin);
        ScrollPane scroll = new ScrollPane(content, skin);
        scroll.setFadeScrollBars(false);
        root.add(scroll).expand().fill().colspan(2).pad(8);
        root.row();

        if (displayable instanceof Form) {
            buildForm((Form) displayable, content);
        } else if (displayable instanceof List) {
            buildList((List) displayable, content);
        }

        Table cmdRow = new Table(skin);
        for (int i = 0; i < displayable.getCommandCount(); ++i) {
            final Command cmd = displayable.getCommand(i);
            TextButton btn = new TextButton(cmd.label, skin);
            btn.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    syncModelFromWidgets();
                    CommandListener listener = displayable.getCommandListener();
                    if (listener != null) {
                        listener.commandAction(cmd, displayable);
                    }
                }
            });
            cmdRow.add(btn).pad(4).minWidth(100);
        }
        root.add(cmdRow).colspan(2).pad(8).bottom();
    }

    private void buildForm(Form form, Table content) {
        for (int i = 0; i < form.size(); ++i) {
            Object item = form.get(i);
            if (item instanceof String) {
                Label note = new Label((String) item, skin);
                note.setWrap(true);
                content.add(note).colspan(2).fillX().pad(4);
                content.row();
            } else if (item instanceof javax.microedition.lcdui.TextField) {
                addTextFieldRow(content, (javax.microedition.lcdui.TextField) item);
            } else if (item instanceof ChoiceGroup) {
                addChoiceGroup(content, (ChoiceGroup) item);
            }
        }
    }

    private void addTextFieldRow(Table content, javax.microedition.lcdui.TextField model) {
        if (model.getLabel() != null && model.getLabel().length() > 0) {
            Label label = new Label(model.getLabel(), skin);
            label.setWrap(true);
            content.add(label).colspan(2).fillX().align(Align.left).pad(4);
            content.row();
        }
        TextField widget = new TextField(model.getString(), skin);
        if (model.isNumeric()) {
            widget.setTextFieldFilter(new TextField.TextFieldFilter.DigitsOnlyFilter());
        }
        textFields.put(model, widget);
        content.add(widget).colspan(2).fillX().pad(4);
        content.row();
    }

    private void addChoiceGroup(Table content, ChoiceGroup group) {
        if (group.getLabel() != null && group.getLabel().length() > 0) {
            Label label = new Label(group.getLabel(), skin);
            label.setColor(Color.valueOf("2E8B57"));
            content.add(label).colspan(2).fillX().align(Align.left).pad(6);
            content.row();
        }

        ChoiceBinding binding = new ChoiceBinding();
        if (group.getChoiceType() == ChoiceGroup.MULTIPLE) {
            binding.multiple = new CheckBox[group.size()];
            for (int i = 0; i < group.size(); ++i) {
                CheckBox box = new CheckBox(group.getChoice(i), skin);
                box.setChecked(group.isSelected(i));
                binding.multiple[i] = box;
                content.add(box).colspan(2).left().pad(2);
                content.row();
            }
        } else {
            SelectBox<String> box = new SelectBox<>(skin);
            Array<String> items = new Array<>();
            for (int i = 0; i < group.size(); ++i) {
                items.add(group.getChoice(i));
            }
            box.setItems(items);
            int selected = group.getSelectedIndex();
            if (selected >= 0 && selected < items.size) {
                box.setSelectedIndex(selected);
            }
            binding.exclusive = box;
            content.add(box).colspan(2).fillX().pad(4);
            content.row();
        }
        choiceGroups.put(group, binding);
    }

    private void buildList(List list, Table content) {
        listModel = list;
        listWidget = new com.badlogic.gdx.scenes.scene2d.ui.List(skin);
        Array<String> items = new Array<>();
        for (int i = 0; i < list.size(); ++i) {
            items.add(list.getChoice(i));
        }
        listWidget.setItems(items);
        if (list.getSelectedIndex() >= 0 && list.getSelectedIndex() < items.size) {
            listWidget.setSelectedIndex(list.getSelectedIndex());
        }
        listWidget.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (listModel == null) {
                    return;
                }
                Command select = listModel.getSelectCommand();
                CommandListener listener = listModel.getCommandListener();
                if (select != null && listener != null) {
                    syncModelFromWidgets();
                    listener.commandAction(select, listModel);
                }
            }
        });
        content.add(listWidget).expand().fill().pad(4);
    }

    private void syncModelFromWidgets() {
        for (Map.Entry<javax.microedition.lcdui.TextField, TextField> e : textFields.entrySet()) {
            e.getKey().setString(e.getValue().getText());
        }
        for (Map.Entry<ChoiceGroup, ChoiceBinding> e : choiceGroups.entrySet()) {
            ChoiceGroup group = e.getKey();
            ChoiceBinding binding = e.getValue();
            if (binding.exclusive != null) {
                group.setSelectedIndex(binding.exclusive.getSelectedIndex(), true);
            } else if (binding.multiple != null) {
                for (int i = 0; i < binding.multiple.length; ++i) {
                    group.setSelectedIndex(i, binding.multiple[i].isChecked());
                }
            }
        }
        if (listModel != null && listWidget != null) {
            listModel.setSelectedIndex(listWidget.getSelectedIndex(), true);
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void show() {
        visible = true;
        MainTab258 tab = ScreenManager.instance.getActiveTab();
        if (tab != null) {
            tab.screenChild = this;
        }
        if (Main.instance != null && Main.instance.inputMultiplexer != null) {
            Gdx.input.setInputProcessor(stage);
        } else {
            Gdx.input.setInputProcessor(stage);
        }
    }

    @Override
    public void hide() {
        visible = false;
        MainTab258 tab = ScreenManager.instance.getActiveTab();
        if (tab != null && tab.screenChild == this) {
            tab.screenChild = null;
        }
        if (Main.instance != null && Main.instance.inputMultiplexer != null) {
            Gdx.input.setInputProcessor(Main.instance.inputMultiplexer);
        }
        stage.dispose();
        skin.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public boolean isVisible() {
        return visible;
    }
}
