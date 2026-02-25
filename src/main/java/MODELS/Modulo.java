package MODELS;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = "Modulo.modulosCursosAnteriores", query = "select m from Curso c join c.losmodulos m where c.anyo < :anio"),
        @NamedQuery(name = "Modulo.modulosSectorHoras", query = "select m from Curso c join c.losmodulos m where c.sector = :sector and m.horas >= 170")
})
public class Modulo implements Serializable {

    @Serial
    private static final long serialVersionUID = 137L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModulo;

    @Column
    private String titulo;

    @Column
    private String descripcion;

    @Column
    private int horas;


    @ManyToMany(mappedBy = "losmodulos", cascade=CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Curso> loscursos = new HashSet<>();




    public Modulo(String titulo, String descripcion, int horas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.horas = horas;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("ID: ").append(this.idModulo).append(" || TITULO: ").append(this.titulo).append(" || DESCRIPCION: ").append(this.descripcion).append(" || HORAS: ").append(this.horas).append(" || ");
        return builder.toString();
    }

}
