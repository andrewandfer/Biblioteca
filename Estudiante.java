package co.edu.uniquindio.poo;
import java.util.Collection;
import java.util.LinkedList;

public class Estudiante extends Persona {

    private int edad;
    private Collection<Prestamo> prestamos;

    public Estudiante(String nombre, String cedula, String correo, int telefono, int edad) {
        super(nombre, cedula, correo, telefono);
        this.edad = edad;
        prestamos = new LinkedList<>();
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public Collection<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setEdad(Collection<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }


    @Override
    public String toString() {
        return "\n\nEstudiante ["+ super.toString() + ", edad=" + edad + ", \n\nprestamos=" + prestamos +"]";
    }

    //--------------------------------------------------Prestamos-------------------------------------------------------//
    public void agregarPrestamoEstudiante(Prestamo prestamo) {
        prestamos.add(prestamo);
    }
    public void eliminarPrestamoEstudiante(Prestamo prestamo) {
        prestamos.remove(prestamo);
    }
}
