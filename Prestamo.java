package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;
import java.time.temporal.ChronoUnit;

public class Prestamo {

    private LocalDate fechaPrestamo, fechaEntrega;
    private double costoDia;
    private String codigo;
    private Biblioteca biblioteca;
    private Estudiante estudiante;
    private Bibliotecario bibliotecario;
    private Collection<DetallePrestamo> detallePrestamos;

    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaEntrega, double costoDia, String codigo,
            Biblioteca biblioteca, Estudiante estudiante, Bibliotecario bibliotecario) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.costoDia = costoDia;
        this.codigo = codigo;
        this.biblioteca = biblioteca;
        this.estudiante = estudiante;
        this.bibliotecario = bibliotecario;
        detallePrestamos = new LinkedList<>();
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public double getCostoDia() {
        return costoDia;
    }

    public void setCostoDia(double costoDia) {
        this.costoDia = costoDia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public Collection<DetallePrestamo> getDetallePrestamos() {
        return detallePrestamos;
    }

    public void setDetallePrestamos(Collection<DetallePrestamo> detallePrestamos) {
        this.detallePrestamos = detallePrestamos;
    }

    @Override
    public String toString() {
        return "Prestamo [fechaPrestamo=" + fechaPrestamo + ", fechaEntrega=" + fechaEntrega + ", costoDia=" + costoDia
                + ", codigo=" + codigo + ", biblioteca=" + biblioteca.getNombre() + ", estudiante=" + estudiante.getNombre()
                + ", bibliotecario=" + bibliotecario.getNombre() + ", detallePrestamos=" + detallePrestamos + "]";
    }

//------------------------------------------------DetallesPrestamo--------------------------------------------------//

    public void agregarDetallePrestamo(DetallePrestamo detallePrestamo){
        detallePrestamos.add(detallePrestamo);
        detallePrestamo.getLibro().setUnidadesDisponibles(detallePrestamo.getLibro().getUnidadesDisponibles() - detallePrestamo.getCantidad());
        detallePrestamo.getLibro().setEstado(false);    
    }
    public void eliminarDetallePrestamo(DetallePrestamo detallePrestamo){
        detallePrestamos.remove(detallePrestamo);
        detallePrestamo.getLibro().setUnidadesDisponibles(detallePrestamo.getLibro().getUnidadesDisponibles() + detallePrestamo.getCantidad());
        detallePrestamo.getLibro().setEstado(true);
    }
    public void actualizarSubtotal(DetallePrestamo detallePrestamo){
        long diasDiferencia = ChronoUnit.DAYS.between(fechaPrestamo, fechaEntrega);
        detallePrestamo.setSubTotal(diasDiferencia * costoDia);
    }

}
