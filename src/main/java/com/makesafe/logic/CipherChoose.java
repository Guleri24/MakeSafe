package com.makesafe.logic;

import com.makesafe.logic.Ciphers.Caesar;
import com.makesafe.logic.Ciphers.Hill;
import com.makesafe.logic.Ciphers.Playfair;
import javafx.scene.control.ComboBox;

public class CipherChoose {
    public ComboBox<Ciphers> cipherChoose() {
        ComboBox<Ciphers> ciphers = new ComboBox<>();
        ciphers.getItems().setAll(Ciphers.values());
        return ciphers;
    }

    public enum Ciphers {
        CAESAR {final Caesar caesar = new Caesar();},
        HILL {final Hill hill = new Hill();},
        PLAYFAIR {final Playfair playfair = new Playfair();}
    }
}
