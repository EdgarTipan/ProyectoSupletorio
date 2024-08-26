package ec.edu.uce.ProyectoAPI.controller;

import ec.edu.uce.ProyectoAPI.model.Estado;
import ec.edu.uce.ProyectoAPI.model.Tarea;
import ec.edu.uce.ProyectoAPI.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private final TareaService tareaService;

    @Autowired
    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping
    public List<Tarea> listarTodasLasTareas() {
        return tareaService.listarTodo();
    }

    @GetMapping("/estado/{estado}")
    public List<Tarea> listarTareasPorEstado(@PathVariable Estado estado) {
        return tareaService.listarTareasPorEstado(estado);
    }

    @PostMapping
    public Tarea crearTarea(@RequestBody Tarea tarea) {
        return tareaService.crear(tarea);
    }

    @PutMapping("/{id}")
    public Tarea actualizarTarea(@PathVariable Long id, @RequestBody Tarea tareaActualizada) {
        return tareaService.actualizar(id, tareaActualizada);
    }

    @DeleteMapping("/{id}")
    public void eliminarTarea(@PathVariable Long id) {
        tareaService.eliminar(id);
    }
}
