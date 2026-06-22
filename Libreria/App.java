package Libreria;

import java.util.Scanner;
import java.io.*;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        int opc = 0;

        System.out.println("Bienvenidos al sistema de administración de la Librería");
        
    
        while (opc != 4) {
            System.out.println("Escribe el número de la sección ver");
            System.out.println("1. Libros");
            System.out.println("2. Autores");
            System.out.println("3. Editoriales");
            System.out.println("4. Salir");
            opc = entrada.nextInt();
            entrada.nextLine();

            switch (opc) {
                case 1: menuLibros(entrada); break;
                case 2: menuAutores(entrada); break;
                case 3: menuEditoriales(entrada); break;
                case 4: System.out.println("...VUELVE PRONTO ECTOR..."); break;
                default: System.out.println("Opción invalida");
            }
        }
        entrada.close();
    }

    private static void menuLibros(Scanner entrada) {
        int opc2 = 0;
        while (opc2 != 5) {
            System.out.println("ADMINISTRADOR DE LIBROS");
            System.out.println("1. Agregar Libros");
            System.out.println("2. Editar Libros");
            System.out.println("3. Consultar Libros");
            System.out.println("4. Eliminar Libros");
            System.out.println("5. Regresar al menú anterior");
            opc2 = entrada.nextInt();
            entrada.nextLine();

            switch (opc2) {
                case 1: agregarLibro(entrada); break;
                case 2: editarLibro(entrada); break;
                case 3: mostrarLibros(); break;
                case 4: eliminarLibro(entrada); break;
                case 5: break;
                default: System.out.println("Opcion invalida");
            }
        }
    }

    private static void menuAutores(Scanner entrada) {
        int opc2 = 0;
        while (opc2 != 5) {
            System.out.println("ADMINISTRADOR DE AUTORES");
            System.out.println("1. Agregar Autor");
            System.out.println("2. Editar Autor");
            System.out.println("3. Consultar Autores");
            System.out.println("4. Eliminar Autor");
            System.out.println("5. Regresar al menú anterior");
            opc2 = entrada.nextInt();
            entrada.nextLine();

            switch (opc2) {
                case 1: agregarAutor(entrada); break;
                case 2: editarAutor(entrada); break;
                case 3: mostrarAutores(); break;
                case 4: eliminarAutor(entrada); break;
                case 5: break;
                default: System.out.println("Opcion invalida");
            }
        }
    }

    private static void menuEditoriales(Scanner entrada) {
        int opc2 = 0;
        while (opc2 != 5) {
            System.out.println("ADMINISTRADOR DE EDITORIALES");
            System.out.println("1. Agregar Editorial");
            System.out.println("2. Editar Editorial");
            System.out.println("3. Consultar Editoriales");
            System.out.println("4. Eliminar Editorial");
            System.out.println("5. Regresar al menú anterior");
            opc2 = entrada.nextInt();
            entrada.nextLine();

            switch (opc2) {
                case 1: agregarEditorial(entrada); break;
                case 2: editarEditorial(entrada); break;
                case 3: mostrarEditoriales(); break;
                case 4: eliminarEditorial(entrada); break;
                case 5: break;
                default: System.out.println("Opcion invalida");
            }
        }
    }

    private static void agregarLibro(Scanner entrada) {
        try {
            System.out.print("Ingresa el título del libro: ");
            String titulo = entrada.nextLine();
            System.out.print("Ingresa el autor del libro: ");
            String autor = entrada.nextLine();
            System.out.print("Ingresa la editorial del libro: ");
            String editorial = entrada.nextLine();
            System.out.print("Ingresa el precio del libro: ");
            float precio = entrada.nextFloat();
            entrada.nextLine(); 
            System.out.print("Ingresa la fecha de publicación (dd/mm/yyyy): ");
            String fecha = entrada.nextLine();

            Libro nuevoLibro = new Libro(titulo, autor, editorial, precio, fecha);

            PrintWriter pw = new PrintWriter(new FileWriter("libros.txt", true));
            pw.println(nuevoLibro.getLineaArchivo());
            pw.close();

            System.out.println("Libro agregado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al guardar el libro.");
        }
    }

    private static void mostrarLibros() {
        try {
            File archivo = new File("libros.txt");
            if (!archivo.exists()) {
                System.out.println("No hay libros guardados todavía.");
                return;
            }

            Scanner lector = new Scanner(archivo);
            if (!lector.hasNextLine()) {
                System.out.println("No hay libros guardados todavía.");
                lector.close();
                return;
            }
            int num = 1;
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] datos = linea.split(";");
                System.out.println(num + ". Título: " + datos[0] + " | Autor: " + datos[1] + " | Editorial: " + datos[2] + " | Precio: $" + datos[3] + " | Fecha: " + datos[4]);
                System.out.println("..........");
                num++;
            }
            lector.close();
        } catch (Exception e) {
            System.out.println("No se pudo leer el archivo de libros.");
        }
    }

    private static void editarLibro(Scanner entrada) {
        mostrarLibros();
        System.out.print("Escribe el número del libro que quieres editar: ");
        int numEditar = entrada.nextInt() - 1; 
        entrada.nextLine();

        try {
            String[] lineas = new String[100];
            int totalLineas = 0;

            File f = new File("libros.txt");
            if(!f.exists()) return;

            Scanner lector = new Scanner(f);
            while (lector.hasNextLine() && totalLineas < 100) {
                lineas[totalLineas] = lector.nextLine();
                totalLineas++;
            }
            lector.close();

            if (numEditar >= 0 && numEditar < totalLineas) {
                String[] datos = lineas[numEditar].split(";");
                Libro libro = new Libro(datos[0], datos[1], datos[2], Float.parseFloat(datos[3]), datos[4]);

                System.out.println("Editando: " + libro.getTitulo());
                System.out.println("1. Título 2. Autor 3. Editorial 4. Precio 5. Fecha");
                int datoMod = entrada.nextInt();
                entrada.nextLine();

                switch (datoMod) {
                    case 1: System.out.print("Nuevo título: "); libro.setTitulo(entrada.nextLine()); break;
                    case 2: System.out.print("Nuevo autor: "); libro.setAutor(entrada.nextLine()); break;
                    case 3: System.out.print("Nueva editorial: "); libro.setEditorial(entrada.nextLine()); break;
                    case 4: System.out.print("Nuevo precio: "); libro.setPrecio(entrada.nextFloat()); entrada.nextLine(); break;
                    case 5: System.out.print("Nueva fecha: "); libro.setFecha(entrada.nextLine()); break;
                }

                lineas[numEditar] = libro.getLineaArchivo();

                PrintWriter pw = new PrintWriter("libros.txt");
                for (int i = 0; i < totalLineas; i++) {
                    pw.println(lineas[i]);
                }
                pw.close();
                System.out.println("Libro edito exitosamente.");
            } else {
                System.out.println("Posición no válida.");
            }
        } catch (Exception e) {
            System.out.println("Error al editar.");
        }
    }

    private static void eliminarLibro(Scanner entrada) {
        mostrarLibros();
        System.out.print("Escribe el número del libro que quieres eliminar: ");
        int numEliminar = entrada.nextInt() - 1;
        entrada.nextLine();

        try {
            String[] lineas = new String[100];
            int totalLineas = 0;

            File f = new File("libros.txt");
            if(!f.exists()) return;

            Scanner lector = new Scanner(f);
            while (lector.hasNextLine() && totalLineas < 100) {
                lineas[totalLineas] = lector.nextLine();
                totalLineas++;
            }
            lector.close();

            if (numEliminar >= 0 && numEliminar < totalLineas) {
                PrintWriter pw = new PrintWriter("libros.txt");
                for (int i = 0; i < totalLineas; i++) {
                    if (i != numEliminar) {
                        pw.println(lineas[i]);
                    }
                }
                pw.close();
                System.out.println("Libro eliminado exitosamente.");
            } else {
                System.out.println("Posición no válida.");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar.");
        }
    }

    private static void agregarAutor(Scanner entrada) {
        try {
            System.out.print("Ingresa el nombre del autor: ");
            String nombre = entrada.nextLine();
            System.out.print("Ingresa la página web del autor: ");
            String web = entrada.nextLine();
            System.out.print("Ingresa el email del autor: ");
            String email = entrada.nextLine();

            Autor nuevoAutor = new Autor(nombre, web, email);

            PrintWriter pw = new PrintWriter(new FileWriter("autores.txt", true));
            pw.println(nuevoAutor.getLineaArchivo());
            pw.close();

            System.out.println("Autor agregado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al guardar el autor.");
        }
    }

    private static void mostrarAutores() {
        try {
            File archivo = new File("autores.txt");
            if (!archivo.exists()) {
                System.out.println("No hay autores guardados todavía.");
                return;
            }
                Scanner lector = new Scanner(archivo);
                if (!lector.hasNextLine()) {
                    System.out.println("No hay autores guardados todavía.");
                    lector.close();
                    return;
                }

                int num = 1;
            while (lector.hasNextLine()) {
                String[] datos = lector.nextLine().split(";");
                System.out.println(num + ". Nombre: " + datos[0] + " | Web: " + datos[1] + " | Email: " + datos[2]);
                System.out.println(".........");
                num++;
            }
            lector.close();
        } catch (Exception e) {
            System.out.println("Error al mostrar los autores.");
        }
    }

    private static void editarAutor(Scanner entrada) {
        mostrarAutores();
        System.out.print("Escribe el número del autor que quieres editar: ");
        int numEditar = entrada.nextInt() - 1;
        entrada.nextLine();

        try {
            String[] lineas = new String[100];
            int totalLineas = 0;

            File f = new File("autores.txt");
            if(!f.exists()) return;

            Scanner lector = new Scanner(f);
            while (lector.hasNextLine() && totalLineas < 100) {
                lineas[totalLineas] = lector.nextLine();
                totalLineas++;
            }
            lector.close();

            if (numEditar >= 0 && numEditar < totalLineas) {
                String[] datos = lineas[numEditar].split(";");
                Autor autor = new Autor(datos[0], datos[1], datos[2]);

                System.out.println("Editando: " + autor.getNombre());
                System.out.println("1. Nombre 2. Web 3. Email");
                int datoMod = entrada.nextInt();
                entrada.nextLine();

                switch (datoMod) {
                    case 1: System.out.print("Nuevo nombre: "); autor.setNombre(entrada.nextLine()); break;
                    case 2: System.out.print("Nueva web: "); autor.setWeb(entrada.nextLine()); break;
                    case 3: System.out.print("Nuevo email: "); autor.setEmail(entrada.nextLine()); break;
                }

                lineas[numEditar] = autor.getLineaArchivo();

                PrintWriter pw = new PrintWriter("autores.txt");
                for (int i = 0; i < totalLineas; i++) {
                    pw.println(lineas[i]);
                }
                pw.close();
                System.out.println("Autor editado exitosamente.");
            }
        } catch (Exception e) {
            System.out.println("Error al eitar.");
        }
    }

    private static void eliminarAutor(Scanner entrada) {
        mostrarAutores();
        System.out.print("Escribe el número del autor que quieres eliminar: ");
        int numEliminar = entrada.nextInt() - 1;
        entrada.nextLine();

        try {
            String[] lineas = new String[100];
            int totalLineas = 0;

            File f = new File("autores.txt");
            if(!f.exists()) return;

            Scanner lector = new Scanner(f);
            while (lector.hasNextLine() && totalLineas < 100) {
                lineas[totalLineas] = lector.nextLine();
                totalLineas++;
            }
            lector.close();

            if (numEliminar >= 0 && numEliminar < totalLineas) {
                PrintWriter pw = new PrintWriter("autores.txt");
                for (int i = 0; i < totalLineas; i++) {
                    if (i != numEliminar) {
                        pw.println(lineas[i]);
                    }
                }
                pw.close();
                System.out.println("Autor eliminado exitosamente.");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar.");
        }
    }

    private static void agregarEditorial(Scanner entrada) {
        try {
            System.out.print("Ingresa el nombre de la editorial: ");
            String nombre = entrada.nextLine();
            System.out.print("Ingresa la dirección: ");
            String dir = entrada.nextLine();
            System.out.print("Ingresa el contacto: ");
            String contacto = entrada.nextLine();
            System.out.print("Ingresa el teléfono: ");
            String tel = entrada.nextLine();
            System.out.print("Ingresa la persona de contacto: ");
            String personaContacto = entrada.nextLine();

            Editorial nuevaEditorial = new Editorial(nombre, dir, contacto, tel, personaContacto);

            PrintWriter pw = new PrintWriter(new FileWriter("editoriales.txt", true));
            pw.println(nuevaEditorial.getLineaArchivo());
            pw.close();

            System.out.println("Editorial agregada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al guardar la editorial.");
        }
    }

    private static void mostrarEditoriales() {
        try {
            File archivo = new File("editoriales.txt");
            if (!archivo.exists()) {
                System.out.println("No hay editoriales guardadas todavía.");
                return;
            }

            Scanner lector = new Scanner(archivo);
            if (!lector.hasNextLine()) {
                System.out.println("No hay editoriales guardadas todavía.");
                lector.close();
                return;
            }
            int num = 1;
            while (lector.hasNextLine()) {
                String[] datos = lector.nextLine().split(";");
                System.out.println(num + ". Editorial: " + datos[0] + " | Dirección: " + datos[1] + " | Tel: " + datos[3]);
                System.out.println("..........");
                num++;
            }
            lector.close();
        } catch (Exception e) {
            System.out.println("Error al mostrar las editoriales.");
        }
    }

    private static void editarEditorial(Scanner entrada) {
        mostrarEditoriales();
        System.out.print("Escribe el número de la editorial que quieres editar: ");
        int numEditar = entrada.nextInt() - 1;
        entrada.nextLine();

        try {
            String[] lineas = new String[100];
            int totalLineas = 0;

            File f = new File("editoriales.txt");
            if(!f.exists()) return;

            Scanner lector = new Scanner(f);
            while (lector.hasNextLine() && totalLineas < 100) {
                lineas[totalLineas] = lector.nextLine();
                totalLineas++;
            }
            lector.close();

            if (numEditar >= 0 && numEditar < totalLineas) {
                String[] datos = lineas[numEditar].split(";");
                Editorial ed = new Editorial(datos[0], datos[1], datos[2], datos[3], datos[4]);

                System.out.println("Editando: " + ed.getNombre());
                System.out.println("1. Nombre 2. Dirección 3. Contacto 4. Teléfono 5. Persona Contacto");
                int datoMod = entrada.nextInt();
                entrada.nextLine();

                switch (datoMod) {
                    case 1: System.out.print("Nuevo nombre: "); ed.setNombre(entrada.nextLine()); break;
                    case 2: System.out.print("Nueva dirección: "); ed.setDir(entrada.nextLine()); break;
                    case 3: System.out.print("Nuevo contacto: "); ed.setContacto(entrada.nextLine()); break;
                    case 4: System.out.print("Nuevo teléfono: "); ed.setTel(entrada.nextLine()); break;
                    case 5: System.out.print("Nueva persona contacto: "); ed.setPersonacontacto(entrada.nextLine()); break;
                }

                lineas[numEditar] = ed.getLineaArchivo();

                PrintWriter pw = new PrintWriter("editoriales.txt");
                for (int i = 0; i < totalLineas; i++) {
                    pw.println(lineas[i]);
                }
                pw.close();
                System.out.println("Editorial editada exitosamente.");
            }
        } catch (Exception e) {
            System.out.println("Error al editar.");
        }
    }

    private static void eliminarEditorial(Scanner entrada) {
        mostrarEditoriales();
        System.out.print("Escribe el número de la editorial que quieres eliminar: ");
        int numEliminar = entrada.nextInt() - 1;
        entrada.nextLine();

        try {
            String[] lineas = new String[100];
            int totalLineas = 0;

            File f = new File("editoriales.txt");
            if(!f.exists()) return;

            Scanner lector = new Scanner(f);
            while (lector.hasNextLine() && totalLineas < 100) {
                lineas[totalLineas] = lector.nextLine();
                totalLineas++;
            }
            lector.close();

            if (numEliminar >= 0 && numEliminar < totalLineas) {
                PrintWriter pw = new PrintWriter("editoriales.txt");
                for (int i = 0; i < totalLineas; i++) {
                    if (i != numEliminar) {
                        pw.println(lineas[i]);
                    }
                }
                pw.close();
                System.out.println("Editorial eliminada exitosamente.");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar.");
        }
    }
}
