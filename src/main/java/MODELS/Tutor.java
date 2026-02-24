package MODELS;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;



@Getter
@Setter
@NoArgsConstructor

@Embeddable
public class Tutor implements Serializable {

    @Serial
    private static final long serialVersionUID = 137L;

    @Column
    private String nombreTutor;

    @Column
    private String email;


    public Tutor(String email, String nombreTutor) {
        this.nombreTutor = nombreTutor;
        this.email = email;

    }


    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(" || TUTOR: ").append(this.nombreTutor).append(" || E-mail: ").append(this.email).append(" || ");
        return builder.toString();
    }

}
