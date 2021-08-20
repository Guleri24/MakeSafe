package com.makesafe.logic.Ciphers;

import com.makesafe.logic.Cipher;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;


public class Hill implements Cipher {

    public int[] resultMatrix;
    private int[][] keyMatrix;
    private int[] lineMatrix;
    private String key;

    public void divide(String temp, int s) {
        while (temp.length() > s) {
            String sub = temp.substring(0, s);
            temp = temp.substring(s);
            perform(sub);
        }

        if (temp.length() == s) {
            perform(temp);
        } else {
            StringBuilder tempBuilder = new StringBuilder(temp);
            tempBuilder.append("x".repeat(Math.max(0, s - tempBuilder.length())));
            perform(tempBuilder.toString());
        }
    }

    private void perform(String line) {
        lineToMatrix(line);
        lineMultiplyKey(line.length());
        result(line.length());
    }

    private void keyToMatrix(String key, int len) {
        keyMatrix = new int[len][len];
        int c = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                keyMatrix[i][j] = ((int) key.charAt(c)) - 97;
                c++;
            }
        }
    }

    private void lineToMatrix(String line) {
        lineMatrix = new int[line.length()];
        for (int i = 0; i < line.length(); i++) {
            lineMatrix[i] = (int) line.charAt(i) - 97;
        }
    }

    private void lineMultiplyKey(int len) {
        resultMatrix = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                resultMatrix[i] += keyMatrix[i][j] * lineMatrix[j];
            }
            resultMatrix[i] %= 26;
        }
    }

    private void result(int len) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            result.append((char) (resultMatrix[i] + 97));
        }
        System.out.print(result);
    }

    private boolean check(String key, int len) {
        keyToMatrix(key, len);
        int d = determinant(keyMatrix, len);
        d %= 26;
        if (d == 0) {
            System.out.println("Invalid key!!! Key is not invertible because determinant = 0");
            return false;
        } else if (d % 2 == 0 || d % 13 == 0) {
            System.out.println("Invalid key!!! Key is not invertible because determinant has common factor with 26");
            return false;
        } else {
            return true;
        }
    }

    public int determinant(int[][] A, int N) {
        int determinant;
        if (N == 1) {
            determinant = A[0][0];
        } else if (N == 2) {
            determinant = A[0][0] * A[1][1] - A[1][0] * A[0][1];
        } else {
            determinant = 0;
            for (int j1 = 0; j1 < N; j1++) {
                int[][] m = new int[N - 1][N - 1];
                for (int i = 1; i < N; i++) {
                    int j2 = 0;
                    for (int j = 0; j < N; j++) {
                        if (j == j1) {
                            continue;
                        }
                        m[i - 1][j2] = A[i][j];
                        j2++;
                    }
                }
                determinant += Math.pow(-1.0, 1.0 + j1 + 1.0) * A[0][j1] * determinant(m, N - 1);
            }
        }
        return determinant;
    }

    private void cofact(int[][] num, int f) {
        int[][] b;
        int[][] fac;
        b = new int[f][f];
        fac = new int[f][f];

        int p, q, m, n, i, j;
        for (q = 0; q < f; q++) {
            for (p = 0; p < f; p++) {
                m = 0;
                n = 0;
                for (i = 0; i < f; i++) {
                    for (j = 0; j < f; j++) {
                        b[i][j] = 0;
                        if (i != q && j != p) {
                            b[m][n] = num[i][j];
                            if (n < (f - 2)) {
                                n++;
                            } else {
                                n = 0;
                                m++;
                            }
                        }
                    }
                }
                fac[q][p] = (int) Math.pow(-1, q + p) * determinant(b, f - 1);
            }
        }
        trans(fac, f);
    }

    void trans(int[][] fac, int r) {
        int i, j;
        int[][] b;
        int[][] inv;
        b = new int[r][r];
        inv = new int[r][r];
        int d = determinant(keyMatrix, r);
        int mi = mi(d % 26);
        mi %= 26;
        if (mi < 0) {
            mi += 26;
        }
        for (i = 0; i < r; i++) {
            for (j = 0; j < r; j++) {
                b[i][j] = fac[j][i];
            }
        }
        for (i = 0; i < r; i++) {
            for (j = 0; j < r; j++) {
                inv[i][j] = b[i][j] % 26;
                if (inv[i][j] < 0) {
                    inv[i][j] += 26;
                }
                inv[i][j] *= mi;
                inv[i][j] %= 26;
            }
        }
        matrixToInvKey(inv, r);
    }

    public int mi(int d) {
        int q, r1, r2, r, t1, t2, t;
        r1 = 26;
        r2 = d;
        t1 = 0;
        t2 = 1;

        while (r1 != 1 && r2 != 0) {
            q = r1 / r2;
            r = r1 % r2;
            t = t1 - (t2 * q);
            r1 = r2;
            r2 = r;
            t1 = t2;
            t2 = t;
        }
        return (t1 + t2);
    }

    public void matrixToInvKey(int[][] inv, int n) {
        StringBuilder invKey = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                invKey.append((char) (inv[i][j] + 97));
            }
        }
        System.out.println("\nInverse Key : " + invKey);
    }


    public void encrypt(String string, String key) {
        double sq = Math.sqrt(key.length());
        if (sq != (long) sq) {
            System.out.println("Invalid key length!!! " +
                                       "Doesn't form a square matrix");
        } else {
            int s = (int) sq;
            if (check(key, s)) {
                divide(string, s);
                cofact(keyMatrix, s);
            }
        }
    }

    public void decrypt(String string, String key) {
        double sq = Math.sqrt(key.length());
        if (sq != (long) sq) {
            System.out.println("Invalid key length!!! " +
                                       "Doesn't form a square matrix");
        } else {
            int s = (int) sq;
            if (check(key, s)) {
                divide(string, s);
                cofact(keyMatrix, s);
            }
        }
    }

    @Override
    public HBox specificFunctions() {
        Text Key = new Text("Enter Key (9 characters)");
        TextField key = new TextField();
        System.out.println(key.getText());
        this.key = key.getText();
        return new HBox(Key, key);
    }

    @Override
    public String cipherInfo() {
        return null;
    }
}
