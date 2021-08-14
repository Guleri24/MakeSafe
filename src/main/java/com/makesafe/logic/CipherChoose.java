package com.makesafe.logic;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class CipherChoose {
    public ComboBox<Button> cipherChoose() {
        ComboBox<Button> ciphers = new ComboBox<>();
        Button caesar = new Button("Caesar");

        Button hill = new Button("Hill");
        Button playfair = new Button("Playfair");

        ciphers.getItems().addAll(caesar, hill, playfair);
        return ciphers;
    }

    public void cipherInfo() {

    }
}
