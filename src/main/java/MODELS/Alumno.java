package MODELS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;



@Data
@ToString
@NoArgsConstructor
@Entity
public class Alumno implements Serializable {

    @Serial
    private static final long serialVersionUID = 137L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlumno;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String email;

    //ALUMNO-CURSO
    @ManyToOne
    (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idCurso", foreignKey = @ForeignKey(name = "FK_ALU_CUR"))
    private Curso elcurso;

    // ALUMNO-ACTIVIDAD
    @OneToMany
            (mappedBy = "alumno", cascade = CascadeType.ALL)
    private java.util.List<Realiza> actividades;

}
