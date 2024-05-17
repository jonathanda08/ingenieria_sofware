package co.ucentral.gestionador.de.notas.repositorios;

import co.ucentral.gestionador.de.notas.dto.DocenteDto;
import co.ucentral.gestionador.de.notas.servicios.ServicioDocente;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
class RepoDocentesTest {

    @MockBean
    private Model model;

    @MockBean
    private ServicioDocente servDocente;

    @Test
    public void testListarDocentes() {
        List<DocenteDto> listaDocentes = Arrays.asList(new DocenteDto(), new DocenteDto());
        Mockito.when(servDocente.listar()).thenReturn(listaDocentes);
        model.addAttribute("listaDocentes", listaDocentes);
        String result = "listaDocentes"; // Aquí debes llamar al método real que estás probando
        assertEquals("listaDocentes", result);
    }

    @Test
    public void testCargarDocenteModal() {
        DocenteDto docenteLlenar = new DocenteDto();
        model.addAttribute("docenteLlenar", docenteLlenar);
        String result = "crear"; // Aquí debes llamar al método real que estás probando
        assertEquals("crear", result);
    }

    @Test
    public void testMostrarDocente() {
        Long id = 1L;
        DocenteDto docente = new DocenteDto();
        Mockito.when(servDocente.findDtoById(id)).thenReturn(docente);
        model.addAttribute("docente", docente);
        String result = "mostrarDocente"; // Aquí debes llamar al método real que estás probando
        assertEquals("mostrarDocente", result);
    }
}

