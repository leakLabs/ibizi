package edu.lab.lab1;

public class TranspositionCipher {
    // Ключ k1 задает порядок записи текста в строки матрицы
    private final static int[] k1 = {1, 5, 4, 3, 2};
    // Ключ k2 задает порядок чтения текста из столбцов матрицы
    private final static int[] k2 = {1, 4, 5, 3, 2};
    // Размер матрицы (количество строк и столбцов)
    private final static int SIZE = 5;

    // Метод шифрования текста
    public static String encrypt(String in) {
        // Матрица для записи текста по алгоритму
        char[][] matrix = new char[SIZE][SIZE];
        // Строка для накопления зашифрованного текста
        StringBuilder sb = new StringBuilder(SIZE * SIZE);

        int pos = 0; // Указатель на текущую позицию в строке
        // Заполнение матрицы по ключу k1 и k2
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[k2[i] - 1][k1[j] - 1] = in.charAt(pos++);
            }
        }

        // Считывание данных из матрицы по столбцам
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sb.append(matrix[j][i]);
            }
        }
        return sb.toString(); // Возвращаем зашифрованный текст
    }

    // Метод расшифровки текста
    public static String decrypt(String in) {
        // Матрица для записи текста по алгоритму
        char[][] matrix = new char[SIZE][SIZE];
        // Строка для накопления расшифрованного текста
        StringBuilder sb = new StringBuilder(SIZE * SIZE);

        int pos = 0; // Указатель на текущую позицию в строке
        // Заполнение матрицы по ключу k1 и k2
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[arrSearch(k1, i + 1)][arrSearch(k2, j + 1)] = in.charAt(pos++);
            }
        }

        // Считывание данных из матрицы по строкам
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sb.append(matrix[j][i]);
            }
        }
        return sb.toString(); // Возвращаем расшифрованный текст
    }

    // Вспомогательный метод для поиска индекса ключа
    private static int arrSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1; // Если ключ не найден
    }
}