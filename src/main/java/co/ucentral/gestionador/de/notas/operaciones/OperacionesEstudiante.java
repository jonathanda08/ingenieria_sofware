package co.ucentral.gestionador.de.notas.operaciones;

import co.ucentral.gestionador.de.notas.dto.EstudiantesDto;

import java.util.List;

public interface OperacionesEstudiante {

    public List<EstudiantesDto> listar();

    public void ingresar(EstudiantesDto estudiante);

}
