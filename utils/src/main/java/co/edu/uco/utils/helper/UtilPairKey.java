package co.edu.uco.utils.helper;

public final class UtilPairKey {
    private UtilPairKey() {
    }

    public static String publicKeyFormatted(String publicKey) {
        return publicKey
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s+", "");
    }

    public static String privateKeyFormatted(String privateKey) {
        return privateKey
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s+", "");
    }

    public static String rebuildPublicKey(String publicKey) {
        // Dividir cada 64 caracteres para que tenga el formato PEM válido
        StringBuilder formattedKey = new StringBuilder();
        formattedKey.append("-----BEGIN PUBLIC KEY-----\n");

        int index = 0;
        while (index < publicKey.length()) {
            formattedKey.append(publicKey, index, Math.min(index + 64, publicKey.length())).append("\n");
            index += 64;
        }

        formattedKey.append("-----END PUBLIC KEY-----");
        return formattedKey.toString();
    }

    public static String rebuildPrivateKey(String privateKey) {
        // Dividir cada 64 caracteres para que tenga el formato PEM válido
        StringBuilder formattedKey = new StringBuilder();
        formattedKey.append("-----BEGIN PRIVATE KEY-----\n");

        int index = 0;
        while (index < privateKey.length()) {
            formattedKey.append(privateKey, index, Math.min(index + 64, privateKey.length())).append("\n");
            index += 64;
        }

        formattedKey.append("-----END PRIVATE KEY-----");
        return formattedKey.toString();
    }
}
