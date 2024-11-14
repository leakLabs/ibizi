package edu.lab;

import edu.lab.lab1.TranspositionCipher;
import edu.lab.lab2.VigenereCipher;

public class Main {
    public static void main(String[] args) {
//        String startStr = "шифрование_перестановкой_";
//        System.out.printf("Незашифрованное сообщение: %s\n", startStr);
//        String encStr = TranspositionCipher.encrypt(startStr);
//        System.out.printf("Зашифрованное сообщение: %s\n", encStr);
//
//        String decStr = TranspositionCipher.decrypt(encStr);
//        System.out.printf("Расшифрованное сообщение: %s\n", decStr);



        String startStr = "SHIFROVANIE";
        String key = "BOARD";

        System.out.printf("Незашифрованное сообщение: %s; Ключ: %s\n", startStr, key);
        String encStr = VigenereCipher.encrypt(startStr, key);
        System.out.printf("Зашифрованное сообщение: %s\n", encStr);

        String decStr = VigenereCipher.decrypt(encStr, key);
        System.out.printf("Расшифрованное сообщение: %s\n", decStr);
    }
}