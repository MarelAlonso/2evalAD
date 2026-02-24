import MODELS.*;
import UTILS.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import TECLAT.funIO;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();


        Main main = new Main();


        boolean salir = false;
        while (!salir) {

            System.out.println("======MENU PRINCIPAL======");
            System.out.println("1.Alumno");
            System.out.println("2.Actividad");
            System.out.println("3.Curso");
            System.out.println("4.Modulo");
            System.out.println("5.Realiza");
            System.out.println("6.Consultas y flitrados (2.3.3)");


            System.out.println("9.Salir");

            String opcio = funIO.lligString("Opcion: ");

            switch (opcio) {
                case "1", "Alumno" -> main.menuAlumno();
                case "2", "Actividad" -> main.menuActividad();
                case "3", "Curso" -> main.menuCurso();
                case "4", "Modulo" -> main.menuModulo();
                case "5", "Realiza" -> main.menuRealiza();
                case "6", "Consultas"-> main.menuCunsultas();
                case "9", "salir" -> salir = true;


                default -> System.out.println("opcion no valida");
            }
        }

    }

/// //////////// 2.3.3 CONSULTAS //////////////
    void  menuCunsultas(){


        boolean salir = false;
        while (!salir){
            System.out.println();
            System.out.println("======MENU CONSULTAS======");
            System.out.println("1.Filtrar Alumnos por coincidencia en nombre");
            System.out.println("2.Filtrar Alumnos por coincidencia en nombre del Curso al que pertenece");
            System.out.println("3.Alumnos que han sacado mas de una nota en almenos en 2 Actividades ");
            System.out.println("4.Alumnos que al tienen Alguna actividad sin entregar y nombre de la actividad  ");
            System.out.println("5.Lista de actividades asignadas a los Alumnos de un curso Concreto");
            System.out.println("6.Lista de modulos que pertenezcan a cursos que sean anteriores a un año");
            System.out.println("7.Cursos añadidos al centro entre dos fechas (años)");
            System.out.println("8.Tutores que pertenezcan a cursos de el mismo sector");
            System.out.println("9.Mudulos que pertenezcan a cursos con el mismo sector con mas de 180 horas");

            System.out.println("0.Salir");
            String opcio = funIO.lligString("Opcion: ");

            switch (opcio) {
                case "1" -> filtrarnobre();
                case "2" -> filtraralumnoCursos();
                case "3" -> filtrarAlumNotasAltas();
                case "4" -> filtrarsActNoEntregadas();
                case "5" -> listarActividadesPorCurso();
                case "6" -> listarModulosCursosAnteriores();
                case "7" -> listarCursosEntreAnyos();
                case "8" -> listarTutoresMismoSector();
                case "9" -> listarModulosSectorHoras();
    //


                case "0", "Salir" -> salir = true;


                default -> System.out.println("opcion no valida");


            }

        }
    }
    void filtrarnobre(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();

        String texto = funIO.lligString("Filtrar Nombre alumno: ");

        Query<Alumno> q = sesion.createNamedQuery("Alumno.Buscar-letra", Alumno.class);
        q.setParameter("texto", "%" + texto + "%");

        List<Alumno> lista = q.getResultList();

        System.out.println();
        System.out.println("\t=== Alumnos coincidentes ===");
        for (Alumno a : lista) {
            System.out.println("\t" + a);
        }

        sesion.getTransaction().commit();
        sesion.close();

    }
    void filtraralumnoCursos(){

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();

        String texto = funIO.lligString("Filtrar Alumno por coincidencia en nombre del curso ");

        Query<Alumno> q = sesion.createNamedQuery("Alumno.buscarPorNombreCurso", Alumno.class);

        q.setParameter("texto", "%" + texto + "%");

        System.out.println();
        System.out.println("\t=== Alumnos en Cursos coincidentes con "+ texto +" ===");
        List<Alumno> lista = q.getResultList();
        for (Alumno a : lista) {
            System.out.println("\t" + a + a.getElcurso().getNombreCurso());
        }

        sesion.getTransaction().commit();
        sesion.close();

    }
    void filtrarAlumNotasAltas() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();

        float minNota = funIO.lligFloat("Introduce la nota mínima para filtrar alumnos (ej. 7.0)", 0.0F);

        Query<Alumno> q = sesion.createNamedQuery("Alumno.alumnosConNotasAltas", Alumno.class);
        q.setParameter("minNota", minNota);

        System.out.println("\n=== Alumnos con al menos 2 actividades con nota ≥ " + minNota + " ===");
        List<Alumno> lista = q.getResultList();
        for (Alumno a : lista) {
            System.out.println(a);
        }

        sesion.getTransaction().commit();
    }
    void filtrarsActNoEntregadas() {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();

        Query<Object[]> q = sesion.createNamedQuery("Alumno.actividadesNoEntregadas", Object[].class);
        List<Object[]> lista = q.getResultList();

        System.out.println("\n=== Alumnos con actividades sin entregar ===");

        Alumno alumnoActual = null;

        for (Object[] obj : lista) {

            Alumno a = (Alumno) obj[0];
            Actividad act = (Actividad) obj[1];

            // Si cambia el alumno, lo imprimimos una sola vez
            if (alumnoActual == null || !alumnoActual.equals(a)) {
                alumnoActual = a;
                System.out.println("\n" + a);
                System.out.println("\tAtividades pendientes:");
            }

            // Imprimir actividad debajo
            System.out.println("\t- " + act.getTitulo());
        }

        sesion.getTransaction().commit();
    }
    void listarActividadesPorCurso() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();

        Long idCurso = funIO.lligLong("Introduce el ID del curso para listar actividades");

        Query<Realiza> q = sesion.createNamedQuery("Alumno.actividadesPorCurso", Realiza.class);
        q.setParameter("idCurso", idCurso);

        List<Realiza> lista = q.getResultList();

        // Map para agrupar actividades por alumno
        Map<Alumno, List<Realiza>> actividadesPorAlumno = new LinkedHashMap<>();

        for (Realiza r : lista) {
            actividadesPorAlumno
                    .computeIfAbsent(r.getAlumno(), k -> new ArrayList<>())
                    .add(r);
        }

        // Mostrar la lista
        System.out.println("\n=== Actividades de alumnos del curso ID " + idCurso + " ===");
        for (Map.Entry<Alumno, List<Realiza>> entry : actividadesPorAlumno.entrySet()) {
            Alumno alumno = entry.getKey();
            System.out.println("\nAlumno: " + alumno); // Aquí puedes personalizar con nombre, apellido, etc.
            List<Realiza> actividades = entry.getValue();
            for (Realiza r : actividades) {
                System.out.println("  - Actividad: " + r.getActividad() +
                        " || Entregado: " + r.isEntregado() +
                        " || Nota: " + r.getNota());
            }
        }

        sesion.getTransaction().commit();
    }
    void listarModulosCursosAnteriores() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();

        int anio = funIO.lligInt("Introduce el año límite");

        Query<Modulo> q = sesion.createNamedQuery("Modulo.modulosCursosAnteriores", Modulo.class);
        q.setParameter("anio", anio);

        System.out.println("\n=== Módulos de cursos anteriores a " + anio + " ===");
        List<Modulo> lista = q.getResultList();
        for (Modulo m : lista) {
            System.out.println(m);
        }

        sesion.getTransaction().commit();
    }
    void listarCursosEntreAnyos(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();

        int inicio = funIO.lligInt("Introduce año inicio");
        int fin = funIO.lligInt("Introduce año fin");

        Query<Curso> q = sesion.createNamedQuery("Curso.cursosEntreAnios", Curso.class);
        q.setParameter("anioInicio", inicio);
        q.setParameter("anioFin", fin);

        System.out.println("\n=== Cursos entre " + inicio + " y " + fin + " ===");
        List<Curso> lista = q.getResultList();
        for (Curso c : lista) {
            System.out.println(c);
        }

        sesion.getTransaction().commit();
    }
    void listarTutoresMismoSector() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();

        String sector = funIO.lligString("Introduce el sector para filtrar tutores (Sanidad, Ciencia, Empresa, Educacion)");

        Query<Object[]> q = sesion.createNamedQuery("Curso.tutoresMismoSector", Object[].class);
        q.setParameter("sector", sector);

        System.out.println("\n=== Tutores de cursos del sector " + sector + " ===");
        List<Object[]> lista = q.getResultList();
        for (Object[] obj : lista) {
            System.out.println("Tutor: " + obj[0] + " || Email: " + obj[1]);
        }

        sesion.getTransaction().commit();
    }
    void listarModulosSectorHoras() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();

        String sector = funIO.lligString("Introduce el sector para filtrar módulos");

        Query<Modulo> q = sesion.createNamedQuery("Modulo.modulosSectorHoras", Modulo.class);
        q.setParameter("sector", sector);

        System.out.println("\n=== Módulos del sector " + sector + " con más de 180 horas ===");
        List<Modulo> lista = q.getResultList();
        for (Modulo m : lista) {
            System.out.println(m);
        }

        sesion.getTransaction().commit();
    }



    /// ////// ALUMNO///////////////////
    void menuAlumno() {

        boolean salir = false;
        while (!salir) {
            System.out.println();
            System.out.println("======MENU ALUMNO======");
            System.out.print("1.Insertar || ");
            System.out.println("1-r.Insertar -r");
            System.out.println("2 Modificar");
            System.out.println("3 Eliminar");
            System.out.print("4.Buscar || ");
            System.out.println("4-r.Buscar-r");
            System.out.print("5.Mostrar Todos");
            System.out.println(" || 5-r.Mostrar-r Todos");

            System.out.println("9.Salir");
            String opcio = funIO.lligString("Opcion: ");

            switch (opcio) {
                case "1", "insertar"-> insertaralu();
                case "1-r", "insertar -r"-> insertarAluRecursivo();
                case "2", "modificar"-> updatealu();
                case "3", "eliminar"-> eliminaralu();
                case "4",  "buscar"-> buscaralu();
                case "4-r", "buscar -r"-> buscaraluRecursivo();
                case "5", "mostrar"-> listarAlumnos();
                case "5-r", "mostrar-r"-> listarAlumnosRecursivo();

                case "9", "salir"-> salir = true;


                default -> System.out.println("opcion no valida");


            }
        }

    }
    void insertaralu(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();

        System.out.println("===Insertar Alumno===");
        String nom = funIO.lligString("Nombre: ");
        String apellido = funIO.lligString("Apellido: ");
        String email = funIO.lligString("Email: ");

        Alumno alumno = new Alumno();
        alumno.setNombre(nom);
        alumno.setApellido(apellido);
        alumno.setEmail(email);

        System.out.println("se ha insertado el Alumno: " + nom + " " + apellido);


        sesion.beginTransaction();
        sesion.persist(alumno);
        sesion.getTransaction().commit();
        sesion.close();


    }
    void insertarAluRecursivo() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();

        System.out.println();
        System.out.println("=== Insertar Alumno Recursivamente ===");

        String nom = funIO.lligString("Nombre: ");
        String apellido = funIO.lligString("Apellido: ");
        String email = funIO.lligString("Email: ");
        sesion.beginTransaction();
        System.out.println();
        System.out.println("=== Lista de Cursos ===");


        Query<Curso> q = sesion.createQuery("from Curso");
        List<Curso> cursos = q.getResultList();
        for (Curso curso : cursos) {
            System.out.println("ID: " + curso.getIdCurso() + " || Nombre: " + curso.getNombreCurso());
        }
        Long idc = (long) funIO.lligInt("Intriducir Id Para asignar curso al Alumno || introducir (0) para crear nuevo curso: ");


        if (idc == 0) {
            System.out.println();
            System.out.println("=== CREAR CURSO PARA ASIGNAR ALUMNO ===");
            String nomc = funIO.lligString("Nombre: ");
            String sectorc = funIO.lligString("Sector: ");
            int anyo = funIO.lligInt("Año: ");
            String Nomt = funIO.lligString("Tutor: ");
            String mail = funIO.lligString("E-mail: ");

            Curso c = new Curso();
            Tutor t = new Tutor();
            System.out.println();
            c.setNombreCurso(nomc);
            c.setSector(sectorc);
            c.setAnyo(anyo);
            c.setTutor(t);
            t.setNombreTutor(Nomt);
            t.setEmail(mail);

            sesion.persist(c);


            Alumno a = new Alumno();
            a.setNombre(nom);
            a.setApellido(apellido);
            a.setEmail(email);
            a.setElcurso(c);

            System.out.println("se ha insertado el Alumno: " + nom + " " + apellido + " en el curso: " + c.getNombreCurso());
            sesion.persist(a);

        } else {
            Curso c = sesion.get(Curso.class, idc);
            if (c != null) {

                Alumno a = new Alumno();
                a.setNombre(nom);
                a.setApellido(apellido);
                a.setEmail(email);
                a.setElcurso(c);

                System.out.println("se ha insertado el Alumno: " + nom + " " + apellido + " en el curso: " + c.getNombreCurso());
                sesion.persist(a);
            }

        }

        sesion.getTransaction().commit();
        sesion.close();



    }
    void updatealu(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();

        Long id = (long) funIO.lligInt("introduce el id de el alumno de la lista que quieres modificar (pulsa intro per a no modificar)");


        Alumno a = sesion.get(Alumno.class, id);
        if (a != null) {
            String nom = funIO.lligString("Nombre: ");
            String apellido = funIO.lligString("Apellido: ");
            String email = funIO.lligString("Email: ");

            if (!nom.isEmpty()) a.setNombre(nom);
            if (!apellido.isEmpty()) a.setApellido(apellido);
            if (!email.isEmpty()) a.setEmail(email);
            sesion.persist(a);
            System.out.println("Alumno modificado" + a.toString());
        }else {
            System.out.println("No existe el alumno con el id: " + id);
        }

        sesion.getTransaction().commit();
        sesion.close();
    }
    void eliminaralu(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();

        Long id = (long) funIO.lligInt("introduce el id de el alumno de la lista que quieres eliminar");
        Alumno a = sesion.get(Alumno.class, id);
        if (a != null) {
            sesion.delete(a);
            System.out.println("Alumno eliminado" + a.toString());
        }else{
            System.out.println("No existe el alumno con el id: " + id);
        }
        sesion.getTransaction().commit();
        sesion.close();


    }
    void buscaralu() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();
        Long id = (long) funIO.lligInt("introduce el id de el Alumno que Buscar");
        Alumno a = sesion.get(Alumno.class, id);
        if(a != null){
            System.out.println("Actividad encontrada:" + a.toString());
        }else {
            System.out.println("No existe el actividad con el id: " + id);
        }
        sesion.getTransaction().commit();
        sesion.close();
    }
    void buscaraluRecursivo() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();
        Long id = (long) funIO.lligInt("introduce el id de el Alumno que Buscar");
        Alumno a = sesion.get(Alumno.class, id);
        if(a != null){
            System.out.println();
            System.out.println("Alumno encontrada:" + a.toString());

            Query<Object[]> q = sesion.createNamedQuery("Alumno.buscar-rec", Object[].class);
            q.setParameter("idAlumno", id);
            List<Object[]> acts = q.getResultList();
            System.out.println();
            System.out.println("=== Actividades de el Alumno ===");
            for(Object[] fila : acts){
                Long idAct = (Long) fila[0];
                String titulo = (String) fila[1];
                String descripcion = (String) fila[2];
                Boolean entregado = (Boolean) fila[3];
                Float nota = (Float) fila[4];

                System.out.println("\tId: " + idAct + " || Titulo: " + titulo + " || Descripcion: " + descripcion + " || Entregado " + entregado + " || Nota: " + nota);
            }

        }else {
            System.out.println("No existe el Alumno con el id: " + id);
        }
        sesion.getTransaction().commit();
        sesion.close();
    }
    void listarAlumnos(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();

        Query<Alumno> q=sesion.createQuery("from Alumno");
        List<Alumno> alumnos =  q.getResultList();
        for (Alumno alumno : alumnos) {
            System.out.print(alumno);
            if(alumno.getElcurso()!=null){
                System.out.println(alumno.getElcurso().getNombreCurso());
            }else{
                System.out.println("Curso no asignado");
            }
        }
        sesion.getTransaction().commit();
        sesion.close();
    }
    void listarAlumnosRecursivo(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();



        Query<Alumno> q=sesion.createQuery("from Alumno");
        List<Alumno> alumnos =  q.getResultList();
        for (Alumno alumno : alumnos) {

            System.out.println();
            System.out.print("\tAlumno: " + alumno);

            if(alumno.getElcurso()!=null){
                System.out.println(alumno.getElcurso().getNombreCurso());
            }else{
                System.out.println("Curso no asignado");
            }

            Query<Object[]> q2 = sesion.createNamedQuery("Alumno.buscar-rec", Object[].class);
            q2.setParameter("idAlumno", alumno.getIdAlumno());
            List<Object[]> acts = q2.getResultList();

            System.out.println("\t\t=== Actividades para Alumn@ " + alumno.getNombre() + " " + alumno.getApellido() + " ===");
            for(Object[] fila : acts){
                Long idAct = (Long) fila[0];
                String titulo = (String) fila[1];
                String descripcion = (String) fila[2];
                Boolean entregado = (Boolean) fila[3];
                Float nota = (Float) fila[4];

                System.out.println("\t\tId: " + idAct + " || Titulo: " + titulo + " || Descripcion: " + descripcion + " || Entregado " + entregado + " || Nota: " + nota);
            }
        }
        sesion.getTransaction().commit();
        sesion.close();
    }



    /// ////// ACTIVIDAD ///////////////////
    void menuActividad() {

        boolean salir = false;
        while (!salir) {
            System.out.println();
            System.out.println("======MENU ACTIVIDAD======");
            System.out.println("1.Insertar");
            System.out.println("2.Modificar");
            System.out.println("3.Eliminar");
            System.out.println("4.Buscar");
            System.out.println("5.Mostrar Todos");

            System.out.println("9.Salir");
            String opcio = funIO.lligString("Opcion: ");

            switch (opcio) {
                case "1", "insertar"-> insertarAct();
                case "2", "modificar"-> updateAct();
                case "3", "eliminar"-> eliminarAct();
                case "4", "Buscar" -> buscarAct();
                case "5", "mostrar todo"-> listarAct();
                case "9", "salir"-> salir = true;


                default -> System.out.println("opcion no valida");


            }
        }

    }
    void insertarAct(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();

        System.out.println("===Insertar Actividad===");
        String nom = funIO.lligString("Titulo: ");
        String desc = funIO.lligString("Descripcion: ");

        Actividad act = new Actividad();
        act.setTitulo(nom);
        act.setDescripcion(desc);

        System.out.println("se ha insertado la Actividad: " + nom );

        sesion.beginTransaction();
        sesion.persist(act);
        sesion.getTransaction().commit();
        sesion.close();

    }
    void updateAct(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();

        Long id = (long) funIO.lligInt("introduce el id de la aactividad que quieres modificar (pulsa intro per a no modificar)");


        Actividad a = sesion.get(Actividad.class, id);
        if(a != null){
            String nom = funIO.lligString("Titulo: ");
            String desc = funIO.lligString("Descripcion: ");

            if (!nom.isEmpty()) a.setTitulo(nom);
            if (!desc.isEmpty())  a.setDescripcion(desc);
            sesion.persist(a);
            System.out.println("Los datos actuales son: " + a.toString());
        }else{
            System.out.println("No existe el actividad con el id: " + id);
        }

        sesion.getTransaction().commit();
        sesion.close();
    }
    void eliminarAct() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();

        Long id = (long) funIO.lligInt("introduce el id de la actividad que quieres eliminar");
        Actividad a = sesion.get(Actividad.class, id);
        if (a != null) {
            sesion.delete(a);
            System.out.println("Actividad elimnada:" + a.toString());
        } else{
            System.out.println("No existe el actividad con el id: " + id);
        }
        sesion.getTransaction().commit();
        sesion.close();



    }
    void buscarAct() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();
        Long id = (long) funIO.lligInt("introduce el id de la actividad que Buscar");
        Actividad a = sesion.get(Actividad.class, id);
        if(a != null){
            System.out.println("Actividad encontrada:" + a.toString());
        }else {
            System.out.println("No existe el actividad con el id: " + id);
        }
        sesion.getTransaction().commit();
        sesion.close();
    }
    void listarAct(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();

        Query<Actividad> q=sesion.createQuery("from Actividad ");
        List<Actividad> acts =  q.getResultList();
        for (Actividad act: acts) {
            System.out.println(act.toString());

        }
        sesion.getTransaction().commit();
        sesion.close();
    }


    /// ////// CURSO///////////////////
    void menuCurso() {

        boolean salir = false;
        while (!salir) {
            System.out.println();
            System.out.println("======MENU CURSO======");
            System.out.println("1.Insertar");
            System.out.println("2.Modificar");
            System.out.println("3.Eliminar");
            System.out.println("4.Buscar");
            System.out.println("5.Mostrar Todos");

            System.out.println("9.Salir");
            String opcio = funIO.lligString("Opcion: ");

            switch (opcio) {
                case "1", "insertar"-> insertarcur();
                case "2", "modificar"-> updatecur();
                case "3", "eliminar"-> eliminarcur();
                case "4", "Buscar"-> buscarcur();
                case "5", "mostrar"-> listarcur();
                case "9", "salir"-> salir = true;

                default -> System.out.println("opcion no valida");


            }
        }

    }
    void insertarcur(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();

        System.out.println("===Insertar Curso===");
        String nom = funIO.lligString("Nombre: ");
        String sec = funIO.lligString("Sector: ");
        int anyo = funIO.lligInt("año: ");
        String tutor = funIO.lligString("Tutor: ");
        String email = funIO.lligString("Email: ");

        Curso c = new Curso();
        Tutor t  = new Tutor();
        c.setNombreCurso(nom);
        c.setSector(sec);
        c.setAnyo(anyo);
        c.setTutor(t);
        t.setNombreTutor(tutor);
        t.setEmail(email);

        System.out.println("se ha insertado el Curso: " + nom);

        sesion.beginTransaction();
        sesion.persist(c);
        sesion.getTransaction().commit();
        sesion.close();


    }
    void updatecur(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();

        Long id = (long) funIO.lligInt("introduce el id de el Curso que quieres modificar (pulsa intro para no modificar)");


        Curso c = sesion.get(Curso.class, id);
        if (c == null) {
            System.out.println("No existe el Curso con el id: " + id);
            sesion.getTransaction().commit();
            sesion.close();
            return;
        }

        Tutor t = c.getTutor();

        String nom = funIO.lligString("Nombre: ");
        String sec = funIO.lligString("Sector: ");
        String anyo = funIO.validarNum("Año: ");
        String ntutor = funIO.lligString("Tutor: ");
        String email = funIO.lligString("Email tutor: ");

        if (!nom.isEmpty()) c.setNombreCurso(nom);
        if (!sec.isEmpty()) c.setSector(sec);
        if (!anyo.isEmpty())c.setAnyo(Integer.parseInt(anyo));
        if (!ntutor.isEmpty())t.setNombreTutor(ntutor);
        if (!email.isEmpty())t.setEmail(email);
        sesion.persist(c);
        System.out.println("Curso modificado" + c.toString());

        sesion.getTransaction().commit();
        sesion.close();
    }
    void eliminarcur() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Transaction tx = null;

        try {
            tx = sesion.beginTransaction();

            Long id = (long) funIO.lligInt("Introduce el id del Curso que quieres eliminar: ");
            Curso c = sesion.get(Curso.class, id);

            if (c != null) {

                //  Limpiar tabla intermedia ManyToMany directamente con SQL nativo
                sesion.createNativeQuery("DELETE FROM Pertenece WHERE idCurso = :id")
                        .setParameter("id", id)
                        .executeUpdate();

                //  Desvincular alumnos
                sesion.createQuery("UPDATE Alumno a SET a.elcurso = NULL WHERE a.elcurso.idCurso = :id")
                        .setParameter("id", id)
                        .executeUpdate();

                // Eliminar el curso
                sesion.remove(c);

                System.out.println("Curso eliminado:" + c);

            } else {
                System.out.println("No existe el Curso con el id: " + id);
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            sesion.close();
        }
    }
    void buscarcur() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();
        Long id = (long) funIO.lligInt("introduce el id de el Curso que Buscar");
        Curso c = sesion.get(Curso.class, id);
        if(c != null){
            System.out.println("Curso encontrado:" + c.toString());
        }else {
            System.out.println("No existe el Curso con el id: " + id);
        }
        sesion.getTransaction().commit();
        sesion.close();
    }
    void listarcur(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();

        Query<Curso> q=sesion.createQuery("from Curso");
        List<Curso> cursos =  q.getResultList();
        for (Curso cur: cursos) {
            System.out.println(cur);
        }
        sesion.getTransaction().commit();
        sesion.close();
    }


    /// ////// MODULO///////////////////
    void menuModulo() {

        boolean salir = false;
        while (!salir) {
            System.out.println();
            System.out.println("======MENU MODULO======");
            System.out.println("1.Insertar");
            System.out.println("2.Modificar");
            System.out.println("3.Eliminar");
            System.out.println("4.Buscar");
            System.out.println("5.Mostrar Todos");

            System.out.println("9.Salir");
            String opcio = funIO.lligString("Opcion: ");

            switch (opcio) {
                case "1", "insertar"-> insertarMod();
                case "2", "modificar"-> updateMod();
                case "3", "eliminar"-> eliminarMod();
                case "4", "buscar"-> buscarMod();
                case "5", "mostrar"-> listarMod();
                case "9", "salir"-> salir = true;

                default -> System.out.println("opcion no valida");


            }
        }

    }
    void insertarMod(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();

        System.out.println("===Insertar Modulo===");
        String tit = funIO.lligString("Titulo: ");
        String desc = funIO.lligString("Descripcion: ");
        int horas = funIO.lligInt("Horas: ");

        Modulo mod = new Modulo();
        mod.setTitulo(tit);
        mod.setDescripcion(desc);
        mod.setHoras(horas);

        System.out.println("se ha insertado el Modulo: " + tit);


        sesion.beginTransaction();
        sesion.persist(mod);
        sesion.getTransaction().commit();
        sesion.close();


    }
    void updateMod(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();

        Long id = (long) funIO.lligInt("introduce el id de Modulo que quieres modificar (pulsa intro per a no modificar)");
        String tit = funIO.lligString("Titulo: ");
        String desc = funIO.lligString("Descripcion: ");
        String horas = funIO.validarNum("Horas: ");

        Modulo m = sesion.get(Modulo.class, id);
        if (m != null) {
            if (!tit.isEmpty()) m.setTitulo(tit);
            if (!desc.isEmpty()) m.setDescripcion(desc);
            if (!horas.isEmpty()) m.setHoras(Integer.parseInt(horas));


            sesion.persist(m);
            System.out.println("Modulo modificado" + m);
        }else {
            System.out.println("No existe el Modulo con el id: " + id);
        }

        sesion.getTransaction().commit();
        sesion.close();
    }
    void eliminarMod(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();

        Long id = (long) funIO.lligInt("introduce el id de el Modulo que quieres eliminar");
        Modulo m = sesion.get(Modulo.class, id);
        if (m != null) {
            sesion.delete(m);
            System.out.println("Modulo eliminado" + m);
        }else{
            System.out.println("No existe el Modulo con el id: " + id);
        }
        sesion.getTransaction().commit();
        sesion.close();


    }
    void buscarMod() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();
        Long id = (long) funIO.lligInt("introduce el id de el Modulo que Buscar");
        Modulo m = sesion.get(Modulo.class, id);
        if(m != null){
            System.out.println("Modulo encontrado:" + m);
        }else {
            System.out.println("No existe el Modulo con el id: " + id);
        }
        sesion.getTransaction().commit();
        sesion.close();
    }
    void listarMod(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();

        Query<Alumno> q=sesion.createQuery("from Alumno");
        List<Alumno> alumnos =  q.getResultList();
        for (Alumno alumno : alumnos) {
            System.out.print(alumno);
            if(alumno.getElcurso()!=null){
                System.out.println(alumno.getElcurso().getNombreCurso());
            }else{
                System.out.println("Curso no asignado");
            }
        }
        sesion.getTransaction().commit();
        sesion.close();
    }


    /// ////// REALIZA///////////////////
    void menuRealiza() {

        boolean salir = false;
        while (!salir) {
            System.out.println("======MENU REALIZA======");
            System.out.println("1.Insertar");
            System.out.println("2 Modificar");
            System.out.println("3 Eliminar");
            System.out.println("4 Buscar");
            System.out.println("5 Mostrar todo");


            System.out.println("9.Salir");
            String opcio = funIO.lligString("Opcion: ");

            switch (opcio) {
                case "1", "insertar"-> insertarRealiza();
                case "2", "modificar"-> updateRealiza();
                case "3", "eliminar"-> eliminarRealiza();
                case "4", "buscar"-> buscarRealiza();
                case "5", "mostrar"-> listarRealiza();
                case "9", "salir"-> salir = true;


                default -> System.out.println("opcion no valida");


            }
        }

    }
    void insertarRealiza(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();

        System.out.println("===Insertar Alumno===");
        String nom = funIO.lligString("Nombre: ");
        String apellido = funIO.lligString("Apellido: ");
        String email = funIO.lligString("Email: ");

        Alumno alumno = new Alumno();
        alumno.setNombre(nom);
        alumno.setApellido(apellido);
        alumno.setEmail(email);

        System.out.println("se ha insertado el Alumno: " + nom + " " + apellido);


        sesion.beginTransaction();
        sesion.persist(alumno);
        sesion.getTransaction().commit();
        sesion.close();


    }
    void updateRealiza(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();

        Long id = (long) funIO.lligInt("introduce el id de el alumno de la lista que quieres modificar (pulsa intro per a no modificar)");
        String nom = funIO.lligString("Nombre: ");
        String apellido = funIO.lligString("Apellido: ");
        String email = funIO.lligString("Email: ");

        Alumno a = sesion.get(Alumno.class, id);
        if (a != null) {
            if (!nom.isEmpty()) a.setNombre(nom);
            if (!apellido.isEmpty()) a.setApellido(apellido);
            if (!email.isEmpty()) a.setEmail(email);
            sesion.persist(a);
            System.out.println("Alumno modificado" + a.toString());
        }else {
            System.out.println("No existe el alumno con el id: " + id);
        }

        sesion.getTransaction().commit();
        sesion.close();
    }
    void eliminarRealiza(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();

        Long id = (long) funIO.lligInt("introduce el id de el alumno de la lista que quieres eliminar");
        Alumno a = sesion.get(Alumno.class, id);
        if (a != null) {
            sesion.delete(a);
            System.out.println("Alumno eliminado" + a.toString());
        }else{
            System.out.println("No existe el alumno con el id: " + id);
        }
        sesion.getTransaction().commit();
        sesion.close();


    }
    void buscarRealiza() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();
        Long id = (long) funIO.lligInt("introduce el id de el Alumno que Buscar");
        Alumno a = sesion.get(Alumno.class, id);
        if(a != null){
            System.out.println("Actividad encontrada:" + a.toString());
        }else {
            System.out.println("No existe el actividad con el id: " + id);
        }
        sesion.getTransaction().commit();
        sesion.close();
    }
    void listarRealiza(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        sesion.beginTransaction();

        Query<Alumno> q=sesion.createQuery("from Alumno");
        List<Alumno> alumnos =  q.getResultList();
        for (Alumno alumno : alumnos) {
            System.out.print(alumno);
            if(alumno.getElcurso()!=null){
                System.out.println(alumno.getElcurso().getNombreCurso());
            }else{
                System.out.println("Curso no asignado");
            }
        }
        sesion.getTransaction().commit();
        sesion.close();
    }



    /// ////// ALUMNO///////////////////






}
