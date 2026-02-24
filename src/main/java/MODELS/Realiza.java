package MODELS;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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


    @ToString.Exclude
    @ManyToOne
    @MapsId("idAlumno")   // conecta con el campo de la clave compuesta
    @JoinColumn(name = "idAlumno")
    private Alumno alumno;


    @ToString.Exclude
    @ManyToOne
    @MapsId("idActividad")  //
    @JoinColumn(name = "idActividad")
    private Actividad actividad;


    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("ALUMNO").append(getAlumno().getNombre()).append(" || ACTIVIDAD: ").append(getActividad().getTitulo())
                .append(" || ENTREGADO: ").append(this.entregado).append(" || NOTA: ").append(this.nota).append(" || ");
        return builder.toString();
    }

}
