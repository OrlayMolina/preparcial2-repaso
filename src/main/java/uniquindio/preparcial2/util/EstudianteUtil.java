package uniquindio.preparcial2.util;

import uniquindio.preparcial2.mapping.dto.EstudianteDto;

import java.util.function.Predicate;

public class EstudianteUtil {

    public static Predicate<EstudianteDto> buscarPorCodigo(String codigo){
        return estudianteDto -> estudianteDto.codigo().equals(codigo);
    }

    public static Predicate<EstudianteDto> buscarPorNombre(String nombre){
        return estudianteDto -> estudianteDto.nombre().contains(nombre);
    }

    public static Predicate<EstudianteDto> buscarPorNota(String notas){
        return estudianteDto -> estudianteDto.notas().contains(notas);
    }

    public static Predicate<EstudianteDto> buscarPorTodo(String codigo, String nombre, String notas) {

        Predicate<EstudianteDto> predicado = estudianteDto -> true;

        if( codigo != null && !codigo.isEmpty() ){
            predicado = predicado.and(buscarPorCodigo(codigo));
        }
        if( nombre != null && !nombre.isEmpty() ){
            predicado = predicado.and(buscarPorNombre(nombre));
        }
        if( notas != null && !notas.isEmpty() ){
            predicado = predicado.and(buscarPorNota(notas));
        }

        return predicado;
    }
}
