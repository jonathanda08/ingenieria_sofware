package co.ucentral.gestionador.de.notas.servicios;

import co.ucentral.gestionador.de.notas.dto.ActividadDto;
import co.ucentral.gestionador.de.notas.entidades.Actividad;
import co.ucentral.gestionador.de.notas.operaciones.OperacionesActividad;
import co.ucentral.gestionador.de.notas.repositorios.RepoActividad;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServicioActividad implements OperacionesActividad {

    private final RepoActividad repoActividad;
    private final ModelMapper modelMapper;


    public ServicioActividad(RepoActividad repoActividad, ModelMapper modelMapper) {
        this.repoActividad = repoActividad;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ActividadDto> listar() {
        TypeToken<List<ActividadDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(repoActividad.findAll(), typeToken.getType());
    }
    @Override
    public void ingresar(ActividadDto actividadDto) {
        Actividad  actividad = modelMapper.map((Object) actividadDto, Actividad.class);
        repoActividad.save(actividad);
    }
    @Override
    public ActividadDto findDtoById(Long id) {
        Actividad actividad = repoActividad.findById(id).orElse(null);
        return actividad != null ? modelMapper.map(actividad, ActividadDto.class) : null;
    }
}
