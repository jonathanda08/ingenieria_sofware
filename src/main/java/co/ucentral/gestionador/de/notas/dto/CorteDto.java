package co.ucentral.gestionador.de.notas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class CorteDto {

    private Long id;
    private Date fechaInicio;
    private Date fechaFinalizacion;


}
