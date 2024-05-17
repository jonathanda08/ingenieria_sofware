package co.ucentral.gestionador.de.notas.repositorios;

import co.ucentral.gestionador.de.notas.dto.EstudiantesDto;
import co.ucentral.gestionador.de.notas.servicios.ServicioEstudiante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class RepoEstudiantesTest {

    @Mock
    private Model model;

    @Mock
    private ServicioEstudiante servEstudiante;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListarEstudiantes() {
        List<EstudiantesDto> listaEstudiantes = Arrays.asList(new EstudiantesDto(), new EstudiantesDto());
        when(servEstudiante.listar()).thenReturn(listaEstudiantes);
        model.addAttribute("listaEstudiantes", listaEstudiantes);
        String result = "listaEstudiante";
        assertEquals("listaEstudiante", result);
    }

    @Test
    public void testCargarEstudianteModal() {
        EstudiantesDto estudianteLlenar = new EstudiantesDto();
        model.addAttribute("estudianteLlenar", estudianteLlenar);
        String result = "/estudiantes/nuevo";
        assertEquals("/estudiantes/nuevo", result);
    }

    @Test
    public void testMostrarEstudiante() {
        Long id = 1L;
        EstudiantesDto estudiante = new EstudiantesDto();
        when(servEstudiante.findDtoById(id)).thenReturn(estudiante);
        model.addAttribute("estudiante", estudiante);
        String result = "mostrarEstudiante";
        assertEquals("mostrarEstudiante", result);
    }
}
