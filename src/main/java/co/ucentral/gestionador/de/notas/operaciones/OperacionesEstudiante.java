package co.ucentral.gestionador.de.notas.operaciones;

import co.ucentral.gestionador.de.notas.dto.EstudiantesDto;

import java.util.List;

public interface OperacionesEstudiante {
    List<EstudiantesDto> listar();
    void ingresar(EstudiantesDto estudiante);

    EstudiantesDto findDtoById(Long id);
}

