package es.formacion.cip.controlador;

import es.formacion.cip.modelo.entidad.Tarea;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import es.formacion.cip.utils.HibernateUtil;

import java.util.Date;
import java.util.List;

public class ControladorTarea {

    /**
     * Método para insertar tarea
     * @param nombre
     * @param fechaCreacion
     */
    public void insertarTarea (String nombre, Date fechaCreacion) {

        Session session = null;
        Transaction tx = null;

        Tarea tarea = new Tarea(nombre,fechaCreacion);

        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();

            session.save(tarea);

            tx.commit();
        }
        catch (Exception e) {
            System.out.println("Se ha generado un error al guardar una tarea "+e.getMessage());
        }
        finally {
            if (session!=null){
                session.close();
            }
        }
    }

    /**
     * Método para recuperar una tarea por su nombre
     * @param nombre
     * @return
     */

    public Tarea recuperarTarea(String nombre) {

        Session session = null;

        try {
            session = HibernateUtil.getSession();

            Query query = session.createQuery("SELECT t FROM Tarea t where nombre=:nombre");
            query.setString("nombre", nombre);
            List<Tarea> tareas = query.list();

            return tareas.get(0);


        } catch (RuntimeException e) {
            System.out.println("Se ha generado un error guardando la tarea:" +e.getMessage());

        } finally {
            if(session != null) {
                session.close();
            }
        }
        return null;
    }
}
