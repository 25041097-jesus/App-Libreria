package Libreria;

public class Editorial {
String nombre,dir,contacto,tel,personacontacto;

public void infoEditorial(){
    System.out.println("Informacion de la editorial"+ this.nombre);

    }
    protected void agregarEditorial(){
        System.out.println("Agregando una nueva editorial....");
    }
    protected void editarEditorial(){
        System.out.println("Editando la informacion de la editorial...."+ this.nombre);
    }
protected void eliminarEditorial(){
        System.out.println("Eliminando editorial...."+ this.nombre);
    }
//setters
protected void setNombre(String nombre) {
    this.nombre = nombre;
}
protected void setDir(String dir) {
    this.dir = dir;
}
protected void setContacto(String contacto) {
    this.contacto = contacto;
}
protected void setTel(String tel) {
    this.tel = tel;
}
protected void setPersonacontacto(String personacontacto) {
    this.personacontacto = personacontacto;
}
//getters
protected String getNombre() {
    return this.nombre;
}
protected String getDir() {
    return this.dir;
}
protected String getContacto() {
    return this.contacto;
}
protected String getTel() {
    return this.tel;
}
protected String getPersonacontacto() {
    return this.personacontacto;
}
}