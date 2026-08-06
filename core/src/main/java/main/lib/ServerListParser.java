package main.lib;

import java.util.ArrayList;
import java.util.List;

public final class ServerListParser {

    private ServerListParser() {
    }

    public static final class Result {
        public final String[][] names;
        public final String[][] hosts;
        public final int[][] ports;

        Result(String[][] names, String[][] hosts, int[][] ports) {
            this.names = names;
            this.hosts = hosts;
            this.ports = ports;
        }
    }

    public static Result parse(String serverData) {
        if (serverData == null || serverData.isEmpty()) {
            return null;
        }

        String normalized = serverData.replace("\r\n", "\n").replace('\r', '\n');
        String[] chunks = normalized.split("\\*", -1);
        List<String[]> namesList = new ArrayList<>();
        List<String[]> hostsList = new ArrayList<>();
        List<int[]> portsList = new ArrayList<>();

        for (int i = 1; i < chunks.length; i++) {
            String chunk = chunks[i].trim();
            if (chunk.isEmpty()) {
                continue;
            }

            List<String> lines = new ArrayList<>();
            for (String raw : chunk.split("\n", -1)) {
                String line = sanitizeLine(raw);
                if (line == null) {
                    continue;
                }
                lines.add(line);
            }
            if (lines.isEmpty()) {
                continue;
            }

            String groupName = lines.get(0);
            List<String> displayNames = new ArrayList<>();
            List<String> hosts = new ArrayList<>();
            List<Integer> ports = new ArrayList<>();
            displayNames.add(groupName);

            for (int j = 1; j < lines.size(); j++) {
                ServerLine server = parseServerLine(lines.get(j));
                if (server == null) {
                    continue;
                }
                displayNames.add(server.name);
                hosts.add(server.host);
                ports.add(server.port);
            }

            if (hosts.isEmpty()) {
                continue;
            }

            namesList.add(displayNames.toArray(new String[0]));
            hostsList.add(hosts.toArray(new String[0]));
            int[] portArr = new int[ports.size()];
            for (int k = 0; k < ports.size(); k++) {
                portArr[k] = ports.get(k);
            }
            portsList.add(portArr);
        }

        if (hostsList.isEmpty()) {
            return null;
        }

        return new Result(
            namesList.toArray(new String[0][]),
            hostsList.toArray(new String[0][]),
            portsList.toArray(new int[0][])
        );
    }

    private static String sanitizeLine(String raw) {
        if (raw == null) {
            return null;
        }
        String line = raw.trim();
        while (line.endsWith(";")) {
            line = line.substring(0, line.length() - 1).trim();
        }
        if (line.isEmpty() || "_".equals(line)) {
            return null;
        }
        return line;
    }

    private static ServerLine parseServerLine(String line) {
        int firstColon = line.indexOf(':');
        int lastColon = line.lastIndexOf(':');
        if (firstColon < 0 || lastColon <= firstColon) {
            return null;
        }

        String name = line.substring(0, firstColon).trim();
        String host = line.substring(firstColon + 1, lastColon).trim();
        String portStr = line.substring(lastColon + 1).trim();
        while (portStr.endsWith(";")) {
            portStr = portStr.substring(0, portStr.length() - 1).trim();
        }
        if (name.isEmpty() || host.isEmpty() || portStr.isEmpty()) {
            return null;
        }

        try {
            return new ServerLine(name, host, Integer.parseInt(portStr));
        } catch (NumberFormatException ignored) {
            return null;
        }
    }

    private static final class ServerLine {
        final String name;
        final String host;
        final int port;

        ServerLine(String name, String host, int port) {
            this.name = name;
            this.host = host;
            this.port = port;
        }
    }
}
