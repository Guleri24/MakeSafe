package com.makesafe.gui;

import com.makesafe.logic.CipherChoose;
import com.makesafe.logic.Ciphers.Caesar;
import com.makesafe.logic.Ciphers.Ciphers;
import com.makesafe.logic.FileHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ButtonLayout {

    public static GridPane buttonLayout(Stage mainStage) {
        ComboBox<Ciphers> ciphers = new CipherChoose().cipherChoose();
        Button chooseFile = new Button("Choose Text File");
        Text file = new Text("no file chosen");
        RadioButton saveOriginal = new RadioButton("Save Original");
        saveOriginal.fire();
        saveOriginal.setOnAction(e -> {
        });
        chooseFile.setOnAction(e -> {
            try {
                new FileHandler().onClickChoose(mainStage);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        Button encrypt = new Button("Encrypt");
       /* encrypt.setOnAction(e -> {
            try {
                new FileHandler().onClickEncrypt();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });*/
        Button decrypt = new Button("Decrypt");
       /* decrypt.setOnAction(e -> {
            try {
                new FileHandler().onClickDecrypt();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });*/

        GridPane buttonLayout = new GridPane();
        buttonLayout.addRow(1, chooseFile, file, saveOriginal);
        buttonLayout.addRow(2, ciphers, encrypt, decrypt);
        buttonLayout.addRow(3, new Caesar().specificFunctions());
        buttonLayout.setHgap(10);
        buttonLayout.setVgap(10);

        return buttonLayout;
    }
}
