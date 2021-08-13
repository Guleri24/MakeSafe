package com.makesafe.logic.Ciphers;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

public class CipherChoose {
    public ComboBox<Button> cipherChoose() {
        ComboBox<Button> ciphers = new ComboBox<>();
        Button Caesar = new Button("Caesar");
        Button Hill = new Button("Hill");
        Button Playfair = new Button("Playfair");

        ciphers.getItems().addAll(Caesar, Hill, Playfair);
        return ciphers;
    }

    public void cipherInfo() {

    }
}
