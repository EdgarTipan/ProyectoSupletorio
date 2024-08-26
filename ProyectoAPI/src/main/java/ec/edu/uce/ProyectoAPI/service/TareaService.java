package ec.edu.uce.ProyectoAPI.service;

import ec.edu.uce.ProyectoAPI.model.Estado;
import ec.edu.uce.ProyectoAPI.model.Tarea;
import ec.edu.uce.ProyectoAPI.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    @Autowired
    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> listarTodo() {
        return tareaRepository.findAll();
    }

    public List<Tarea> listarTareasPorEstado(Estado estado) {
        return tareaRepository.findAll().stream()
                .filter(task -> task.getEstado().equals(estado))
                .collect(Collectors.toList());
    }

    public Tarea crear(Tarea task) {
        return tareaRepository.save(task);
    }

    public Tarea actualizar(Long id, Tarea tareaActualizada) {
        return tareaRepository.findById(id)
                .map(tarea -> {
                    tarea.setTitulo(tareaActualizada.getTitulo());
                    tarea.setDescripcion(tareaActualizada.getDescripcion());
                    tarea.setEstado(tareaActualizada.getEstado());
                    return tareaRepository.save(tareaActualizada);
                }).orElseThrow(() -> new RuntimeException("Tarea con la id " + id +  " no encontrada"));
    }

    public void eliminar(Long id) {
        tareaRepository.deleteById(id);
    }
}
