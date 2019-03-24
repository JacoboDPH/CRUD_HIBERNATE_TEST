package es.formacion.cip.modelo.entidad;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "Tarea")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "Tarea_id")
    private Integer id;

    private Date fechaCreacion;
    private String nombre;

    /**
     * Este constructor vacío es necesario para Hibernate
     */
    public Tarea(){

    }

    /**
     * Constructor para trabajar con las tareas de la BBDD
     * @param nombre
     * @param fechaCreacion
     */
    public Tarea(String nombre, Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        this.nombre = nombre;
    }

    public Integer getId(){ return id;}

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
