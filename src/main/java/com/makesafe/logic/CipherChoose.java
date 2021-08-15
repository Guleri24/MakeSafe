package com.makesafe.logic;

import com.makesafe.logic.Ciphers.Ciphers;
import javafx.scene.control.ComboBox;

public class CipherChoose {
    public ComboBox<Ciphers> cipherChoose() {
        ComboBox<Ciphers> ciphers = new ComboBox<>();
        ciphers.getItems().setAll(Ciphers.values());
        return ciphers;
    }
}
