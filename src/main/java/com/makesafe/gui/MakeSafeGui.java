package com.makesafe.gui;

import com.makesafe.logic.Ciphers.CipherChoose;
import com.makesafe.logic.Operations;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MakeSafeGui {
    public MakeSafeGui(final Stage mainStage) {
        mainStage.setTitle("MakeSafe");

        BorderPane main = new BorderPane();

        ComboBox<Button> ciphers = new CipherChoose().cipherChoose();
        ScrollPane cipherInfo = new ScrollPane();
        Text file = new Text("no file chosed");
        Button chooseFile = new Button("Choose Text File");
        chooseFile.setOnAction(e -> new Operations().onClickChoose(mainStage));
        Button encrypt = new Button("Encrypt");
        encrypt.setOnAction(e -> {
            try {
                new Operations().onClickEncrypt();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        Button decrypt = new Button("Decrypt");
        decrypt.setOnAction(e -> {
            try {
                new Operations().onClickDecrypt();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        GridPane buttonLayout = new GridPane();
        buttonLayout.addRow(1, chooseFile, file);
        buttonLayout.addRow(2, ciphers, encrypt, decrypt);
        buttonLayout.setHgap(10);
        buttonLayout.setVgap(10);
        main.setTop(buttonLayout);
        main.setCenter(cipherInfo);

        Scene scene = new Scene(main, 400, 600);
        mainStage.initStyle(StageStyle.DECORATED);
        mainStage.setScene(scene);

        mainStage.show();
    }
}
