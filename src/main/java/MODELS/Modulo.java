package MODELS;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@ToString
@NoArgsConstructor
@Entity
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


    @ManyToMany(cascade = CascadeType.PERSIST,
        fetch = FetchType.LAZY,
        mappedBy = "losmodulos")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Curso> loscursos = new HashSet<>();




    public Modulo(String titulo, String descripcion, int horas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.horas = horas;
    }
}
