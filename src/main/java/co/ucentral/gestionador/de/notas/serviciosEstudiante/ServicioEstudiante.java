package co.ucentral.gestionador.de.notas.serviciosEstudiante;

import co.ucentral.gestionador.de.notas.dto.EstudiantesDto;
import co.ucentral.gestionador.de.notas.entidades.Estudiante;
import co.ucentral.gestionador.de.notas.operaciones.OperacionesEstudiante;
import co.ucentral.gestionador.de.notas.repositorios.RepoEstudiantes;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEstudiante implements OperacionesEstudiante {

    @Autowired
    RepoEstudiantes repoEstudiantes;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<EstudiantesDto> listar() {
        TypeToken<List<EstudiantesDto>> typeToken = new TypeToken<>(){};
        return modelMapper.map(repoEstudiantes.findAll(),typeToken.getType());

    }

    @Override
    public void ingresar(EstudiantesDto estudiante) {
        Estudiante estudiantes = modelMapper.map(estudiante,Estudiante.class);
        repoEstudiantes.save(estudiantes);

    }
}

