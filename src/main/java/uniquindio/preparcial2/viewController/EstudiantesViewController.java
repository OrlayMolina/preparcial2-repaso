package uniquindio.preparcial2.viewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import uniquindio.preparcial2.mapping.dto.EstudianteDto;
import uniquindio.preparcial2.model.Colegio;
import uniquindio.preparcial2.model.Estudiante;

public class EstudiantesViewController {

    Colegio colegio = new Colegio();
    ObservableList<Estudiante> listaEstudiantes = FXCollections.observableArrayList();

    @FXML
    private TableColumn<EstudianteDto, String> colCodigo;

    @FXML
    private TableColumn<EstudianteDto, String> colNombre;

    @FXML
    private TableColumn<EstudianteDto, String> colNotas;

    @FXML
    private TableView<EstudianteDto> tableEstudiante;

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
