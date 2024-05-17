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
    private String correoEstudiante;

    @Column(name = "EstNOMBRE")
    private String nombreEstudiante;

    @Column(name = "EstAPELLIDO")
    private String apellidoEstudiante;

    @Column(name = "Nota1")
    private double nota1;

    @Column(name = "Nota2")
    private double nota2;

    @Column(name = "Nota3")
    private double nota3;
}

