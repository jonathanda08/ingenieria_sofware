package co.ucentral.gestionador.de.notas.servicios;

import co.ucentral.gestionador.de.notas.entidades.Corte;
import co.ucentral.gestionador.de.notas.repositorios.RepoCorte;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCorte {

    private final RepoCorte repoCorte;

    public ServiceCorte(RepoCorte repoCorte) {
        this.repoCorte = repoCorte;
    }

    public Corte saveCorte(Corte corte) {
        return repoCorte.save(corte);
    }

    public List<Corte> getCortes() {
        return repoCorte.findAll();
    }

    public Corte getCorteById(Long id) {
        return repoCorte.findById(id).orElse(null);
    }

    public String deleteCorte(Long id) {
        repoCorte.deleteById(id);
        return "Corte removed !! " + id;
    }

    public Corte updateCorte(Corte corte) {
        Corte existingCorte = repoCorte.findById(corte.getId()).orElse(null);
        existingCorte.setFechaInicio(corte.getFechaInicio());
        existingCorte.setFechaFinalizacion(corte.getFechaFinalizacion());
        return repoCorte.save(existingCorte);
    }
}

