package uniquindio.preparcial2.controller;

import uniquindio.preparcial2.mapping.dto.EstudianteDto;
import uniquindio.preparcial2.mapping.mappers.ColegioMapper;
import uniquindio.preparcial2.model.Colegio;
import uniquindio.preparcial2.model.Estudiante;
import uniquindio.preparcial2.util.Persistencia;

import java.io.IOException;
import java.util.List;

public class ModelFactoryController {

    Colegio colegio = new Colegio();

    ColegioMapper mapper = ColegioMapper.INSTANCE;

    //------------------------------  Singleton ------------------------------------------------
    // Clase estatica oculta. Tan solo se instanciara el singleton una vez
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        cargarDatosDesdeArchivos();
    }

    public Colegio getColegio() {
        return colegio;
    }

    public List<EstudianteDto> obtenerEstudiantes() {
        return  mapper.getEstudianteDto(colegio.getListaEstudiantes());
    }

    public boolean agregarEstudiante(EstudianteDto estudianteDto) {
        try{
            if(!colegio.verificarEstudianteExistente(estudianteDto.codigo())) {
                Estudiante estudiante = mapper.estudianteDtoToEstudiante(estudianteDto);
                getColegio().agregarEstudiante(estudiante);
                guardarEstudiante();
            }
            return true;
        }catch (Exception e){
            e.getMessage();
            return false;
        }
    }

    private void cargarDatosDesdeArchivos() {
        colegio = new Colegio();
        try {
            Persistencia.cargarDatosArchivos(colegio);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void guardarEstudiante() {
        try {
            Persistencia.guardarEstudiante(getColegio().getListaEstudiantes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void registrarAcciones(String mensaje, int nivel, String accion) {
        Persistencia.guardaRegistroLog(mensaje, nivel, accion);
    }

}
