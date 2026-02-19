package MODELS;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;


@ToString
@NoArgsConstructor
@Data
@Embeddable
public class Compuesta_alu_act implements Serializable {

    @Serial
    private static final long serialVersionUID = 137L;


    private Long idAlumno;
    private Long idActividad;





}
