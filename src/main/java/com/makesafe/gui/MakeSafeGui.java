package com.makesafe.gui;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MakeSafeGui {
   public MakeSafeGui(Stage mainStage) {
        mainStage.setTitle("My First JavaFX App");

        Label label = new Label("Hello World, JavaFX !");
        Scene scene = new Scene(label, 400, 200);
        mainStage.setScene(scene);

        mainStage.show();
    }
}
