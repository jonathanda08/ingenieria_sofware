package co.ucentral.gestionador.de.notas.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Docentes")
@Table(name = "DOCENTES")
public class Docente {
    @Id
    @Column(name = "DocID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "SEQ_DOCENTES")
    private long id;

    @Column(name = "DocCorreo")
    private String correo;

    @Column(name = "DocAsignatura")
    private String asignatura;

    @Column(name = "DocNOMBRE")
    private String nombre;

    @Column(name = "DocAPELLIDO")
    private String apellido;
}
