package com.makesafe.logic;

import javafx.scene.layout.HBox;

public interface Cipher {
    StringBuffer encrypt(String string);

    StringBuffer decrypt(String string);

    HBox specificFunctions();

    String cipherInfo();
}
