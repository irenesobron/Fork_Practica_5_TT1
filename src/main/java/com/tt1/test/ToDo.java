package com.tt1.test;
import java.time.LocalDate;

/**
 * Representa una tarea (to-do) dentro del sistema de gestion de tareas.
 * <p>
 * Cada tarea tiene un nombre identificativo, una descripcion opcional,
 * una fecha limite de realizacion y un estado que indica si ha sido completada.
 * </p>
 *
 * @author Irene Sobrón
 */

public class ToDo {
    /** Nombre identificativo de la tarea. */
    private String nombre;
    /** Descripción detallada del contenido o requisitos de la tarea. */
    private String descripcion;
    /** Fecha límite para . */
    private LocalDate dueDate;
    /** Indica si la tarea ha sido completada. */
    private boolean completado;

    /**
     * Construye una tarea vacía con todos los campos a {@code null}
     * y el estado de completado a {@code false}.
     */
    public ToDo() {
        this.nombre = null;
        this.descripcion = null;
        this.dueDate = null;
        this.completado = false;
    }
    /**
     * Construye una tarea con todos sus campos inicializados.
     *
     * @param nombre      nombre identificativo de la tarea
     * @param descripcion descripción detallada de la tarea
     * @param dueDate     fecha límite de realización
     * @param completado  {@code true} si la tarea ya está completada
     */
    public ToDo(String nombre, String descripcion, LocalDate dueDate, boolean completado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dueDate = dueDate;
        this.completado = completado;
    }
    /**
     * Devuelve el nombre del ToDo
     * @return nombre de la tarea
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Establece el nombre de la Tarea
     * @param nombre es el nombre identificativo de la tarea
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Devuelve la descripción de la tarea
     * @return descripcion de la tarea
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Establece la descripcion de la tarea
     * @param descripcion descripcion del ToDo
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Devuelve la fecha limite de la tarea
     * @return dueDate
     */
    public LocalDate getDueDate() {
        return this.dueDate;
    }
    /**
     * Establece la fecha limite para la tarea
     * @param dueDate fecha límite
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    /**
     * Devuelve si la tarea ha sido o no comletada
     * @return {@code true} si la tarea está completada, {@code false} en caso contrario
     */
    public boolean isCompletado() {
        return completado;
    }
    /**
     * Establece el estado de completado de la tarea.
     * @param completado {@code true} para marcarla como completada
     */
    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
}
