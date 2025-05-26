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
    requires java.sql;
    requires java.persistence;
    requires java.naming;
    requires org.hibernate.orm.core;
    requires com.google.protobuf;
    requires org.slf4j;
    requires org.jboss.jandex;
    requires jbcrypt;

    opens View to javafx.fxml, org.junit.jupiter.api;
    opens MainApp to javafx.fxml, org.junit.jupiter.api;
    opens ViewFXML to javafx.fxml, org.junit.jupiter.api;
    opens Entity to org.hibernate.orm.core, javafx.base, javafx.fxml;


    exports MainApp;
    exports View;
    exports Entity;
}