module PeluNekoApp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;

    opens View to javafx.fxml, org.junit.jupiter.api;
    opens MainApp to javafx.fxml, org.junit.jupiter.api;
    opens ViewFXML to javafx.fxml, org.junit.jupiter.api;

    exports MainApp;
    exports View;
}