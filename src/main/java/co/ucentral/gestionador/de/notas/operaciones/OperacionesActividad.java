package co.ucentral.gestionador.de.notas.operaciones;

import co.ucentral.gestionador.de.notas.dto.ActividadDto;

import java.util.List;

public interface OperacionesActividad {
    List<ActividadDto> listar();
    void ingresar(ActividadDto actividad);

    ActividadDto findDtoById(Long id);
}
