package uniquindio.preparcial2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uniquindio.preparcial2.model.Estudiante;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainEstudiantes extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainEstudiantes.class.getResource("estudiantes-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 385);
        stage.setTitle("Inicio!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}