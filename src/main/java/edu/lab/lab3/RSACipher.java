package edu.lab.lab3;

import java.math.BigInteger;
import java.util.Arrays;

import static java.lang.Math.min;

public class RSACipher {
    private int p, q, n, fn, e, d;

    public void generateKeys(int p_in, int q_in) {
        p = p_in;
        q = q_in;
        n = p * q;
        fn = (p - 1) * (q - 1);
        generate_e();

        int x = extendedGCD(e, fn)[1];
        d = (x % fn + fn) % fn;
    }

    public String getKeys() {
        return String.format("φ(n): %d; открытый ключ: {%d, %d}; закрытый ключ: {%d, %d}", fn, e, n, d, n);
    }

    static public int[] strToIntArr(String str) {
        return str.chars().map(ch -> ch - 'A' + 1).toArray();
    }

    static public String intArrToStr(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder(arr.length);
        for (int let : arr) {
            stringBuilder.append((char) (let + 'A' - 1));
        }
        return stringBuilder.toString();
    }

    public int[] encrypt(int[] in) {
        return Arrays.stream(in)
                //.map(num -> (int) (pow(num, e) % (long) n))
                .map(num -> BigInteger.valueOf(num).modPow(BigInteger.valueOf(e), BigInteger.valueOf(n)).intValue())
                .toArray();
    }

    public int[] decrypt(int[] in) {
        return Arrays.stream(in)
//                .map(num -> (int) (pow(num, d) % (long) n))
                .map(num -> BigInteger.valueOf(num).modPow(BigInteger.valueOf(d), BigInteger.valueOf(n)).intValue())
                .toArray();
    }

    private void generate_e() {
        for (int i = min(p, q) + 1; i < fn; i++) {
            if (extendedGCD(fn, i)[0] == 1) {
                e = i;
                return;
            }
        }
        throw new RuntimeException();
    }

    private static int[] extendedGCD(int a, int b) {
        if (b == 0) {
            return new int[]{a, 1, 0};
        }

        int[] result = extendedGCD(b, a % b);
        int gcd = result[0];
        int x1 = result[1];
        int y1 = result[2]; //x

        int y = x1 - (a / b) * y1;

        return new int[]{gcd, y1, y};
    }

    private long pow(int a, int b) {
        long result = 1;
        for (int i = 0; i < b; i++)
            result *= a;
        return result;
    }
}
