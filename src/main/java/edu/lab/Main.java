package edu.lab;

import edu.lab.lab1.TranspositionCipher;

public class Main {
    public static void main(String[] args) {
        String startStr = "шифрование_перестановкой_";
        System.out.printf("Незашифрованное сообщение: %s\n", startStr);
        String encStr = TranspositionCipher.encrypt(startStr);
        System.out.printf("Зашифрованное сообщение: %s\n", encStr);

        String decStr = TranspositionCipher.decrypt(encStr);
        System.out.printf("Расшифрованное сообщение: %s\n", decStr);
    }
}