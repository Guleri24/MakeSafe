package com.makesafe.logic;

import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

public class FileHandler {
    private final FileChooser fileChooser = new FileChooser();
    public TextField FileName;
    public AnchorPane MakeSafe;
    private File file;

    public void onClickChoose(Stage mainStage) throws IOException {
        fileChooser.setTitle("Choose file");
        fileChooser.getInitialFileName();
        file = fileChooser.showOpenDialog(mainStage);

        RandomAccessFile reader = new RandomAccessFile(file, "r");
        FileChannel channel = reader.getChannel();
        ByteBuffer buff = ByteBuffer.allocate(1024);

        int noOfBytesRead = channel.read(buff);
        String fileContent = new String(buff.array(), StandardCharsets.UTF_8);
        System.out.println(noOfBytesRead + " " + fileContent);

    }

    public void onClickView() throws IOException {
        Stage stage = (Stage) MakeSafe.getScene().getWindow();
        fileChooser.setTitle("View File");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        }
    }

    public void onClickCreate() throws IOException {
        Stage stage = (Stage) MakeSafe.getScene().getWindow();
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choose location to create file: ");
        java.io.File fileLocation = directoryChooser.showDialog(stage);

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Enter file name");
        dialog.setContentText("File name : ");
        Optional<String> fileName = dialog.showAndWait();
        if (fileName.isPresent()) {
            File file = new File(fileLocation + "/" + fileName.get() + ".txt");
            if (file.createNewFile()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("File Created");
                alert.setContentText(file.getName());
                alert.showAndWait();
            }
        }
    }

    public void onClickDelete() {
        Stage stage = (Stage) MakeSafe.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose file to delete");
        List<File> file = fileChooser.showOpenMultipleDialog(stage);
        if (file != null) {
            for (File delete : file) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                if (delete.delete()) {
                    alert.setTitle("File deleted");
                    alert.setContentText(delete.getName());
                    alert.show();
                }
            }
        }
    }
}
