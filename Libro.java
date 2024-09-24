package co.edu.uniquindio.poo;

public class Libro {
    public String codigo;
    public String isbn;
    public String autor;
    public String titulo;
    public String editorial;
    public String fecha;
    public Estado estado;
    public int unidadStock;
    
    public Libro(String codigo, String isbn, String autor, String titulo, String editorial, String fecha, Estado estado,
            int unidadStock) {
        this.codigo = codigo;
        this.isbn = isbn;
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
        this.fecha = fecha;
        this.estado =estado;
        this.unidadStock = unidadStock;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getUnidadStock() {
        return unidadStock;
    }

    public void setUnidadStock(int unidadStock) {
        this.unidadStock = unidadStock;
    }

    @Override
    public String toString() {
        return "\nLibro [codigo=" + codigo + ", isbn=" + isbn + ", autor=" + autor + ", titulo=" + titulo + ", editorial="
                + editorial + ", fecha=" + fecha + ", estado=" + estado + ", unidadStock=" + unidadStock + "]";
    }
    
    
}
