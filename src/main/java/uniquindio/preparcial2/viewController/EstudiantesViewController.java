package uniquindio.preparcial2.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EstudiantesViewController {

    @FXML
    private TableColumn<?, ?> colCodigo;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TableColumn<?, ?> colNotas;

    @FXML
    private TableView<?> tableEstudiante;

    @FXML
    private TextField txfCodigo;

    @FXML
    private TextField txfNombre;

    @FXML
    private TextField txfNotas;

    @FXML
    void actualizarEstudiante(ActionEvent event) {

    }

    @FXML
    void agregarEstudiante(ActionEvent event) {

    }

    @FXML
    void eliminarEstudiante(ActionEvent event) {

    }

}
