package co.ucentral.gestionador.de.notas.operaciones;

import co.ucentral.gestionador.de.notas.dto.CorteDto;

import java.util.List;

public interface OperacionesCorte {
    List<CorteDto> listar();
    void ingresar(CorteDto corte);

    CorteDto findDtoById(Long id);
}
