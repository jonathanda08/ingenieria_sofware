package co.ucentral.gestionador.de.notas.controlador;

import co.ucentral.gestionador.de.notas.entidades.Corte;
import co.ucentral.gestionador.de.notas.servicios.ServiceCorte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorCorte {

    @Autowired
    private ServiceCorte serviceCorte;

    @PostMapping("/corte")
    public Corte addCorte(@RequestBody Corte corte) {
        return serviceCorte.saveCorte(corte);
    }

    @GetMapping("/corte")
    public List<Corte> findAllCortes() {
        return serviceCorte.getCortes();
    }

    @GetMapping("/corte/{id}")
    public Corte findCorteById(@PathVariable Long id) {
        return serviceCorte.getCorteById(id);
    }

    @PutMapping("/corte/nuevo")
    public Corte updateCorte(@RequestBody Corte corte) {
        return serviceCorte.updateCorte(corte);
    }

    @DeleteMapping("/corte/{id}")
    public String deleteCorte(@PathVariable Long id) {
        return serviceCorte.deleteCorte(id);
    }
}
