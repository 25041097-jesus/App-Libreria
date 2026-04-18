package Libreria;

public class Libro {
float precio;
String titulo,autor,editorial,fecha;

protected Libro(){
    System.out.println("Libro Vacio creado...");
}

protected Libro (String tit, String aut, String edit, float price, String fpub){
    this.titulo=tit;
    this.autor=aut;
    this.editorial=edit;
    this.precio=price;
    this.fecha=fpub;
    }

    public Libro(String tit) {
        this.titulo = tit;
    }

     public Libro(float price) {
        this.precio = price;
    }

public void infoLibro(){
        System.out.println(" 1. informacion de un libro...."+this.titulo);
        System.out.println("Autor: "+this.autor);
        System.out.println("Editorial: "+this.editorial);
        System.out.println("Precio: $ "+this.precio);
        System.out.println("Fecha de publicacion: "+this.fecha);
    }


public void adquirirLibro(){

    }
     protected void editarLibro(){
        System.out.println("Editando la informacion de un libro"+ this.titulo);
    }
    protected void editarPrecio(){
        System.out.println("Modificando el precio del libro"+ this.titulo);
    }
    protected void eliminarLibro(){
        System.out.println("Elimiminando el libro"+ this.titulo);
        }
       //setters
       protected void setTitulo(String titulo) {
            this.titulo = titulo;
        }
        protected void setAutor(String autor) {
            this.autor = autor;
        }
        protected void setEditorial(String editorial) {
            this.editorial = editorial;
        }
        protected void setPrecio(float precio) {
            this.precio = precio;
        }
        protected void setFecha(String fecha) {
            this.fecha = fecha;
        }
        //getters

        public String getTitulo() {
            return this.titulo;
        }
        public String getAutor() {
            return this.autor;
        }
        public String getEditorial() {
            return this.editorial;
        }
        public float getPrecio() {
            return this.precio;
        }
        public String getFecha() {
            return this.fecha;
        }
        public String datosLibro(){
            return "Titulo: "+this.titulo+"\nAutor: "+this.autor+"\nEditorial: "+this.editorial+"\nPrecio: $"+this.precio+"\nFecha de publicacion: "+this.fecha;
        }
}