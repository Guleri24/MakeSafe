package com.makesafe.logic.Ciphers;

import com.makesafe.logic.Cipher;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Playfair implements Cipher {
        static void getKeyMatrix(String key, int[][] keyMatrix)
        {
            int k = 0;
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    keyMatrix[i][j] = (key.charAt(k)) % 65;
                    k++;
                }
            }
        }

        static void encrypt(int[][] cipherMatrix,
                            int[][] keyMatrix,
                            int[][] messageVector)
        {
            int x, i, j;
            for (i = 0; i < 3; i++)
            {
                for (j = 0; j < 1; j++)
                {
                    cipherMatrix[i][j] = 0;

                    for (x = 0; x < 3; x++)
                    {
                        cipherMatrix[i][j] +=
                                keyMatrix[i][x] * messageVector[x][j];
                    }

                    cipherMatrix[i][j] = cipherMatrix[i][j] % 26;
                }
            }
        }

        static void HillCipher(String message, String key)
        {
            int [][]keyMatrix = new int[3][3];
            getKeyMatrix(key, keyMatrix);

            int [][]messageVector = new int[3][1];

            for (int i = 0; i < 3; i++)
                messageVector[i][0] = (message.charAt(i)) % 65;

            int [][]cipherMatrix = new int[3][1];

            encrypt(cipherMatrix, keyMatrix, messageVector);

            StringBuilder CipherText= new StringBuilder();

            for (int i = 0; i < 3; i++)
                CipherText.append((char) (cipherMatrix[i][0] + 65));

            System.out.print(" Ciphertext:" + CipherText);
        }


    @Override
    public StringBuffer encrypt(String string) {
        return null;
    }

    @Override
    public StringBuffer decrypt(String string) {
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
