package co.ucentral.gestionador.de.notas.operaciones;

import co.ucentral.gestionador.de.notas.dto.DocenteDto;

import java.util.List;

public interface OperacionesDocente {

    public List<DocenteDto> listar();

    public void ingresar(DocenteDto docente);

}

