package com.makesafe.logic.Ciphers;

import javafx.scene.text.Text;

import java.io.File;

public class Caesar {
    private static final int ALPAHSIZE = 26;
    private static final char[] largeAlpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final char[] smallAlpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    protected char[] encrypt = new char[ALPAHSIZE];
    protected char[] decrypt = new char[ALPAHSIZE];

    public Caesar() {
        for (int i = 0; i < ALPAHSIZE; i++) {

            // encryption and decryption for small alphabets
            encrypt[i] = smallAlpha[(i + 3) % ALPAHSIZE];
            decrypt[encrypt[i] - 'a'] = smallAlpha[i];
        }
    }

    // Encryption Method
    public String encrypt(File file) {
        /*char[] mess = file.toCharArray();
        for (int i = 0; i < mess.length; i++)
            if (Character.isLowerCase(mess[i]))
                mess[i] = encrypt[mess[i] - 'a'];
            else if (Character.isLowerCase(mess[i]))
                mess[i] = encrypt[mess[i] - 'A'];
        return Arrays.toString(mess);*/
        return "encrypted";
    }

    // Decryption Method \
    public String decrypt(File file) {
       /* char[] mess = secret.toCharArray();
        for (int i = 0; i < mess.length; i++)
            if (Character.isLowerCase(mess[i]))
                mess[i] = decrypt[mess[i] - 'a'];
            else if (Character.isUpperCase(mess[i]))
                mess[i] = decrypt[mess[i] - 'A'];
        return Arrays.toString(mess);*/
        return "decrypted";

    }

    public  String cipherInfo() {
        return "The Caesar cipher is one of the earliest known and simplest ciphers.\n " +
                "It is a type of substitution cipher in which each letter in the plaintext\n " +
                "is 'shifted' a certain number of places down the alphabet. For example, with \n" +
                " a shift of 1, A would be replaced by B, B would become C, and so on. The method\n" +
                " is named after Julius Caesar, who apparently used it to communicate with his generals.";
    }
}
