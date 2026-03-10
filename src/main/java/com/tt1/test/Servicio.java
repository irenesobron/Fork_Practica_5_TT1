package com.tt1.test;

import java.time.LocalDate;
import java.util.List;

/**
 * Capa de lógica de negocio del sistema de gestión de tareas.
 * <p>
 * Coordina las operaciones sobre las tareas delegando la persistencia
 * en un {@link Irepositorio} y el envío de notificaciones en un {@link Imailer}.
 * </p>
 *
 * @author Irene Sobrón
 * @see Irepositorio
 * @see Imailer
 */
public class Servicio {
    /** Repositorio que actúa como capa de persistencia*/
    private final Irepositorio repositorio;
    /** Servicio de correo utilizado para enviar notificaciones. */
    private final Imailer mailer;

    /**
     * Construye el servicio con las dependencias necesarias.
     *
     * @param repositorio implementación del repositorio de tareas
     * @param mailer      implementación del servicio de correo
     */
    public Servicio(Irepositorio repositorio, Imailer mailer) {
        this.repositorio = repositorio;
        this.mailer = mailer;
    }
    /**
     * Crea una nueva tarea y la guarda en el repositorio.
     *
     * @param nombre      nombre identificativo de la tarea
     * @param desc        descripcion detallada del trabajo a realizar
     * @param fechaLimite fecha limite antes de la cual debe completarse la tarea
     * @return {@code true} si la tarea se creo correctamente, {@code false} en caso contrario
     */
    public boolean crearTarea(String nombre, String desc, LocalDate fechaLimite) {
        throw new UnsupportedOperationException("Clase aún no implementada.");

    }
    /**
     * Registra una dirección de correo electrónico.
     *
     * @param email dirección de correo a añadir
     * @return {@code true} si el correo se registró correctamente, {@code false} en caso contrario
     */
    public boolean agregarEmail(String email) {
        throw new UnsupportedOperationException("Clase aún no implementada.");

    }

    /**
     * Marca como completada la tarea identificada por el nombre dado.
     *
     * @param nombre nombre de la tarea que se desea marcar como completada
     * @return {@code true} si la tarea se marcó correctamente, {@code false} en caso contrario
     */
    public boolean marcarComoCompletada(String nombre) {
        throw new UnsupportedOperationException("Clase aún no implementada.");

    }

    /**
     * Devuelve la lista de tareas que aún no han sido completadas.
     *
     * @return lista de tareas pendientes.
     */
    public List<ToDo> listarTareasPendientes() {
        throw new UnsupportedOperationException("Clase aún no implementada.");

    }

}
