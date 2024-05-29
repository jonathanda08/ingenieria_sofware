package co.ucentral.gestionador.de.notas.operaciones;

import co.ucentral.gestionador.de.notas.dto.DocenteDto;

import java.util.List;

public interface OperacionesDocente {
    List<DocenteDto> listar();
    void ingresar(DocenteDto docente);

    DocenteDto findDtoById(Long id);
}

