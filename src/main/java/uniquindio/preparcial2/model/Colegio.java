package uniquindio.preparcial2.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Colegio {

    private ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

    public ArrayList<Estudiante> getListaProductos() {
        return listaEstudiantes;
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
