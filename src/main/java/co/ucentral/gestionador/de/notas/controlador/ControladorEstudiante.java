package co.ucentral.gestionador.de.notas.controlador;

import co.ucentral.gestionador.de.notas.dto.EstudiantesDto;
import co.ucentral.gestionador.de.notas.servicios.ServicioEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class ControladorEstudiante {

    private final ServicioEstudiante servicioEstudiante;

    @Autowired
    public ControladorEstudiante(ServicioEstudiante servicioEstudiante) {
        this.servicioEstudiante = servicioEstudiante;
    }

    @GetMapping("/estudiantes/lista")
    public String listarEstudiantes(Model model) {
        List<EstudiantesDto> listaEstudiantes = servicioEstudiante.listar();
        model.addAttribute("listaEstudiantes", listaEstudiantes); // Corregido el nombre del atributo
        return "listaEstudiante";
    }

    @GetMapping("/estudiantes/formulario")
    public String cargarEstudianteModal(Model model) {
        EstudiantesDto estudianteLlenar = new EstudiantesDto();
        model.addAttribute("estudianteLlenar", estudianteLlenar);
        return "nuevo";
    }

    @PostMapping("/estudiante/nuevo")
    public String ingresar(@ModelAttribute("estudianteLlenar") EstudiantesDto estudianteDto) { // Corregido el nombre del atributo
        servicioEstudiante.ingresar(estudianteDto);
        return "redirect:/estudiantes/lista";
    }

    @GetMapping("/estudiantes/{id}")
    public String mostrarEstudiante(@PathVariable Long id, Model model) {
        EstudiantesDto estudiante = servicioEstudiante.findDtoById(id);
        model.addAttribute("estudiante", estudiante);
        return "mostrarEstudiante";
    }

    @GetMapping("/estudiantes/{id}/promedio")
    public String calcularPromedio(@PathVariable Long id, Model model) {
        double promedio = servicioEstudiante.calcularPromedio(id);
        model.addAttribute("promedio", promedio);
        return "mostrarPromedio";
    }
}
