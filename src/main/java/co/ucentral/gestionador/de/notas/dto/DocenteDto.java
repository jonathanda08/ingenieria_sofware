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
public class DocenteDto implements Serializable{
    private long id;

    private long correo;

    private String nombre;

    private String apellido;


}