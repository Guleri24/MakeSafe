package com.makesafe.logic.Ciphers;

import com.makesafe.logic.Cipher;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.File;

public class Caesar implements Cipher {
    /*private static final int ALPAHSIZE = 26;
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
    }*/

    // Encryption Method
    public static String encrypt(File file) {

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

    @Override
    public String encrypt(String string) {
        return null;
    }

    @Override
    public String decrypt(String string) {
        return null;
    }

    public HBox specificFunctions() {
        Text shift = new Text("Shift By");
        TextField shiftBy = new TextField();
        System.out.println(shiftBy.getCharacters());

        return new HBox(shift, shiftBy);
    }

    public String cipherInfo() {
        return "The Caesar Cipher technique is one of the earliest and simplest method of \n" +
                "encryption technique. It’s simply a type of substitution cipher, i.e., \n" +
                "each letter of a given text is replaced by a letter some fixed number of\n" +
                "positions down the alphabet. For example with a shift of 1, A would be \n" +
                "replaced by B, B would become C, and so on. The method is apparently named \n" +
                "after Julius Caesar, who apparently used it to communicate with his officials. \n\n" +
                "Text : ABCDEFGHIJKLMNOPQRSTUVWXYZ\n" +
                "Shift: 23\n" +
                "Cipher: XYZABCDEFGHIJKLMNOPQRSTUVW\n" +
                "\n" +
                "Text : ATTACKATONCE\n" +
                "Shift: 4\n" +
                "Cipher: EXXEGOEXSRGI";
    }
}
