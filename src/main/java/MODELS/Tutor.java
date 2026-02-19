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
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Tutor implements Serializable {

    @Serial
    private static final long serialVersionUID = 137L;

    @Column
    private String nombreTutor;

    @Column
    private String email;




}
