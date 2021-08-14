package com.makesafe.gui;

import com.makesafe.logic.Ciphers.Caesar;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MakeSafeGui {
    public MakeSafeGui(final Stage mainStage) {
        mainStage.setTitle("MakeSafe");

        BorderPane mainWindow = new BorderPane();

        ScrollPane cipherInfo = new ScrollPane();
        cipherInfo.setContent(new Text(new Caesar().cipherInfo()));

        GridPane buttonLayout = ButtonLayout.buttonLayout(mainStage);

        mainWindow.setTop(buttonLayout);
        mainWindow.setCenter(cipherInfo);

        Scene scene = new Scene(mainWindow, 500, 500);
        mainStage.initStyle(StageStyle.DECORATED);
        mainStage.setScene(scene);

        mainStage.show();
    }
}
