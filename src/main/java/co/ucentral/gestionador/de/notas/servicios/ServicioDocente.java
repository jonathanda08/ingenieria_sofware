package co.ucentral.gestionador.de.notas.servicios;

import co.ucentral.gestionador.de.notas.dto.DocenteDto;
import co.ucentral.gestionador.de.notas.entidades.Docente;
import co.ucentral.gestionador.de.notas.operaciones.OperacionesDocente;
import co.ucentral.gestionador.de.notas.repositorios.RepoDocentes;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioDocente implements OperacionesDocente {

    @Autowired
    RepoDocentes repoDocentes;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<DocenteDto> listar() {
        TypeToken<List<DocenteDto>> typeToken = new TypeToken<>(){};
        return modelMapper.map(repoDocentes.findAll(),typeToken.getType());

    }

    @Override
    public void ingresar(DocenteDto docente) {
        Docente docentes = modelMapper.map(docente,Docente.class);
        repoDocentes.save(docentes);

    }
}
