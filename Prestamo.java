package co.edu.uniquindio.poo;
import java.util.LinkedList;

public class Prestamo {
    public String codigo;
    public DetallePrestamo detallePrestamo;
    public LinkedList <Libro> librosprestados;

    public Prestamo(DetallePrestamo detallePrestamo, String codigo) {
        this.detallePrestamo= detallePrestamo;
        this.codigo = codigo;
        this.librosprestados = new LinkedList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public DetallePrestamo getDetallePrestamo() {
        return detallePrestamo;
    }

    public void setDetallePrestamo(DetallePrestamo detallePrestamo) {
        this.detallePrestamo = detallePrestamo;
    }

    public LinkedList<Libro> getLibrosprestados() {
        return librosprestados;
    }

    public void setLibrosprestados(LinkedList<Libro> librosprestados) {
        this.librosprestados = librosprestados;
    }

    @Override
    public String toString() {
        return "\nPrestamo [codigo=" + codigo + detallePrestamo + ", librosprestados="
                + librosprestados + "]";
    }
    
//-----------------------------------------------Agregar/EliminarLibro-----------------------------------------------//

    public String agregarLibroaPrestamo(Libro libro){
        String mensaje = "";
        librosprestados.add(libro);
        libro.setUnidadStock(libro.getUnidadStock()-1);
        libro.setEstado(Estado.PRESTADO);
        mensaje = "libro agregado";
        return mensaje;
    }
    public void eliminarLibroaPrestamo(Libro libro) {
        librosprestados.remove(libro);
        libro.setUnidadStock(libro.getUnidadStock()+1);
        libro.setEstado(Estado.DISPONIBLE);
    }
}
