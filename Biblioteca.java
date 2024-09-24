package co.edu.uniquindio.poo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

public class Biblioteca {
    public String nombre;
    public double ganancia;
    public LinkedList <Libro> libros;
    public LinkedList <Estudiante> estudiantes;
    public LinkedList <Bibliotecario> bibliotecarios;
    public LinkedList <Prestamo> prestamos;

    public Biblioteca(String nombre, int ganancia) {
        this.nombre = nombre;
        libros = new LinkedList<>(); 
        estudiantes = new LinkedList<>(); 
        bibliotecarios = new LinkedList<>(); 
        prestamos = new LinkedList<>();
        this.ganancia = ganancia;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public double getGanancia() {
        return ganancia;
    }
    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    public LinkedList<Libro> getLibros() {
        return libros;
    }
    public void setLibros(LinkedList<Libro> libros) {
        this.libros = libros;
    }
    public LinkedList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    public void setEstudiantes(LinkedList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    public LinkedList<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }

    public void setBibliotecarios(LinkedList<Bibliotecario> bibliotecarios) {
        this.bibliotecarios = bibliotecarios;
    }

    public LinkedList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(LinkedList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

//-----------------------------------------------------Libro-------------------------------------------------------//

    public boolean verificarLibro(String codigo) {
        boolean centinela = false;
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                centinela = true;
            }
        }
        return centinela;
    }
    public String agregarLibro(Libro libro){
        String mensaje = "No se pudo agregar el libro";
        if (!verificarLibro(libro.getCodigo())) {
            libros.add(libro);
            mensaje = "libro agregado";
        }
        return mensaje;
    }
    public void eliminarLibro(String codigo) {
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                libros.remove(libro);
                break;
            }
        }
    }
    /**
     * metodo para buscar un libro según su codigo y mostrar todos los datos del mismo
     * @param codigo
     */
    public void mostrarInfolibro(String codigo){
        String mensaje = "";
        for (Libro libro : libros) {
            if (codigo.equals(libro.getCodigo())) {
                mensaje = libro.toString();
                break;
            }
            else{
                mensaje = "No se encontró un libro con dicho codigo";
                break;
            }
        }
        System.out.println(mensaje);
    }

    /**
     * Metodo alternativo para agregar un libro, sobreescribiendolo en la posicion de otro
     * @param libronuevo un libro que no esté en la base de datos de la biblioteca
     * @param libroacambiar un libro existente a eliminar
     */
    public void reemplazarLibro(Libro libronuevo, Libro libroacambiar){
        libros.set(libros.indexOf(libroacambiar), libronuevo);
    }

    //--------------------------------------------------Prestamo----------------------------------------------------//

    public boolean verificarPrestamo(Prestamo prestamonuevo) {
        boolean centinela = false;
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(prestamonuevo.getCodigo())) {
                centinela = true;
            }
        }
        return centinela;
    }
    public String agregarPrestamo(Prestamo prestamo, Bibliotecario bibliotecario){
        String mensaje = "No se pudo agregar el libro";
        if (!verificarPrestamo(prestamo)) {
            prestamos.add(prestamo);
            bibliotecario.agregarPrestamo(prestamo);
            mensaje = "libro agregado a la biblioteca y al bibliotecario";
        }
        return mensaje;
    }
    public void eliminarPrestamo(Prestamo prestamonuevo, Bibliotecario bibliotecario){
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(prestamonuevo.getCodigo())) {
                prestamos.remove(prestamo);
                bibliotecario.eliminarPrestamo(prestamo);
                break;
            }
        }
    }

    public void entregarPrestamo(Prestamo prestamobuscado, Bibliotecario bibliotecariobuscado){
        double total = 0;
            for (Prestamo prestamo : bibliotecariobuscado.prestamos) {
                total += prestamo.detallePrestamo.calcularMontototal();
            }
        ganancia = ganancia + total;
        bibliotecariobuscado.eliminarPrestamo(prestamobuscado);
    }

    public void mostrarInfoPrestamo(String codigo){
        String mensaje = "";
        for (Prestamo prestamo : prestamos) {
            if (codigo.equals(prestamo.getCodigo())) {
                mensaje = prestamo.toString();
                break;
            }
            else{
                mensaje = "No se encontró un prestamo con dicho codigo";
                break;
            }
        }
        System.out.println(mensaje);
    }

    //--------------------------------------------------Estudiante----------------------------------------------------//

    public boolean verificarEstudiante(Estudiante estudiantenuevo) {
        boolean centinela = false;
        for (Estudiante estudiante : estudiantes) {
            if (estudiantenuevo.getCedula().equals(estudiante.getCedula())) {
                centinela = true;
            }
        }
        return centinela;
    }
    public String agregarEstudiante(Estudiante estudiante){
        String mensaje = "No se pudo agregar el Estudiante";
        if (!verificarEstudiante(estudiante)) {
            estudiantes.add(estudiante);
            mensaje = "Estudiante agregado";
        }
        return mensaje;
    }
    public void eliminarLibro(Estudiante estudiantenuevo) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiantenuevo.getCedula().equals(estudiante.getCedula())) {
                estudiantes.remove(estudiante);
                break;
            }
        }
    }
    //------------------------------------------------Bibliotecario--------------------------------------------------//
    
    public boolean verificarBibliotecario(Bibliotecario bibliotecarionuevo) {
        boolean centinela = false;
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getCedula().equals(bibliotecarionuevo.getCedula())) {
                centinela = true;
            }
        }
        return centinela;
    }
    public String agregarBibliotecario(Bibliotecario bibliotecarionuevo){
        String mensaje = "No se pudo agregar el Estudiante";
        if (!verificarBibliotecario(bibliotecarionuevo)) {
            bibliotecarios.add(bibliotecarionuevo);
            mensaje = "Estudiante agregado";
        }
        return mensaje;
    }
    public void eliminarBibliotecario(Bibliotecario bibliotecarionuevo) {
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getCedula().equals(bibliotecarionuevo.getCedula())) {
                bibliotecarios.remove(bibliotecarionuevo);
                break;
            }
        }
    }
    public void mostrarprestamosBibliotecarios(){
        String prestamos = "Los empleados y sos respectivos prestamos son:" + "\n";
        for(Bibliotecario bibliotecario : bibliotecarios){
            prestamos += bibliotecario.getNombre() + " = " + bibliotecario.prestamos.size() + "\n";
        }
        System.out.println(prestamos);;
    }

    //------------------------------------------------Metodos--------------------------------------------------//

    public int libroenPrestamos(String titulo){
        int numeroprestamos = 0;
        for(Bibliotecario bibliotecario : bibliotecarios){
            for(Prestamo prestamo : bibliotecario.getPrestamos()){
                for(Libro libro : prestamo.getLibrosprestados())
                    if(titulo.equals(libro.getTitulo())){
                        numeroprestamos += 1;
                }
            }
        }
        return numeroprestamos;
    }
    public void mostrarestudiantemasprestamos(){
        Estudiante estudianteConMasPrestamos = null;
        int maxPrestamos = 0;
    
        // Iterar sobre los estudiantes
        for (Estudiante estudiante : estudiantes) {
            int estudianteFrecuencia = 0;
    
            // Contar los préstamos del estudiante actual
            for (Prestamo prestamo : prestamos) {
                if (prestamo.getDetallePrestamo().getEstudiante().equals(estudiante)) {
                    estudianteFrecuencia++;
                }
            }
    
            // Verificar si este estudiante tiene más préstamos
            if (estudianteFrecuencia > maxPrestamos) {
                maxPrestamos = estudianteFrecuencia;
                estudianteConMasPrestamos = estudiante;
            }
        }
        System.out.println(estudianteConMasPrestamos);
    }
    @Override
    public String toString() {
        return "Biblioteca [nombre=" + nombre + "\n\n" + "libros=" + libros + "\n\n" + "estudiantes=" + estudiantes + "\n\n"
                + "bibliotecarios=" + bibliotecarios + "]";
    }

    public static void main(String[] args) {       
        Biblioteca Biblioteca1 = new Biblioteca("Hola", 0);

        for(int i = 0; i < 6; i++) {

            Estudiante estudiantei = new Estudiante("Estudiante"+i, "111111"+i, "000"+i,
            "Estudiante" + i + "@gmail.com");
            Biblioteca1.agregarEstudiante(estudiantei);

            Bibliotecario bibliotecarioi = new Bibliotecario("Bibliotecario"+i, "222222"+i, "0000"+i,
            "Bibliotecario" + i + "@gmail.com","500000");
            Biblioteca1.agregarBibliotecario(bibliotecarioi);

                LocalDate fechaprestamoi = LocalDate.of(2023, 9, 6);
                LocalTime horaprestamoi = LocalTime.of(10, 26, 0);
                LocalDate fechaentregai = LocalDate.of(2023, 10, 6);
            
                DetallePrestamo detallePrestamoi = new DetallePrestamo(estudiantei, fechaprestamoi, horaprestamoi,
                fechaentregai, i*10000);
        
                Prestamo prestamoi = new Prestamo(detallePrestamoi,"000"+i);
                Biblioteca1.agregarPrestamo(prestamoi, bibliotecarioi);
                Biblioteca1.entregarPrestamo(prestamoi, bibliotecarioi);

            for(int j = 0; j < 2; j++) {
                Libro libroj = new Libro("000000"+ j, "1234/"+j, "Carlos Barragan",
                "titulo"+j, "editorial"+j, j+"/09/2024", Estado.DISPONIBLE, 10);
                Biblioteca1.agregarLibro(libroj);
                prestamoi.agregarLibroaPrestamo(libroj);
            }

        }

        System.out.println(Biblioteca1);
        Biblioteca1.mostrarprestamosBibliotecarios();
        System.out.println(Biblioteca1.getGanancia());
    }
}
