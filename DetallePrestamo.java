package co.edu.uniquindio.poo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DetallePrestamo {
    public Estudiante estudiante;
    public LocalDate fechaprestamo;
    public LocalTime horaprestamo;
    public LocalDate fechaentrega;
    public double monto;

    public DetallePrestamo(Estudiante estudiante, LocalDate fechaprestamo,
            LocalTime horaprestamo,LocalDate fechaentrega, double monto) {
        this.estudiante = estudiante;
        this.fechaprestamo = fechaprestamo;
        this.horaprestamo = horaprestamo;
        this.fechaentrega = fechaentrega;

        this.monto = monto;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public LocalDate getFechaprestamo() {
        return fechaprestamo;
    }

    public void setFechaprestamo(LocalDate fechaprestamo) {
        this.fechaprestamo = fechaprestamo;
    }

    public LocalTime getHoraprestamo() {
        return horaprestamo;
    }

    public void setHoraprestamo(LocalTime horaprestamo) {
        this.horaprestamo = horaprestamo;
    }

    public LocalDate getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(LocalDate fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "\nDetallePrestamo[\nestudiante=" + estudiante + "\nfechaprestamo=" + fechaprestamo + "\nhoraprestamo="
                + horaprestamo + "\nfechaentrega=" + fechaentrega + "\nmonto=" + monto + "]";
    }
    
    public double calcularMontototal(){
        long diferenciaDias = ChronoUnit.DAYS.between(fechaprestamo, fechaentrega);
        double valortotal = diferenciaDias * monto;
        return valortotal;
    }
}