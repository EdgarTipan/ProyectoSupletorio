package ec.edu.uce.ProyectoRecuperacion.model;

import jakarta.persistence.*;

@Entity(name = "Tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;
    @Column
    private String descripcion;
    @Column
    private String estado;
    @Column
    private String fechaCreacion;

    public Tarea(String titulo, String descripcion, String estado, String fechaCreacion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    public Tarea() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "Tarea {" +
                "Id: " + id +
                ", Titulo: '" + titulo + '\'' +
                ", Descripcion: '" + descripcion + '\'' +
                ", Estado: '" + estado + '\'' +
                ", Fecha de creacion: '" + fechaCreacion + '\'' +
                '}' + "\n";
    }
}
