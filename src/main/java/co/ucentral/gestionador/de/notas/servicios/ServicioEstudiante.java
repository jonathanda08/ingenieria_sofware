package co.ucentral.gestionador.de.notas.servicios;

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

    private final RepoEstudiantes repoEstudiantes;
    private final ModelMapper modelMapper;

    @Autowired
    public ServicioEstudiante(RepoEstudiantes repoEstudiantes, ModelMapper modelMapper) {
        this.repoEstudiantes = repoEstudiantes;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EstudiantesDto> listar() {
        TypeToken<List<EstudiantesDto>> typeToken = new TypeToken<>(){};
        return modelMapper.map(repoEstudiantes.findAll(), typeToken.getType());
    }

    @Override
    public void ingresar(EstudiantesDto estudianteDto) {
        Estudiante estudiante = modelMapper.map(estudianteDto, Estudiante.class);
        repoEstudiantes.save(estudiante);
    }

    @Override
    public EstudiantesDto findDtoById(Long id) {
        return repoEstudiantes.findById(id)
                .map(estudiante -> modelMapper.map(estudiante, EstudiantesDto.class))
                .orElse(EstudiantesDto.builder().build());
    }


    public double calcularPromedio(Long id) {
        Estudiante estudiante = repoEstudiantes.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        return estudiante.getNota1() * 0.3 + estudiante.getNota2() * 0.3 + estudiante.getNota3() * 0.4;
    }
}
