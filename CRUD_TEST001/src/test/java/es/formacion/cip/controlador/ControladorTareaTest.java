package es.formacion.cip.controlador;

import es.formacion.cip.modelo.entidad.Tarea;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class ControladorTareaTest {

    public static final String NOMBRE_TAREA = "TEST";

    private static Date fechaCreacion = new Date();

    ControladorTarea controladorTarea = null;

    @Before
    public void before(){
        if (controladorTarea == null){
            controladorTarea = new ControladorTarea();
        }
    }

    @Test
    public void insertarTarea() {

        controladorTarea.insertarTarea(NOMBRE_TAREA,fechaCreacion);

        Tarea tareaObtenida = controladorTarea.recuperarTarea(NOMBRE_TAREA);


        Assert.assertEquals("Se ha obtenido el resultado esperado",tareaObtenida.getNombre(),NOMBRE_TAREA);


    }
}
