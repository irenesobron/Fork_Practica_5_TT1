package Mocks_para_test;

import com.tt1.test.Irepositorio;
import com.tt1.test.ToDo;

import java.util.List;
import java.util.ArrayList;

public class MockRepositorio implements Irepositorio {

    private final List<ToDo> tareas = new ArrayList<>();
    private final List<String> emails = new ArrayList<>();
    private boolean marcarComoCompletadaDevuelve = true;

    @Override
    public ToDo encontrarTarea(String nombre) {
        for(ToDo t: tareas){
            if(t.getNombre() == nombre){
                return t;
            }
        }
        return null;
    }

     @Override
     public boolean marcarComoCompletada(String nombre) {
         Optional<ToDo> tarea = encontrarTarea(nombre);
         if (tarea.isPresent() && marcarComoCompletadaDevuelve) {
             tarea.get().setCompletado(true);
             return true;
         }
         return false;
     }
        @Override
        public void guardarTarea(ToDo tarea) {
            tareas.add(tarea);
        }

        @Override
        public void guardarEmail(String email) {
            emails.add(email);
        }

        // Métodos auxiliares para el Servicio (que hace cast a Repositorio)
        // En un diseño más limpio, estos estarían en la interfaz
        public List<ToDo> obtenerTareasPendientes() {
            List<ToDo> pendientes = new ArrayList<>();
            for (ToDo t : tareas) {
                if (!t.isCompletado()) pendientes.add(t);
            }
            return pendientes;
        }

        public List<String> obtenerEmails() {
            return new ArrayList<>(emails);
        }

        public void agregarTareaDirecta(ToDo tarea) {
            tareas.add(tarea);
        }

        public void agregarEmailDirecto(String email) {
            emails.add(email);
        }

        public int cantidadTareas() {
            return tareas.size();
        }

        public int cantidadEmails() {
            return emails.size();
        }

        public void setMarcarComoCompletadaDevuelve(boolean valor) {
            this.marcarComoCompletadaDevuelve = valor;
        }
}
