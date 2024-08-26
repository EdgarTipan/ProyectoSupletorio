package ec.edu.uce.ProyectoAPI;

import ec.edu.uce.ProyectoAPI.model.Estado;
import ec.edu.uce.ProyectoAPI.model.Tarea;
import ec.edu.uce.ProyectoAPI.repository.TareaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DatosIniciales implements CommandLineRunner {

    private final TareaRepository tareaRepository;

    public DatosIniciales(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Tarea tarea1 = new Tarea("Tarea 1", "Proyecto Recuperacion PA II", Estado.PENDIENTE, LocalDate.now());
        Tarea tarea2 = new Tarea("Tarea 2", "Proyecto Recuperacion PA II", Estado.COMPLETADA, LocalDate.now());

        tareaRepository.save(tarea1);
        tareaRepository.save(tarea2);
    }
}
