package co.ucentral.gestionador.de.notas.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Estudiante")
@Table(name = "ESTUDIANTE")
public class Estudiante {
    @Id
    @Column(name = "EST_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESTUDIANTES")
    private long id;

    @Column(name = "EST_CORREO")
    private String correo;

    @Column(name = "EST_NOMBRE")
    private String nombre;

    @Column(name = "EST_APELLIDO")
    private String apellido;

    @Column(name = "NOTA1")
    private double nota1;

    @Column(name = "NOTA2")
    private double nota2;

    @Column(name = "NOTA3")
    private double nota3;
}

