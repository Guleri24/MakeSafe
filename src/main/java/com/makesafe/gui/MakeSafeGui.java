package com.makesafe.gui;

import com.makesafe.logic.Operations;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MakeSafeGui {
    public MakeSafeGui(final Stage mainStage) {
        mainStage.setTitle("MakeSafe");
        Button chooseFile = new Button("Choose Text File");
        Operations operations = new Operations();
        chooseFile.setOnAction(e -> {
            operations.onClickChoose(mainStage);
        });
        Button encrypt = new Button("Encrypt");
        encrypt.setOnAction(e -> {
            try {
                operations.onClickEncrypt();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        Button decrypt = new Button("Decrypt");
        decrypt.setOnAction(e -> {
            try {
                operations.onClickDecrypt();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        HBox hbox = new HBox(chooseFile, encrypt, decrypt);
        hbox.setSpacing(10);
        Scene scene = new Scene(hbox, 400, 100);
        mainStage.initStyle(StageStyle.DECORATED);
        mainStage.setScene(scene);

        mainStage.show();
    }
}
