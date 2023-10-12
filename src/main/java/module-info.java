module uniquindio.preparcial2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mapstruct;


    opens uniquindio.preparcial2 to javafx.fxml;
    exports uniquindio.preparcial2;
    opens uniquindio.preparcial2.viewController to javafx.fxml;
    exports uniquindio.preparcial2.viewController;
    opens uniquindio.preparcial2.model to javafx.fxml;
    exports uniquindio.preparcial2.model;
}