package edu.lab.lab2;

public class VigenereCipher {
    private static final int N = 26;

    public static String encrypt(String inText, String key) {
        int keyPos = 0;
        StringBuilder stringBuilder = new StringBuilder(inText.length());

        for (char letter : inText.toCharArray()) {
            stringBuilder.append((char) ((letter + key.charAt(keyPos) - 2 * 'A') % N + 'A'));
            keyPos = (keyPos + 1) % key.length();
        }

        return stringBuilder.toString();
    }

    public static String decrypt(String inText, String key) {
        int keyPos = 0;
        StringBuilder stringBuilder = new StringBuilder(inText.length());

        for (char letter : inText.toCharArray()) {
            stringBuilder.append((char) ((letter + N - key.charAt(keyPos)) % N + 'A'));
            keyPos = (keyPos + 1) % key.length();
        }

        return stringBuilder.toString();
    }
}
