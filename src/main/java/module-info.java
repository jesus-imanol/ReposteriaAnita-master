module com.jesuscast.reposteriaanita {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;


    opens com.jesuscast.reposteriaanita.models to javafx.base;
    opens com.jesuscast.reposteriaanita to javafx.fxml;
    exports com.jesuscast.reposteriaanita;
    exports com.jesuscast.reposteriaanita.controllers;
    opens com.jesuscast.reposteriaanita.controllers to javafx.fxml;
}