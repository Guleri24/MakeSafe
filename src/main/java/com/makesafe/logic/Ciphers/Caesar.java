package com.makesafe.logic.Ciphers;

import com.makesafe.logic.Cipher;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.File;

public class Caesar implements Cipher {
    private int shiftBy;
    // Encryption Method
    public static String encrypt(File file) {

        return "encrypted";
    }

    @Override
    public StringBuffer encrypt(String string) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < string.length(); i++) {
            if (Character.isUpperCase(string.charAt(i))) {
                char ch = (char) (((int) string.charAt(i) +
                        shiftBy - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) string.charAt(i) +
                        shiftBy - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }

    @Override
    public StringBuffer decrypt(String string) {
        int shiftBy = 5;
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < string.length(); i++) {
            if (Character.isUpperCase(string.charAt(i))) {
                char ch = (char) (((int) string.charAt(i) +
                        shiftBy - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) string.charAt(i) +
                        shiftBy - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }

    public HBox specificFunctions() {
        Text shift = new Text("Shift By");
        TextField shiftBy = new TextField();
        System.out.println(shiftBy.getText());

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

    public void setShiftBy(int shiftBy) {
        this.shiftBy = shiftBy;
    }
}
