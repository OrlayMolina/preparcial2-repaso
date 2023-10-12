package uniquindio.preparcial2.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Colegio {

    private ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void agregarEstudiante(Estudiante estudiante) throws Exception{
        getListaEstudiantes().add(estudiante);
    }

    public boolean verificarEstudianteExistente(String codigo) throws Exception {
        if(estudianteExiste(codigo)){
            throw new Exception("El estudiante con código: "+codigo+" ya existe");
        }else{
            return false;
        }
    }

    public boolean estudianteExiste(String codigo) {
        boolean estudianteEncontrado = false;
        for (Estudiante estudiante : getListaEstudiantes()) {
            if(estudiante.getCodigo().equalsIgnoreCase(codigo)){
                estudianteEncontrado = true;
                break;
            }
        }
        return estudianteEncontrado;
    }

    private static void guardarDatos(ArrayList<Estudiante> estudiantes) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("resources\\uniquindio\\preparcial2\\archivos\\estudiantes.txt"))) {
            for (Estudiante estudiante : estudiantes) {
                bw.write(estudiante.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
