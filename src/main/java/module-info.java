module uniquindio.preparcial2 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens uniquindio.preparcial2 to javafx.fxml;
    exports uniquindio.preparcial2;
    opens uniquindio.preparcial2.viewController to javafx.fxml;
    exports uniquindio.preparcial2.viewController;
}