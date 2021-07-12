module MakeSafe {
    // Swing
    requires java.desktop;

    // JavaFX
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    exports com.makesafe.gui;
    opens com.makesafe.gui to javafx.graphics;
}