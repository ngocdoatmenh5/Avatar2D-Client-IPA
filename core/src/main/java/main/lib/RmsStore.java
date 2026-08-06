package main.lib;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

/**
 * LibGDX replacement for javax.microedition.rms.RecordStore.
 */
public final class RmsStore {
    private final String name;

    private RmsStore(String name) {
        this.name = name;
    }

    public static RmsStore openRecordStore(String recordStoreName, boolean createIfNecessary) {
        FileHandle dir = Gdx.files.local("rms");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        FileHandle file = dir.child(recordStoreName);
        if (!file.exists() && createIfNecessary) {
            file.writeBytes(new byte[0], false);
        }
        return new RmsStore(recordStoreName);
    }

    public int getNumRecords() {
        FileHandle file = file();
        if (!file.exists()) {
            return 0;
        }
        return file.readBytes().length > 0 ? 1 : 0;
    }

    public void addRecord(byte[] data, int offset, int length) {
        byte[] copy = new byte[length];
        System.arraycopy(data, offset, copy, 0, length);
        file().writeBytes(copy, false);
    }

    public void setRecord(int recordId, byte[] data, int offset, int length) {
        byte[] copy = new byte[length];
        System.arraycopy(data, offset, copy, 0, length);
        file().writeBytes(copy, false);
    }

    public byte[] getRecord(int recordId) {
        return file().readBytes();
    }

    public void closeRecordStore() {
    }

    public int getSizeAvailable() {
        return 1024 * 1024;
    }

    public int getSize() {
        FileHandle f = file();
        return f.exists() ? (int) f.length() : 0;
    }

    public static void deleteRecordStore(String recordStoreName) {
        FileHandle f = Gdx.files.local("rms/" + recordStoreName);
        if (f.exists()) {
            f.delete();
        }
    }

    public static String[] listRecordStores() {
        FileHandle dir = Gdx.files.local("rms");
        if (!dir.exists()) {
            return null;
        }
        FileHandle[] files = dir.list();
        if (files == null || files.length == 0) {
            return null;
        }
        String[] names = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            names[i] = files[i].name();
        }
        return names;
    }

    private FileHandle file() {
        return Gdx.files.local("rms/" + name);
    }
}
