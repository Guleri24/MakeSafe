package com.makesafe.logic;

import javafx.scene.layout.HBox;

public interface Cipher {
    String encrypt(String string);

    String decrypt(String string);

    HBox specificFunctions();

    String cipherInfo();
}
