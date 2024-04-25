package co.ucentral.gestionador.de.notas.repositorios;

import co.ucentral.gestionador.de.notas.entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoEstudiantes extends JpaRepository<Estudiante,Long> {
}

