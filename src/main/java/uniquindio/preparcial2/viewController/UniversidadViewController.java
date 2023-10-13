package uniquindio.preparcial2.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class UniversidadViewController {

    @FXML
    private ComboBox<?> cmbModalidad;

    @FXML
    private TableColumn<?, ?> colCodigo;

    @FXML
    private TableColumn<?, ?> colModalidad;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TableColumn<?, ?> colProgramaAbscrito;

    @FXML
    private TableView<?> tableEstudiantes;

    @FXML
    private TextField txfCodigo;

    @FXML
    private TextField txfNombre;

    @FXML
    private TextField txfProgramaAbscrito;

    @FXML
    void agregarEstudiante(ActionEvent event) {

    }

    @FXML
    void buscarPorFiltro(ActionEvent event) {

    }

    @FXML
    void cancelarFiltro(ActionEvent event) {

    }

}
