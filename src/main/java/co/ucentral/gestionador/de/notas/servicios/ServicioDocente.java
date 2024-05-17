package co.ucentral.gestionador.de.notas.servicios;

import co.ucentral.gestionador.de.notas.dto.DocenteDto;
import co.ucentral.gestionador.de.notas.entidades.Docente;
import co.ucentral.gestionador.de.notas.operaciones.OperacionesDocente;
import co.ucentral.gestionador.de.notas.repositorios.RepoDocentes;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioDocente implements OperacionesDocente {


    RepoDocentes repoDocentes;


    ModelMapper modelMapper;

    public ServicioDocente(ModelMapper modelMapper, RepoDocentes repoDocentes) {
        this.modelMapper = modelMapper;
        this.repoDocentes = repoDocentes;
    }

    @Override
    public List<DocenteDto> listar() {
        TypeToken<List<DocenteDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(repoDocentes.findAll(), typeToken.getType());
    }

    @Override
    public void ingresar(DocenteDto docente) {
        Docente docentes = modelMapper.map(docente,Docente.class);
        repoDocentes.save(docentes);
    }

    @Override
    public DocenteDto findDtoById(Long id) {
        Docente docente = repoDocentes.findById(id).orElse(null);
        return docente != null ? modelMapper.map(docente, DocenteDto.class) : null;
    }
}

