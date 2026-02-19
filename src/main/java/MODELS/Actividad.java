package MODELS;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

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

    @Column
    private Date fecha;// ????

    @OneToMany(mappedBy = "actividad", cascade = CascadeType.PERSIST)
    private java.util.List<Realiza> alumnos;


}
