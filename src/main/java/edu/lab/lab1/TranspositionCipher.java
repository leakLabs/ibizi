package edu.lab.lab1;

public class TranspositionCipher {
    private final static int[] k1 = {1, 5, 4, 3, 2};
    private final static int[] k2 = {1, 4, 5, 3, 2};
    private final static int SIZE = 5;

    public static String encrypt(String in) {
        char[][] matrix = new char[SIZE][SIZE];
        StringBuilder sb = new StringBuilder(SIZE * SIZE);

        int pos = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[k2[i] - 1][k1[j] - 1] = in.charAt(pos++);
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sb.append(matrix[j][i]);
            }
        }
        return sb.toString();
    }

    public static String decrypt(String in) {
        char[][] matrix = new char[SIZE][SIZE];
        StringBuilder sb = new StringBuilder(SIZE * SIZE);

        int pos = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[arrSearch(k1, i + 1)][arrSearch(k2, j + 1)] = in.charAt(pos++);
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sb.append(matrix[j][i]);
            }
        }
        return sb.toString();
    }

    private static int arrSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }
}
