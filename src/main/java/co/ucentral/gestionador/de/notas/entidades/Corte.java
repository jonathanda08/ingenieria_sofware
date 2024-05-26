package co.ucentral.gestionador.de.notas.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Corte")
@Table(name = "CORTES")
public class Corte {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CORTES")
    private Long id;

    @Column(name = "FechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "FechaFinalizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaFinalizacion;


}
