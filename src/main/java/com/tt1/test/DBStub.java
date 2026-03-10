package com.tt1.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Simulación de una base de datos para el almacenamiento de tareas y correos.
 *
 * @author Irene Sobrón
 */
public class DBStub {
    /** Lista interna de tareas almacenadas en memoria. */
    private List<ToDo> Lista;
    /** Lista interna de direcciones de correo almacenadas en memoria. */
    private List<String> email;
    /**
     * Construye una base de datos vacía, inicializando las listas internas.
     */
    public DBStub() {
        Lista = new ArrayList<>();
        email = new ArrayList<>();
    }
    /**
     * Almacena una nueva tarea en la base de datos.
     *
     * @param tarea1 tarea a almacenar
     */
    public void crearTarea(ToDo tarea1) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    /**
     * Devuelve todas las tareas almacenadas en la base de datos.
     *
     * @return lista de tareas
     */
    public List<ToDo> obtenerTareas() {
        throw new UnsupportedOperationException("Clase aun no implementada");
    }
    /**
     * Buscar una tarea con el nombre indicado
     *
     * @param nombre  es el nombre de la tarea
     *
     * @return ToDo devuelve una tarea
     */
    public ToDo buscarTarea(String nombre) {
        throw new UnsupportedOperationException("Clase aun no implementada");
    }
    /**
     * Actualizar una tarea
     *
     * @param tarea Indica la tarea que se desea actualizar
     *
     * @return {@code true} si la tarea se ha actualizado, {@code false} en caso contrario
     */
    public boolean actualizarTarea(ToDo tarea) {
        throw new UnsupportedOperationException("Clase aún");
    }
    /**
     * Eliminar una tarea
     *
     * @param nombre String que indica el nombre de una tarea
     *
     * @return {@code true} si la tarea se ha eliminado, {@code false} en caso contrario
     */
    public boolean delete(String nombre) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    /**
     * Añade un email a la lista de emails
     *
     * @param email Indica la direccion de correo electronico
     */
    public void agregarEmail(String email) {
        throw new UnsupportedOperationException("Clase aun no implementada.");
    }
    /**
     * Obtener la lista de emails.
     *
     * @return lista con todas las direcciones de correo electronico
     */
    public List<String> obtenerEmails() {
        throw new UnsupportedOperationException("Clase aun no implementada.");
    }
    /**
     * Eliminar una direccion de correo electronico de la lista de correos electronicos
     *
     * @param email  Indica la direccion de correo electronico que se desea eliminar
     *
     * @return {@code true} si el email se ha eliminado correctamente, {@code false} en caso contrario
     */
    public boolean eliminarEmail(String email) {
        throw new UnsupportedOperationException("Clase aun no implementada.");
    }
}
