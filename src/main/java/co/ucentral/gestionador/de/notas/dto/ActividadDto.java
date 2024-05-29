package co.ucentral.gestionador.de.notas.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class ActividadDto implements Serializable {
    private String id;
    private String nombre;
    private double porcentajeNota;
    private String descripcion;



}
