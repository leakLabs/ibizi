package edu.lab;

import edu.lab.lab1.TranspositionCipher;
import edu.lab.lab2.VigenereCipher;
import edu.lab.lab3.RSACipher;
import edu.lab.lab6.MatrixUI;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        // Открытый текст для шифрования
//        String startStr = "шифрование_перестановкой_";
//        System.out.printf("Незашифрованное сообщение: %s\n", startStr);
//
//        // Шифрование текста
//        String encStr = TranspositionCipher.encrypt(startStr);
//        System.out.printf("Зашифрованное сообщение: %s\n", encStr);
//
//        // Расшифровка текста
//        String decStr = TranspositionCipher.decrypt(encStr);
//        System.out.printf("Расшифрованное сообщение: %s\n", decStr);


//        String startStr = "SHIFROVANIE";
//        String key = "BOARD";
//
//        System.out.printf("Незашифрованное сообщение: %s; Ключ: %s\n", startStr, key);
//        String encStr = VigenereCipher.encrypt(startStr, key);
//        System.out.printf("Зашифрованное сообщение: %s\n", encStr);
//
//        String decStr = VigenereCipher.decrypt(encStr, key);
//        System.out.printf("Расшифрованное сообщение: %s\n", decStr);

//        RSACipher cipher = new RSACipher();
//        cipher.generateKeys(5, 19);
//        String startStr = "BOARD";
//        int[] startArr = RSACipher.strToIntArr(startStr);
//        System.out.printf("Незашифрованное сообщение: %s %s\n", startStr, Arrays.toString(startArr));
//        System.out.printf(cipher.getKeys() + '\n');
//        int[] encArr = cipher.encrypt(startArr);
//        System.out.printf("Зашифрованное сообщение: %s\n", Arrays.toString(encArr));
//        int[] decArr = cipher.decrypt(encArr);
//        String decStr = RSACipher.intArrToStr(decArr);
//        System.out.printf("Расшифрованное сообщение: %s \"%s\"\n",Arrays.toString(decArr) , decStr);

        MatrixUI.run();
    }
}