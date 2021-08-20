package com.makesafe.gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class MakeSafeMain extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage mainStage) {
        new MakeSafeGui(mainStage);
    }
}
