package main;

import avt.Avatar;
import avt.AvatarData;
import avt.CRes;
import avt.IndexPlayer;
import avt.LoginScr;
import avt.OnScreen;
import avt.SplashScr;
import java.io.InputStream;
import java.util.Vector;
import javax.microedition.io.ConnectionNotFoundException;
import main.lib.NativeHttpClient;
import main.screen.Main;

public final class GameMidlet extends javax.microedition.midlet.MIDlet {
    public static final String APP_VERSION = "2.5.8";
    public static String[][][] nameSV = new String[][][]{
        new String[][]{ new String[]{ "Thanh Ngan", "Thanh Ngan" } },
        new String[][]{ new String[]{ "Thanh Ngan", "Thanh Ngan" } }
    };
    public static String[][][] ipSV = new String[][][]{
        new String[][]{ new String[]{ "160.30.112.31" } },
        new String[][]{ new String[]{ "160.30.112.31" } }
    };
    public static int[][][] PORT = new int[][][]{
        new int[][]{ new int[]{ 19128 } },
        new int[][]{ new int[]{ 19128 } }
    };
    public static final String[][] linkGetHost = new String[][]{
        new String[0],
        new String[0]
    };
    public static String srvListFallbackLeadingSeg = "1.0";
    public static String srvListFallbackGroupTitle = "Thanh Ngan";
    public static short srvListImgIconCluster = 1;
    public static short srvListImgIconCity = 1;
    public static int CLIENT_TYPE = 8;
    public static byte PROVIDER = -1;
    public static String g;
    public static Canvas canvas;
    public static GameMidlet instance;
    public static Avatar avatar;
    public static IndexPlayer myIndexP;
    public static Vector listContainer;
    public static int l;
    public static String m;
    public static String n;

    private static boolean globalInitialized;

    public static void setDefaultServerList() {
        nameSV = new String[][][]{
            new String[][]{ new String[]{ "Thanh Ngan", "Thanh Ngan" } },
            new String[][]{ new String[]{ "Thanh Ngan", "Thanh Ngan" } }
        };
        ipSV = new String[][][]{
            new String[][]{ new String[]{ "160.30.112.31" } },
            new String[][]{ new String[]{ "160.30.112.31" } }
        };
        PORT = new int[][][]{
            new int[][]{ new int[]{ 19128 } },
            new int[][]{ new int[]{ 19128 } }
        };
    }

    public static void initGlobal() {
        if (globalInitialized) {
            return;
        }
        globalInitialized = true;
        setDefaultServerList();
        instance = new GameMidlet();
        instance.loadSharedConfig();
    }


  
    public static void bootstrapTab(Canvas targetCanvas, main.screen.tab258.MainTab258 tab) {
        tab.avatar = new Avatar();
        tab.myIndexP = new IndexPlayer();
        bindTab(tab);
        SplashScr.gI().switchToMe();
    }

 
    public static void bindTab(main.screen.tab258.MainTab258 tab) {
        canvas = tab.gameCanvas;
        Canvas.instance = tab.gameCanvas;
        avatar = tab.avatar;
        myIndexP = tab.myIndexP;
    }

    /** @deprecated use {@link #initGlobal()} + {@link #bootstrapTab(Canvas, main.screen.tab258.MainTab258)} */
    public static void init() {
        initGlobal();
        main.screen.tab258.MainTab258 tab = new main.screen.tab258.MainTab258(0);
        tab.gameCanvas = new Canvas();
        bootstrapTab(tab.gameCanvas, tab);
    }

    private void loadSharedConfig() {
        try {
            InputStream providerStream = Main.instance.getResourceAsStream("provider.txt");
            if (providerStream != null) {
                StringBuilder sb = new StringBuilder();
                int ch;
                while ((ch = providerStream.read()) != -1) {
                    sb.append((char) ch);
                }
                PROVIDER = Byte.parseByte(sb.toString().trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (PROVIDER == -1) {
            AvatarData.d();
        }

        try {
            InputStream agentStream = Main.instance.getResourceAsStream("agent.txt");
            if (agentStream != null) {
                StringBuilder sb = new StringBuilder();
                int ch;
                while ((ch = agentStream.read()) != -1) {
                    sb.append((char) ch);
                }
                g = sb.toString();
            }
        } catch (Exception ignored) {
        }
    }

    public void destroyApp(boolean var1) {
        notifyDestroyed();
    }

    public static void exit() {
        // Tránh đóng hẳn app khi người dùng đang ở trong game/map;
        // ưu tiên quay về Login để giữ đúng luồng thao tác.
        try {
            if (Canvas.currentMyScreen != LoginScr.me) {
                OnScreen.isOngame = false;
                Canvas.endDlg();
                Canvas.menuMain = null;
                LoginScr.gI().switchToMe();
                return;
            }
        } catch (Exception ignored) {
        }

        if (instance != null) {
            instance.destroyApp(true);
        } else {
            System.exit(0);
        }
    }

    protected void pauseApp() {
    }

    protected void startApp() {
    }

    public static void doSendSMS(String var0, String var1) {
        (new Thread(new SMSMessageSender(var1, var0))).start();
    }

    public static String createhttpconnect(String var0) {
        return NativeHttpClient.getResponseSync(var0);
    }

    public static void flatForm(String var0) {
        try {
            instance.platformRequest(var0);
            instance.notifyDestroyed();
        } catch (ConnectionNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void parseServerList(String serverData) {
        if (serverData == null || serverData.isEmpty()) {
            return;
        }
        try {
            String[] groups = serverData.split("\\*");
            int n = groups.length - 1;
            if (n <= 0) {
                return;
            }
            nameSV[0] = new String[n][];
            ipSV[0] = new String[n][];
            PORT[0] = new int[n][];
            for (int i = 1; i < groups.length; i++) {
                String[] lines = groups[i].split("\n");
                nameSV[0][i - 1] = new String[lines.length - 1];
                ipSV[0][i - 1] = new String[lines.length - 2];
                PORT[0][i - 1] = new int[lines.length - 2];
                nameSV[0][i - 1][0] = lines[0];
                for (int j = 1; j < lines.length - 1; j++) {
                    String[] parts = lines[j].split(":");
                    nameSV[0][i - 1][j] = parts[0];
                    ipSV[0][i - 1][j - 1] = parts[1];
                    PORT[0][i - 1][j - 1] = parsePort(parts.length > 2 ? parts[2] : "0");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int parsePort(String raw) {
        if (raw == null) {
            return 0;
        }
        String s = raw.trim();
        int semi = s.indexOf(';');
        if (semi >= 0) {
            s = s.substring(0, semi).trim();
        }
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            StringBuilder digits = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    digits.append(c);
                }
            }
            return digits.length() > 0 ? Integer.parseInt(digits.toString()) : 0;
        }
    }
}
