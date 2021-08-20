package com.makesafe.logic.Ciphers;

import com.makesafe.logic.Cipher;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Playfair implements Cipher {

    private final char[][] matrixArr = new char[5][5];
    private String keyword = "";
    private String key = "";

    public void setKey(String k) {
        StringBuilder kAdjust = new StringBuilder();
        boolean flag = false;
        kAdjust.append(k.charAt(0));

        for (int i = 1; i < k.length(); i++) {
            for (int j = 0; j < kAdjust.length(); j++) {
                if (k.charAt(i) == kAdjust.charAt(j)) {
                    flag = true;
                }
            }
            if (!flag) {
                kAdjust.append(k.charAt(i));
            }
            flag = false;
        }
        keyword = kAdjust.toString();
    }

    private void keyGen() {
        boolean flag = true;
        char current;
        key = keyword;

        for (int i = 0; i < 26; i++) {
            current = (char) (i + 97);
            if (current == 'j') {
                continue;
            }
            for (int j = 0; j < keyword.length(); j++) {
                if (current == keyword.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                key += current;
            }
            flag = true;
        }
        System.out.println(key);
        matrix();
    }

    private void matrix() {
        int counter = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrixArr[i][j] = key.charAt(counter);
                System.out.print(matrixArr[i][j] + " ");
                counter++;
            }
            System.out.println();
        }
    }

    private String format(String oldText) {
        int i = 0;
        int len = 0;
        StringBuilder text = new StringBuilder();
        len = oldText.length();

        for (int tmp = 0; tmp < len; tmp++) {
            if (oldText.charAt(tmp) == 'j') {
                text.append('i');
            } else {
                text.append(oldText.charAt(tmp));
            }
        }
        len = text.length();
        for (i = 0; i < len; i += 2) {
            if (text.charAt(i + 1) == text.charAt(i)) {
                text = new StringBuilder(text.substring(0, i + 1) + 'x' + text.substring(i + 1));
            }
        }
        return text.toString();
    }

    private String[] divide2Pairs(String newString) {
        String original = format(newString);
        int size = original.length();
        if (size % 2 != 0) {
            size++;
            original += 'x';
        }
        String[] x = new String[size / 2];
        int counter = 0;
        for (int i = 0; i < size / 2; i++) {
            x[i] = original.substring(counter, counter + 2);
            counter += 2;
        }
        return x;
    }

    private int[] getDimensions(char letter) {
        int[] key = new int[2];
        if (letter == 'j') {
            letter = 'i';
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrixArr[i][j] == letter) {
                    key[0] = i;
                    key[1] = j;
                    break;
                }
            }
        }
        return key;
    }

    private StringBuilder encryptMessage(String source) {
        String[] srcArr = divide2Pairs(source);
        StringBuilder code = new StringBuilder();
        char one;
        char two;
        int[] part1 = new int[2];
        int[] part2 = new int[2];
        for (String s : srcArr) {
            one = s.charAt(0);
            two = s.charAt(1);
            part1 = getDimensions(one);
            part2 = getDimensions(two);
            if (part1[0] == part2[0]) {
                if (part1[1] < 4) {
                    part1[1]++;
                } else {
                    part1[1] = 0;
                }
                if (part2[1] < 4) {
                    part2[1]++;
                } else {
                    part2[1] = 0;
                }
            } else if (part1[1] == part2[1]) {
                if (part1[0] < 4) {
                    part1[0]++;
                } else {
                    part1[0] = 0;
                }
                if (part2[0] < 4) {
                    part2[0]++;
                } else {
                    part2[0] = 0;
                }
            } else {
                int temp = part1[1];
                part1[1] = part2[1];
                part2[1] = temp;
            }
            code.append(matrixArr[part1[0]][part1[1]]
                                + matrixArr[part2[0]][part2[1]]);
        }
        return code;
    }


    public StringBuffer encrypt(String string, String keyword) {
        setKey(keyword);
        keyGen();

        if (string.length() %2 ==0) {
            System.out.println("Encryption " + encryptMessage(string));
        }
        else {
            System.out.println("Message length should be even");
        }
        return null;
    }

    @Override
    public HBox specificFunctions() {
        Text key = new Text("Key");
        TextField keyEntered = new TextField();
        System.out.println(keyEntered.getText());

        return new HBox(key, keyEntered);
    }

    @Override
    public String cipherInfo() {
        return null;
    }
}
