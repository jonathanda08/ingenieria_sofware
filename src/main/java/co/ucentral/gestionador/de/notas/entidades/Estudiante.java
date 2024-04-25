package co.ucentral.gestionador.de.notas.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Estudiantes")
@Table(name = "ESTUDIANTES")
public class Estudiante {
    @Id
    @Column(name = "EstID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "SEQ_ESTUDIANTES")
    private long id;

    @Column(name = "EstCorreo")
    private long correo;

    @Column(name = "EstNOMBRE")
    private String nombre;

    @Column(name = "EstAPELLIDO")
    private String apellido;


}
