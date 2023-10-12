package uniquindio.preparcial2.mapping.mappers;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import uniquindio.preparcial2.mapping.dto.EstudianteDto;
import uniquindio.preparcial2.model.Estudiante;

import java.util.List;

@Mapper
public interface ColegioMapper {

    ColegioMapper INSTANCE = Mappers.getMapper(ColegioMapper.class);

    @Named("estudianteToEstudianteDto")
    EstudianteDto estudianteToEstudianteDto(Estudiante estudiante);

    Estudiante estudianteDtoToEstudiante(EstudianteDto estudianteDto);

    @IterableMapping(qualifiedByName = "estudianteToEstudianteDto")
    List<EstudianteDto> getEstudianteDto(List<Estudiante> listaEstudiantes);
}
