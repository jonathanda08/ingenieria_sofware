package co.ucentral.gestionador.de.notas.repositorios;

import co.ucentral.gestionador.de.notas.entidades.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoDocentes extends JpaRepository<Docente,Long> {

}
