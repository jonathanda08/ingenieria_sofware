package co.ucentral.gestionador.de.notas.repositorios;

import co.ucentral.gestionador.de.notas.entidades.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoActividad extends JpaRepository<Actividad,Long> {
}
