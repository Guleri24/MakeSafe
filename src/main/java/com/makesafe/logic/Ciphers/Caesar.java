package com.makesafe.logic.Ciphers;

import com.makesafe.logic.Cipher;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Caesar implements Cipher {
    private int shiftBy;

    public Caesar() {
        shiftBy = 3; //default shiftBy
    }

    public StringBuffer encrypt(String string) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            if (Character.isUpperCase(string.charAt(i))) {
                char ch = (char) ((int) string.charAt(i) + shiftBy);
                result.append(ch);
            } else {
                char ch = (char) ((int) string.charAt(i) + shiftBy);
                result.append(ch);
            }
        }
        return result;
    }

    public StringBuffer decrypt(String string) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            if (Character.isUpperCase(string.charAt(i))) {
                char ch = (char) ((int) string.charAt(i) - shiftBy);
                result.append(ch);
            } else {
                char ch = (char) ((int) string.charAt(i) - shiftBy);
                result.append(ch);
            }
        }
        return result;
    }

    @Override
    public HBox specificFunctions() {
        Text shift = new Text("Shift By");
        TextField shiftBy = new TextField();
        System.out.println(shiftBy.getText());
        this.shiftBy = Integer.parseInt(shiftBy.getText());
        return new HBox(shift, shiftBy);
    }

    @Override
    public String cipherInfo() {
        return "The Caesar Cipher technique is one of the earliest and simplest method of \n" +
                "encryption technique. It’s simply a type of substitution cipher, i.e., \n" +
                "each letter of a given text is replaced by a letter some fixed number of\n" +
                "positions down the alphabet. For example with a shift of 1, A would be \n" +
                "replaced by B, B would become C, and so on. The method is apparently named \n" +
                "after Julius Caesar, who apparently used it to communicate with his officials. \n" +
                "\n I modified this algorithm to work with other characters like special characters, digits, spaces, etc\n\n" +

                "Text : Gaius Julius Caesar (12 July 100 BC – 15 March 44 BC) was a Roman general and statesman.\n" +
                "Shift: 23\n" +
                "Cipher: Jdlxv#Mxolxv#Fdhvdu#+45#Mxo|#433#EF#‖#48#Pdufk#77#EF,#zdv#d#Urpdq#jhqhudo#dqg#vwdwhvpdq1\n\n" +
                "\n" +
                "Text : Live longer if you can!!!\n" +
                "Shift: 4\n" +
                "Cipher: Olyh#orqjhu#li#|rx#fdq$$$\n";
    }

}
