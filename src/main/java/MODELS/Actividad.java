package MODELS;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@Entity
public class Actividad implements Serializable {

    @Serial
    private static final long serialVersionUID = 137L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActividad;

    @Column
    private String titulo;

    @Column
    private String descripcion;


    @ToString.Exclude
    @OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL)
    private List<Realiza> alumnos;




    @Override
    public String toString(){
    StringBuilder builder = new StringBuilder();
    builder.append("ID: ").append(this.idActividad).append(" || TITULO: ").append(this.titulo).append(" || DESCRIPCIÓN: ").append(this.descripcion).append(" || ");
    return builder.toString();
    }

}
