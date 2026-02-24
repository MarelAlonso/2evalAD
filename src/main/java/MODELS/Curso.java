package MODELS;


import lombok.*;

import javax.naming.Name;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Curso")

@NamedQueries({
        @NamedQuery(name = "findCursos", query = "from Curso" ),
        @NamedQuery(name = "Curso.cursosEntreAnios", query = "from Curso c where c.anyo between :anioInicio and :anioFin"),
        @NamedQuery(name = "Curso.tutoresMismoSector", query = "select distinct c.tutor.nombreTutor, c.tutor.email from Curso c where c.sector = :sector")

})
public class Curso implements Serializable {

    @Serial
    private static final long serialVersionUID = 137L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;

    @Column
    private String nombreCurso;

    @Column
    private String sector;

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
    @ToString.Exclude
    @OneToMany(mappedBy = "elcurso",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<Alumno> alumnos;




    //CURSO-MODULO

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(name = "Pertenece",
        joinColumns = {@JoinColumn(
                name = "idCurso",
                foreignKey = @ForeignKey(name = "FK_PER_CUR"))},
        inverseJoinColumns = {@JoinColumn(
                name = "idModulo",
                foreignKey = @ForeignKey(name = "FK_PER_MOD"))})
    private Set<Modulo> losmodulos = new HashSet<>();




    public Curso(int anyo, String nombreCurso, String sector, Tutor tutor) {
        this.anyo = anyo;
        this.nombreCurso = nombreCurso;
        this.sector = sector;
        this.tutor = tutor;
    }


    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("ID: ").append(this.idCurso).append(" || NOMBRE: ").append(this.nombreCurso).append(" || SECTOR ").append(this.sector).append(this.tutor);
        return builder.toString();
    }


}

