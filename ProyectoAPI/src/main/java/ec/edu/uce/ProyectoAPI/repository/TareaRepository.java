package ec.edu.uce.ProyectoAPI.repository;

import ec.edu.uce.ProyectoAPI.model.Estado;
import ec.edu.uce.ProyectoAPI.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findByEstado(Estado estado);
}
