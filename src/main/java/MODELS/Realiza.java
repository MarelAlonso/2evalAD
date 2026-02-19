package MODELS;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;



@Data
@NoArgsConstructor
@Entity
public class Realiza implements Serializable {

    @Serial
    private static final long serialVersionUID = 137L;

    @EmbeddedId
    private Compuesta_alu_act idAlu_act;

    @Column
    private float nota;

    @Column
    private boolean entregado;



    @ManyToOne
    @MapsId("idAlumno")   // conecta con el campo de la clave compuesta
    @JoinColumn(name = "idAlumno")
    private Alumno alumno;

    @ManyToOne
    @MapsId("idActividad")  //
    @JoinColumn(name = "idActividad")
    private Actividad actividad;



}
