package co.edu.uniquindio.poo;
import java.util.LinkedList;

public class Bibliotecario extends Persona {
    public String salario;
    public LinkedList <Prestamo> prestamos;
    
    public Bibliotecario(String nombre, String cedula, String telefono, String correo, String salario) {
        super(nombre, cedula, telefono, correo);
        this.salario = salario;
        prestamos = new LinkedList<>();
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public LinkedList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(LinkedList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

//---------------------------------------------------Metodos----------------------------------------------------//
    public void agregarPrestamo(Prestamo prestamo){
        prestamos.add(prestamo);
    }
        
    public void eliminarPrestamo(Prestamo prestamo) {
        prestamos.remove(prestamo);
    }

    @Override
    public String toString() {
        return "\nBibliotecario [nombre=" + nombre + ", cedula=" + cedula + ", telefono=" + telefono + ", correo="
                + correo + ", salario=" + salario + ", prestamos=" + prestamos + "]\n";
    }
}
