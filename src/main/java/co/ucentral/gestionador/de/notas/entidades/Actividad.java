package co.ucentral.gestionador.de.notas.entidades;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Actividad")
@Table(name = "ACTIVIDADES")
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "SEQ_ACTIVIDADES")
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "PorcentajeNota")
    private double porcentajeNota;

    private String descripcion;



}

