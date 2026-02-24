package conn;

import UTILS.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Inserts {

    /**
     * Ejecuta un archivo SQL línea por línea usando Hibernate
     * @param archivo nombre del archivo SQL (debe estar en resources)
     */
    public static void ejecutarArchivoSQL(String archivo) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.getCurrentSession();
        Transaction tx = sesion.beginTransaction();

        try {
            InputStream is = Inserts.class.getClassLoader().getResourceAsStream(archivo);
            if (is == null) {
                System.out.println("Archivo SQL no encontrado: " + archivo);
                return;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;
            StringBuilder sb = new StringBuilder();

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty() || linea.startsWith("--") || linea.startsWith("SET")) continue;
                sb.append(linea);
                // Ejecuta cada sentencia completa
                if (linea.endsWith(";")) {
                    String sql = sb.toString();
                    sesion.createNativeQuery(sql).executeUpdate();
                    sb = new StringBuilder();
                }
            }

            br.close();
            tx.commit();
            System.out.println("SQL ejecutado correctamente desde: " + archivo);

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (sesion != null && sesion.isOpen()) sesion.close();
        }
    }

    /** Ejecuta el archivo instituto_inserts.sql */
    public static void insertarDatos() {
        ejecutarArchivoSQL("instituto_inserts.sql");
    }

    /** Borra todas las tablas de datos (resetea base de datos vacía) */
    public static void borrarDatos() {
        ejecutarArchivoSQL("instituto_delete.sql"); // archivo opcional con TRUNCATE TABLE o DELETE
    }
}