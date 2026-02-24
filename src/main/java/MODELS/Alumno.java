package MODELS;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = "findAlumnos", query = "from Alumno alu"),
        @NamedQuery(name = "Alumno.buscar-rec", query = "select a.idActividad, a.titulo, a.descripcion, r.entregado, r.nota from Realiza r join r.actividad a where r.idAlu_act.idAlumno = :idAlumno"),
        @NamedQuery(name = "Alumno.Buscar-letra", query = "from Alumno a where lower(a.nombre) like lower(:texto)"),
        @NamedQuery(name = "Alumno.buscarPorNombreCurso", query = "from Alumno a where lower(a.elcurso.nombreCurso) like lower(:texto)"),
        @NamedQuery(name = "Alumno.alumnosConNotasAltas", query = "select a from Alumno a join a.actividades r where r.nota >= :minNota group by a having count(r) >= 2"),
        @NamedQuery(name = "Alumno.actividadesNoEntregadas", query = "select r.alumno, r.actividad from Realiza r where r.entregado = false order by r.alumno.idAlumno"),
        @NamedQuery(name = "Alumno.actividadesPorCurso", query = "select r from Realiza r where r.alumno.elcurso.idCurso = :idCurso")

})
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
    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCurso", foreignKey = @ForeignKey(name = "FK_ALU_CUR"))
    private Curso elcurso;

    // ALUMNO-ACTIVIDAD
    @ToString.Exclude
    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
    private List<Realiza> actividades;




    public Alumno(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }


//    public String toString() {
//        return "Alumno{" +
//                "idAlumno=" + idAlumno +
//                ", nombre='" + nombre + '\'' +
//                ", apellido='" + apellido + '\'' +
//                ", email='" + email + '\'' +
//                '}';
//    }
    @Override
    public String toString(){
       StringBuilder builder = new StringBuilder();
       builder.append("ID: ").append(this.idAlumno).append(" || NOMBRE: ").append(this.nombre).append(" || APELLIDO: ").append(this.apellido).append(" || E-MAIL:").append(this.email).append(" || ");
       return builder.toString();
    }


}


