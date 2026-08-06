package main.lib;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class ServerManager {
    private static String key = "AVATAR1503mnvajsnvjnas@#$%#@$@#";

    public static String URL_GET = "00000000000000000000000000000000000000000000000000000000000000292235247b7d1e040603435f4f5044415a44445f52436f42524457215629532078352c35:415641544152313530336d6e76616a736e766a6e6173402324252340244023";
    public static String serverGroup = "142625353537:31326533656638333230383139613737623962643362363564633362613866373961633831303662396430613761313533353038636666653038316436386339";
    public static String serverName = "142625353537:31326533656638333230383139613737623962643362363564633362613866373961633831303662396430613761313533353038636666653038316436386339";
    public static String serverIp = "000000000000000000000000000000000000000000000000000000000000000000000000007064767a717c061c05:415641544152363234403a3836376e662a23343332342e343233342e3432333432342e3234";

    public static String encrypt(String input) {
        try {
            String xorEncrypted = xorEncryptDecrypt(input);
            String hmac = calculateHMAC(xorEncrypted);
            return toHex(xorEncrypted.getBytes(StandardCharsets.UTF_8)) + ":" + toHex(hmac.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {

        }
        return "";
    }

    public static String decrypt(String encrypted) {
        try {
            String[] parts = encrypted.split(":");
            if (parts.length != 2) {
                return encrypted;
            }
            String hexEncryptedData = parts[0];
            String hexReceivedHmac = parts[1];
            String xorEncrypted = new String(fromHex(hexEncryptedData), StandardCharsets.UTF_8);
            String receivedHmac = new String(fromHex(hexReceivedHmac), StandardCharsets.UTF_8);
            String calculatedHmac = calculateHMAC(xorEncrypted);
            if (!receivedHmac.equals(calculatedHmac)) {
                return encrypted;
            }
            return xorEncryptDecrypt(xorEncrypted);
        } catch (Exception e) {

        }
        return encrypted;
    }

    private static byte[] fromHex(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }

    public static String calculateHMAC(String data) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKey);
        byte[] hmacBytes = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return toHex(hmacBytes);
    }

    private static String toHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static String xorEncryptDecrypt(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            output.append((char) (input.charAt(i) ^ key.charAt(i % key.length())));
        }
        return output.toString();
    }

    public static String decrypt2(String encrypted) {
        String[] parts = encrypted.split(":");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Dữ liệu bị lỗi hoặc không hợp lệ.");
        }

        String hexEncodedData = parts[0];
        String hexSalt = parts[1];
        String decoded = new String(fromHex(hexEncodedData), StandardCharsets.UTF_8);
        String salt = new String(fromHex(hexSalt), StandardCharsets.UTF_8);
        String xorDecrypted = xorEncryptDecrypt(decoded);
        return xorDecrypted.substring(salt.length());
    }
}
