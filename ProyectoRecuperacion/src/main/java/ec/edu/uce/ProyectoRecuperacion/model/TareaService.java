package ec.edu.uce.ProyectoRecuperacion.model;

import java.util.List;

public interface TareaService {

    List<Tarea> listarTodos();
    void crear(Tarea tarea);
    void actualizarEstado(Long id, String estado);
    void eliminar(Long id);
    List<Tarea> listarPorEstado(String estado);
}
