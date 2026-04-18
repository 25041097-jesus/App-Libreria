package Libreria;

public class Autor {
    String nombre,web,email;
    protected void infoAutores(){
        System.out.println("informacion del autor"+ this.nombre);
    }
protected void agregarAutor(){
        System.out.println("Agregando un autor...");
    }
    protected void editarAutor(){
        System.out.println("editando la informacion del autor..."+ this.nombre);
        }

    protected void eliminarAutor(){
        System.out.println("Eliminando un autor..."+ this.nombre);
    }
    //setters
    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }
    protected void setWeb(String web) {
        this.web = web;
    }
    protected void setEmail(String email) {
        this.email = email;
    }

    //getters
    protected String getNombre() {
        return this.nombre;
    }
    protected String getWeb() {
        return this.web;
    }  
    protected String getEmail() {
        return this.email;
    }  
}
