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
import java.util.Optional;

@Service
public class ServicioEstudiante implements OperacionesEstudiante {

    @Autowired
    RepoEstudiantes repoEstudiantes;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    public ServicioEstudiante(RepoEstudiantes repoEstudiantes) {
        this.repoEstudiantes = repoEstudiantes;
    }

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

    @Override
    public EstudiantesDto findDtoById(Long id) {
        Optional<Estudiante> estudiante = repoEstudiantes.findById(id);
        if (estudiante.isPresent()) {
            return modelMapper.map(estudiante.get(), EstudiantesDto.class);
        } else {
            return null;
        }
    }

    public void ingresarNota(Long id, double nota1, double nota2, double nota3) {
        Estudiante estudiante = repoEstudiantes.findById(id).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        estudiante.setNota1(nota1);
        estudiante.setNota2(nota2);
        estudiante.setNota3(nota3);
        repoEstudiantes.save(estudiante);
    }

    public double calcularPromedio(Long id) {
        Estudiante estudiante = repoEstudiantes.findById(id).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        return estudiante.getNota1() * 0.3 + estudiante.getNota2() * 0.3 + estudiante.getNota3() * 0.4;
    }

}


