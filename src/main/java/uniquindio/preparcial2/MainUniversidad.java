package uniquindio.preparcial2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainUniversidad extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainEstudiantes.class.getResource("universidad-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 385);
        stage.setTitle("Universidad!");
        stage.setScene(scene);
        stage.show();
    }
}
