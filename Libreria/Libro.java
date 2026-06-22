package Libreria;

public class Libro {
    private String titulo;
    private String autor;
    private String editorial;
    private float precio;
    private String fecha;

    public Libro() {}
    public Libro(String titulo, String autor, String editorial, float precio, String fecha) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.precio = precio;
        this.fecha = fecha;
    }
    public String getLineaArchivo() {
        return this.titulo + ";" + this.autor + ";" + this.editorial + ";" + this.precio + ";" + this.fecha;
    }

    public String datosLibro() {
        return "Título: " + this.titulo + " | Autor: " + this.autor + " | Editorial: " + this.editorial + " | Precio: $" + this.precio + " | Fecha: " + this.fecha;
    }

    public String getTitulo() { return this.titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return this.autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getEditorial() { return this.editorial; }
    public void setEditorial(String editorial) { this.editorial = editorial; }

    public float getPrecio() { return this.precio; }
    public void setPrecio(float precio) { this.precio = precio; }

    public String getFecha() { return this.fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
}
