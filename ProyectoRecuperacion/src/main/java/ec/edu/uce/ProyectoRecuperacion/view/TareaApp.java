package ec.edu.uce.ProyectoRecuperacion.view;

import ec.edu.uce.ProyectoRecuperacion.model.Tarea;
import ec.edu.uce.ProyectoRecuperacion.model.TareaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaApp {

    private final TareaService tareaService;

    @Autowired
    public TareaApp(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @Transactional
    public void run(){
        Tarea t1 = new Tarea("Tarea Recuperacion 1", "Proyecto de supletorio",
                "PENDIENTE","26/08/2024");
        Tarea t2 = new Tarea("Tarea Recuperacion 2", "Proyecto de supletorio",
                "FINALIZADA","26/08/2024");
        Tarea t3 = new Tarea("Tarea Recuperacion 3", "Proyecto de supletorio",
                "FINALIZADA","26/08/2024");
        Tarea t4 = new Tarea("Tarea Recuperacion 4", "Proyecto de supletorio",
                "PENDIENTE","26/08/2024");
        Tarea t5 = new Tarea("Tarea Recuperacion 5", "Proyecto de supletorio",
                "PENDIENTE","26/08/2024");

        // Guardado de tareas en la base de datos
        tareaService.crear(t1);
        tareaService.crear(t2);
        tareaService.crear(t3);
        tareaService.crear(t4);
        tareaService.crear(t5);

        // Listar todas las tareas
        System.out.println(tareaService.listarTodos());

        // Listar las tareas pendientes
        System.out.println(tareaService.listarPorEstado("PENDIENTE"));

        // Actualizamos el estado de la tarea 5 para pasar de pendiente a finalizada
        tareaService.actualizarEstado(t5.getId(), "FINALIZADA");

        // Borramos la tarea 5
        tareaService.eliminar(t5.getId());

        // Volvemos a listar las tareas
        System.out.println(tareaService.listarTodos());
    }
}
