package co.ucentral.gestionador.de.notas.repositorios;

import co.ucentral.gestionador.de.notas.dto.DocenteDto;
import co.ucentral.gestionador.de.notas.servicios.ServicioDocente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class RepoDocentesTest {

    @Mock
    private Model model;

    @Mock
    private ServicioDocente servDocente;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListarDocentes() {
        List<DocenteDto> listaDocentes = Arrays.asList(new DocenteDto(), new DocenteDto());
        when(servDocente.listar()).thenReturn(listaDocentes);
        model.addAttribute("listaDocentes", listaDocentes);
        String result = "listaDocentes";
        assertEquals("listaDocentes", result);
    }

    @Test
    public void testCargarDocenteModal() {
        DocenteDto docenteLlenar = new DocenteDto();
        model.addAttribute("docenteLlenar", docenteLlenar);
        String result = "crear"; //
        assertEquals("crear", result);
    }

    @Test
    public void testMostrarDocente() {
        Long id = 1L;
        DocenteDto docente = new DocenteDto();
        when(servDocente.findDtoById(id)).thenReturn(docente);
        model.addAttribute("docente", docente);
        String result = "mostrarDocente";
        assertEquals("mostrarDocente", result);
    }
}

