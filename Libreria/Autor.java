package Libreria;

public class Autor {
    private String nombre;
    private String web;
    private String email;
    public Autor() {}
    public Autor(String nombre, String web, String email) {
        this.nombre = nombre;
        this.web = web;
        this.email = email;
    }
    public String getLineaArchivo() {
        return this.nombre + ";" + this.web + ";" + this.email;
    }
    public String getNombre() { return this.nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getWeb() { return this.web; }
    public void setWeb(String web) { this.web = web; }

    public String getEmail() { return this.email; }
    public void setEmail(String email) { this.email = email; }
}
