package ec.edu.uce.ProyectoRecuperacion.controller;

import ec.edu.uce.ProyectoRecuperacion.model.Tarea;
import ec.edu.uce.ProyectoRecuperacion.model.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServiceImpl implements TareaService {

    private final TareaRepository tareaRepository;

    @Autowired
    public TareaServiceImpl(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    @Override
    public List<Tarea> listarTodos() {
        System.out.println("\n>> Mostrando todas las tareas: ");
        return tareaRepository.findAll();
    }

    @Override
    public void crear(Tarea tarea) {
        tareaRepository.save(tarea);
        System.out.println("\n>> Tarea creada y agregada: " + tarea.getTitulo());
    }

    @Override
    public void actualizarEstado(Long id, String estado) {
        Tarea tareaActualizada = tareaRepository.getReferenceById(id);
        tareaActualizada.setEstado(estado);
        tareaRepository.save(tareaActualizada);
        System.out.println("\n>> Tarea actualizada: " + tareaActualizada.toString());
    }

    @Override
    public void eliminar(Long id) {
        tareaRepository.deleteById(id);
        System.out.println("\n>> Tarea con la id: " + id + " eliminada");
    }

    @Override
    public List<Tarea> listarPorEstado(String estado) {

        System.out.println("\n>> Filtrando tareas con el estado: " + estado);

        List<Tarea> tareasfiltradas;
        tareasfiltradas = tareaRepository.findAll()
                .stream().filter(tarea -> tarea.getEstado().equals(estado))
                .toList();

        return tareasfiltradas;
    }
}
