package ec.edu.uce.ProyectoRecuperacion.controller;

import ec.edu.uce.ProyectoRecuperacion.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea,Long> {
}
