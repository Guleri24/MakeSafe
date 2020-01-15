package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.fxml.FXMLLoader.load;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
            Parent root = load(getClass().getResource("sample.fxml"));
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
