package co.ucentral.gestionador.de.notas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.*;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class EstudiantesDto implements Serializable{
    private long id;

    private String correo;

    private String nombre;

    private String apellido;

    private double nota1;

    private double nota2;

    private double nota3;
}
