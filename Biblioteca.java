package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;

public class Biblioteca {

    private String nombre;
    private Collection<Estudiante> estudiantes;
    private Collection<Bibliotecario> bibliotecarios;
    private Collection<Prestamo> prestamos;
    private Collection<Libro> libros;
    private double ganancia;
    private int cantidadLibros;

    public Biblioteca(String nombre, double ganancia, int cantidadLibros) {
        this.nombre = nombre;
        this.ganancia = ganancia;
        this.cantidadLibros = cantidadLibros;
        estudiantes = new LinkedList<>();
        bibliotecarios = new LinkedList<>();
        prestamos = new LinkedList<>();
        libros = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Collection<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Collection<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }

    public void setBibliotecarios(Collection<Bibliotecario> bibliotecarios) {
        this.bibliotecarios = bibliotecarios;
    }

    public Collection<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Collection<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public Collection<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Collection<Libro> libros) {
        this.libros = libros;
    }

    public double getGanancia() {
        return ganancia;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    public int getCantidadLibros() {
        return cantidadLibros;
    }

    public void setCantidadLibros(int cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }

    @Override
    public String toString() {
        return "Biblioteca [nombre=" + nombre + ", estudiantes=" + estudiantes + ", bibliotecarios=" + bibliotecarios
                + ", prestamos=" + prestamos + ", libros=" + libros + ", ganancia=" + ganancia + ", cantidadLibros="
                + cantidadLibros + "]";
    }
//---------------------------------------------------Libros--------------------------------------------------------//
//----------------------------------Gestion global-----------------------------------//

    public boolean verificarLibro(String codigo) {
        boolean centinela = false;
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                centinela = true;
            }
        }
        return centinela;
    }
    public void agregarLibro(Libro libro) {
        if (verificarLibro(libro.getCodigo()) == false) {
            libros.add(libro);
        }
    }
    public void eliminarLibro(Libro libro) {
        if (verificarLibro(libro.getCodigo()) == true) {
            libros.remove(libro);
        }
    }
//----------------------------------Gestion parcial-----------------------------------//

    public void mostrardatoslibro(String codigoelegido){

    }
//--------------------------------------------------Estudiante-----------------------------------------------------//

    public boolean verificarEstudiante(String cedula) {
        boolean centinela = false;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }
    public void agregarEstudiante(Estudiante estudiante) {
        if (verificarLibro(estudiante.getCedula()) == false) {
            estudiantes.add(estudiante);
        }
    }
    public void eliminarEstudiante(Estudiante estudiante) {
        if (verificarLibro(estudiante.getCedula()) == true) {
            estudiantes.remove(estudiante);
        }
    }
//------------------------------------------------Bibliotecario---------------------------------------------------//

    public boolean verificarBibliotecario(String cedula) {
        boolean centinela = false;
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }
    public void agregarBibliotecario(Bibliotecario bibliotecario) {
        if (verificarLibro(bibliotecario.getCedula()) == false) {
            bibliotecarios.add(bibliotecario);
        }
    }
    public void eliminarEstudiante(Bibliotecario bibliotecario) {
        if (verificarLibro(bibliotecario.getCedula()) == true) {
            bibliotecarios.remove(bibliotecario);
        }
    }
//---------------------------------------------------Prestamo-----------------------------------------------------//

    public boolean verificarPrestamo(String codigo) {
        boolean centinela = false;
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                centinela = true;
            }
        }
        return centinela;
    }
    public void agregarPrestamo(Prestamo prestamo, Estudiante estudiante, Bibliotecario bibliotecario) {
        if (verificarPrestamo(prestamo.getCodigo()) == false) {
            prestamos.add(prestamo);
            estudiante.agregarPrestamo(prestamo);
            bibliotecario.agregarPrestamo(prestamo);
        }
    }
    public void eliminarPrestamo(Prestamo prestamo, Estudiante estudiante, Bibliotecario bibliotecario) {
        if (verificarPrestamo(prestamo.getCodigo()) == true) {
            prestamos.remove(prestamo);
            estudiante.eliminarPrestamo(prestamo);
            bibliotecario.eliminarPrestamo(prestamo);
        }
    }
}