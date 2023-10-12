module uniquindio.preparcial2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mapstruct;
    requires java.logging;


    opens uniquindio.preparcial2 to javafx.fxml;
    exports uniquindio.preparcial2;
    opens uniquindio.preparcial2.viewController to javafx.fxml;
    exports uniquindio.preparcial2.viewController;
    opens uniquindio.preparcial2.model to javafx.fxml;
    exports uniquindio.preparcial2.model;
    opens uniquindio.preparcial2.mapping.dto to javafx.fxml;
    exports uniquindio.preparcial2.mapping.dto;
    opens uniquindio.preparcial2.mapping.mappers to javafx.fxml;
    exports uniquindio.preparcial2.mapping.mappers;
    opens uniquindio.preparcial2.controller to javafx.fxml;
    exports uniquindio.preparcial2.controller;
}