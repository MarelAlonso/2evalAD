package conn;

import MODELS.*;
import UTILS.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class Inserts_c {






//    public static void insertar2(){
//
//        SessionFactory sf = HibernateUtil.getSessionFactory();
//        Session session = sf.getCurrentSession();
//        session.beginTransaction();
//
//        // =========================
//        // 1️⃣ Crear cursos con Tutor embebido
//        // =========================
//        List<Curso> cursos = new ArrayList<>();
//        cursos.add(new Curso(2025, "DAW", "Ciencia", new Tutor("Carlos Perez", "carlos@instituto.es")));
//        cursos.add(new Curso(2025, "ASIR", "Ciencia", new Tutor("Laura Gomez", "laura@instituto.es")));
//        cursos.add(new Curso(2025, "Dietetica", "Alimentacion", new Tutor("Ana Martinez", "ana@instituto.es")));
//        cursos.add(new Curso(2025, "Educacion Infantil", "Educacion", new Tutor("Sonia Ruiz", "sonia@instituto.es")));
//        cursos.add(new Curso(2025, "Integracion Social", "Educacion", new Tutor("Miguel Torres", "miguel@instituto.es")));
//        cursos.add(new Curso(2025, "Administracion y Finanzas", "Empresa", new Tutor("Lucia Navarro", "lucia@instituto.es")));
//
//        cursos.forEach(session::persist);
//
//        // =========================
//        // 2️⃣ Crear módulos
//        // =========================
//        List<Modulo> modulos = new ArrayList<>();
//        String[][] modulosDatos = {
//                {"Programacion Java","Programacion","200"},
//                {"Bases de Datos","BBDD","180"},
//                {"Entornos Desarrollo","Entornos","120"},
//                {"Lenguajes Marcas","LMSGI","140"},
//                {"Sistemas Informaticos","Sistemas","160"},
//                {"FOL","FOL","90"},
//                {"Implantacion Sistemas","Implantacion","200"},
//                {"Seguridad Informatica","Seguridad","180"},
//                {"Servicios Red","Servicios","160"},
//                {"Hardware","Hardware","140"},
//                {"Sistemas Operativos","SO","200"},
//                {"Empresa e Iniciativa","EIE","90"},
//                {"Organizacion Alimentaria","Organizacion","150"},
//                {"Control Alimentario","Control","160"},
//                {"Microbiologia","Microbiologia","180"},
//                {"Fisiopatologia","Fisiopatologia","150"},
//                {"Educacion Sanitaria","EducacionSanitaria","120"},
//                {"Dietoterapia","Dietoterapia","170"},
//                {"Didactica","Didactica","200"},
//                {"Autonomia Personal","Autonomia","150"},
//                {"Juego Infantil","Juego","120"},
//                {"Desarrollo Cognitivo","Cognitivo","160"},
//                {"Expresion y Comunicacion","Expresion","140"},
//                {"Primeros Auxilios","PrimerosAux","90"},
//                {"Mediacion","Mediacion","160"},
//                {"Habilidades Sociales","Habilidades","150"},
//                {"Intervencion Familiar","Intervencion","170"},
//                {"Insercion Laboral","Insercion","120"},
//                {"Promocion Autonomia","Promocion","140"},
//                {"Metodologia Social","Metodologia","160"},
//                {"Contabilidad","Contabilidad","200"},
//                {"Gestion Financiera","Finanzas","180"},
//                {"Fiscalidad","Fiscalidad","160"},
//                {"RRHH","RRHH","140"},
//                {"Ofimatica","Ofimatica","120"},
//                {"Proyecto Empresa","Proyecto","150"}
//        };
//
//        for (String[] dato : modulosDatos) {
//            Modulo m = new Modulo(
//                    dato[0],                     // titulo
//                    dato[1],                     // descripcion
//                    Integer.parseInt(dato[2])    // horas
//            );
//            modulos.add(m);
//            session.persist(m);
//        }
//
//        // =========================
//        // 3️⃣ Crear alumnos y asignar cursos
//        // =========================
//        List<Alumno> alumnos = new ArrayList<>();
//        String[][] alumnosDatos = {
//                {"Juan","Garcia Lopez","juan1@instituto.es"},
//                {"Ana","Perez Ruiz","ana2@instituto.es"},
//                {"Luis","Martinez Soto","luis3@instituto.es"},
//                {"Marta","Sanchez Diaz","marta4@instituto.es"},
//                {"Pablo","Romero Gil","pablo5@instituto.es"},
//                {"Lucia","Torres Vega","lucia6@instituto.es"},
//                {"Alberto","Navarro Cano","alberto7@instituto.es"},
//                {"Clara","Moreno Lara","clara8@instituto.es"},
//                {"David","Jimenez Ortiz","david9@instituto.es"},
//                {"Sara","Ruiz Ramos","sara10@instituto.es"}
//        };
//
//        for (int i = 0; i < alumnosDatos.length; i++) {
//            Alumno a = new Alumno(alumnosDatos[i][0], alumnosDatos[i][1], alumnosDatos[i][2]);
//            Curso c = cursos.get(i % cursos.size());
//            c.addAlumno(a);
//            alumnos.add(a);
//            session.persist(a);
//        }
//
//        // =========================
//        // 4️⃣ Crear actividades
//        // =========================
//        List<Actividad> actividades = new ArrayList<>();
//        String[][] actividadesDatos = {
//                {"Practica Java 1","Primera práctica de Java","2025-03-01 10:00:00"},
//                {"Examen BBDD","Examen de bases de datos","2025-03-10 09:00:00"},
//                {"Proyecto Final","Proyecto final del curso","2025-04-15 12:00:00"},
//                {"Trabajo Seguridad","Trabajo sobre seguridad informática","2025-03-05 11:00:00"},
//                {"Practica Redes","Práctica de redes","2025-03-20 10:00:00"}
//        };
//
//        for (String[] dato : actividadesDatos) {
//            Actividad act = new Actividad();
//            act.setTitulo(dato[0]);
//            act.setDescripcion(dato[1]);
//            act.setFecha(java.sql.Timestamp.valueOf(dato[2]));
//            actividades.add(act);
//            session.persist(act);
//        }
//
////        // =========================
////        // 5️⃣ Crear relaciones Realiza (Alumno ↔ Actividad)
////        // =========================
////        for (Alumno a : alumnos) {
////            for (int i = 0; i < 2; i++) {
////                Actividad act = actividades.get((int) (Math.random() * actividades.size()));
////
////                Realiza r = new Realiza();
////                r.setAlumno(a);
////                r.setActividad(act);
////                r.setEntregado(Math.random() > 0.2);
////                r.setNota((float) (Math.random() * 10));
////
////                a.getActividades().add(r);
////                act.getAlumnos().add(r);
////
////                session.persist(r);
////            }
////        }
////
////        // =========================
////        // 6️⃣ Crear relaciones Pertenece (Curso ↔ Modulo)
////        // =========================
////        for (Curso c : cursos) {
////            for (int i = 0; i < 7; i++) { // 7 módulos por curso
////                Modulo m = modulos.get((int) (Math.random() * modulos.size()));
////                c.getLosmodulos().add(m);
////                m.getLoscursos().add(c); // si tienes mappedBy en Modulo
////            }
////            session.persist(c);
////        }
////
//        session.getTransaction().commit();
//        session.close();
//        System.out.println("Datos generados correctamente!");
//    }
}