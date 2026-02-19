import MODELS.Curso;
import MODELS.Modulo;
import MODELS.Tutor;
import UTILS.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;








public class Main {
    public static void main(String[] args) {



        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session laSesion = sf.getCurrentSession();


        laSesion.beginTransaction();

        Tutor t1 = new Tutor("paco", "pgalera@gmail.com");
        Tutor t2 = new Tutor("mariano", "eldelaprueba@gmail.com");

        Curso c1 = new Curso("dam", 2, t1);;
        Curso c2 = new Curso("cocina", 1,t2);

        Modulo m1 = new Modulo("PMP", "produccion de masa pastelera", 120);
        Modulo m2 = new Modulo("arroces", "paellas, melosos y de mas", 180);
        Modulo m3 = new Modulo("Acces a dades", "crear bases de datos chulas desde java", 200);
        Modulo m4 = new Modulo("Digitalizacion", "Asignatrura de mas por la cara", 20);


        c1.getLosmodulos().add(m1);
        c1.getLosmodulos().add(m2);
        c2.getLosmodulos().add(m3);
        c2.getLosmodulos().add(m4);

        m1.getLoscursos().add(c1);
        m2.getLoscursos().add(c1);
        m3.getLoscursos().add(c2);
        m4.getLoscursos().add(c2);
        m2.getLoscursos().add(c2);


        laSesion.persist(c1);
        laSesion.persist(c2);

        System.out.println();
        System.out.println("================================================================================");
        System.out.println(c1.getLosmodulos());
        System.out.println(c2.getLosmodulos());
        System.out.println();
        System.out.println(m1.getLoscursos());
        System.out.println(m2.getLoscursos());
        System.out.println(m3.getLoscursos());
        System.out.println(m4.getLoscursos());
        System.out.println("================================================================================");
        System.out.println();

        laSesion.getTransaction().commit();
        laSesion.close();




    }
}
