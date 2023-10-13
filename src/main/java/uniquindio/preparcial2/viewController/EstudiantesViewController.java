package uniquindio.preparcial2.viewController;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import uniquindio.preparcial2.controller.ModelFactoryController;
import uniquindio.preparcial2.mapping.dto.EstudianteDto;
import uniquindio.preparcial2.util.EstudianteUtil;

import java.util.Optional;
import java.util.function.Predicate;

public class EstudiantesViewController {

    ModelFactoryController modelFactoryController;
    ObservableList<EstudianteDto> listaEstudiantes = FXCollections.observableArrayList();

    EstudianteDto estudianteSeleccionado;

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
    void agregarEstudiante(ActionEvent event) {
        crearEstudiante();
    }

    @FXML
    void cancelarEstudiante(ActionEvent event) {
        cancelarBusqueda();
    }

    @FXML
    void buscarEstudiante(ActionEvent event) {
        String codigo = txfCodigo.getText();
        String nombre = txfNombre.getText();
        String notas = txfNotas.getText();

        buscarEstudiantes(codigo, nombre, notas);
    }

    @FXML
    void initialize() {
        modelFactoryController = new ModelFactoryController();
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerEstudiantes();
        tableEstudiante.getItems().clear();
        tableEstudiante.setItems(listaEstudiantes);
        listenerSelection();
    }

    private void initDataBinding() {
        colCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().codigo()));
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        colNotas.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().notas()));
    }

    private void buscarEstudiantes(String codigo, String nombre, String notas) {

        Predicate<EstudianteDto> predicate = EstudianteUtil.buscarPorTodo(codigo, nombre, notas);
        ObservableList<EstudianteDto> estudiantesFiltrados = listaEstudiantes.filtered(predicate);
        tableEstudiante.setItems(estudiantesFiltrados);
        registrarAcciones("Estudiante filtrado",1, "Filtro de un estudiante");
    }


    private void obtenerEstudiantes() {
        listaEstudiantes.addAll(modelFactoryController.obtenerEstudiantes());
    }

    /**
     *
     */
    private void listenerSelection() {
        tableEstudiante.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            estudianteSeleccionado = newSelection;
            mostrarInformacionEstudiante(estudianteSeleccionado);
        });
    }

    private void mostrarInformacionEstudiante(EstudianteDto estudianteSeleccionado) {
        if(estudianteSeleccionado != null){
            txfCodigo.setText(estudianteSeleccionado.codigo());
            txfNombre.setText(estudianteSeleccionado.nombre());
            txfNotas.setText(estudianteSeleccionado.notas());

        }
    }

    private void crearEstudiante() {

        EstudianteDto estudianteDto = construirEstudianteDto();

        if(datosValidos(estudianteDto)){
            if(modelFactoryController.agregarEstudiante(estudianteDto)){
                listaEstudiantes.add(estudianteDto);
                mostrarMensaje("Notificación estudiante", "Estudiante creado", "El estudiante se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposEstudiante();
                registrarAcciones("Estudiante agregado",1, "Agregar estudiante");

            }else{
                mostrarMensaje("Notificación estudiante", "Estudiante no creado", "El estudiante no se ha creado", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación estudiante", "Estudiante no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
        }

    }

    private void registrarAcciones(String mensaje, int nivel, String accion) {
        modelFactoryController.registrarAcciones(mensaje, nivel, accion);
    }

    private void cancelarBusqueda(){
        limpiarCamposEstudiante();
        tableEstudiante.getSelectionModel().clearSelection();
        tableEstudiante.setItems(listaEstudiantes);
        listenerSelection();
    }

    private EstudianteDto construirEstudianteDto() {
        return new EstudianteDto(
                txfCodigo.getText(),
                txfNombre.getText(),
                txfNotas.getText()

        );
    }

    private void limpiarCamposEstudiante() {
        txfCodigo.setText("");
        txfNombre.setText("");
        txfNotas.setText("");

    }

    private boolean datosValidos(EstudianteDto estudianteDto) {
        String mensaje = "";
        if(estudianteDto.codigo() == null || estudianteDto.codigo().equals(""))
            mensaje += "El código del estudiante es invalido \n" ;
        if(estudianteDto.nombre() == null || estudianteDto.nombre() .equals(""))
            mensaje += "El nombre del estudiante es invalido \n" ;
        if(estudianteDto.notas() == null || estudianteDto.notas() .equals(""))
            mensaje += "las notas del estudiante es invalido \n" ;
        if(mensaje.equals("")){
            return true;
        }else{
            mostrarMensaje("Notificación estudiante", "Estudiante no creado", mensaje, Alert.AlertType.ERROR);
            return false;
        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

}
