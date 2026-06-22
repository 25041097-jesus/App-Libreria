package Libreria;

public class Editorial {
    private String nombre;
    private String dir;
    private String contacto;
    private String tel;
    private String personacontacto;

   
    public Editorial() {}

    public Editorial(String nombre, String dir, String contacto, String tel, String personacontacto) {
        this.nombre = nombre;
        this.dir = dir;
        this.contacto = contacto;
        this.tel = tel;
        this.personacontacto = personacontacto;
    }

    public String getLineaArchivo() {
        return this.nombre + ";" + this.dir + ";" + this.contacto + ";" + this.tel + ";" + this.personacontacto;
    }
    public String getNombre() { return this.nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDir() { return this.dir; }
    public void setDir(String dir) { this.dir = dir; }

    public String getContacto() { return this.contacto; }
    public void setContacto(String contacto) { this.contacto = contacto; }

    public String getTel() { return this.tel; }
    public void setTel(String tel) { this.tel = tel; }

    public String getPersonacontacto() { return this.personacontacto; }
    public void setPersonacontacto(String personacontacto) { this.personacontacto = personacontacto; }
}
