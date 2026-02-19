package MODELS;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.naming.Name;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity(name = "Curso")
public class Curso implements Serializable {

    @Serial
    private static final long serialVersionUID = 137L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;

    @Column
    private String nombreCurso;

    @Column
    private int anyo;

    //CURSO-TUTOR


    @Embedded
    private Tutor tutor;


//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "nombreTutor",
//                    column = @Column(name = "nombreTutorPrincipal")),
//            @AttributeOverride(name = "email",
//                    column = @Column(name = "emailTutorPrincipal"))
//    })
//    private Tutor tutorprincipal;

 /////////////////////////////////////////////////////

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(
//            name="idTutor",
//            referencedColumnName = "idTutor",
//            unique=true,
//            foreignKey = @ForeignKey(name = "FK_GRP_TEACH"))
//    private Profesor tutor;


//@Embedded NO ENTIENDO
//private Wheel wheel1;
//
//@Embedded
//@AttributeOverrides({
//        @AttributeOverride(name="diameter", column = @Column(name="diameter2") ),
//        @AttributeOverride(name="speedCode", column = @Column(name="speedCode2") )
//})
//private Wheel wheel2;


    // CURSO-ALUMNO
    @OneToMany(mappedBy = "elcurso",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private Set<Alumno> alumnos;




    //CURSO-MODULO


    @ManyToMany(cascade = CascadeType.PERSIST,
        fetch = FetchType.LAZY)
    @JoinTable(name = "Pertenece",
        joinColumns = {@JoinColumn(
                name = "idCurso",
                foreignKey = @ForeignKey(name = "FK_PER_CUR"))},
        inverseJoinColumns = {@JoinColumn(
                name = "idModulo",
                foreignKey = @ForeignKey(name = "FK_PER_MOD"))})

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Modulo> losmodulos = new HashSet<>();




    public Curso(String nombreCurso, int anyo, Tutor tutor) {
        this.nombreCurso = nombreCurso;
        this.anyo = anyo;
        this.tutor = tutor;
    }






}

