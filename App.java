package Libreria;

import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        // Declaraciones
        ArrayList<Libro> libros = new ArrayList<Libro>();
        ArrayList<Autor> autores = new ArrayList<Autor>();
        ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
Autor autor = new Autor();
Editorial editorial = new Editorial();
        libros.add(new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", "Salamandra", 499.99f, "26/06/1997"));
        libros.add(new Libro("El señor de los anillos: La comunidad del anillo", "J.R.R. Tolkien", "Minotauro", 599.99f, "29/07/1954"));
        libros.add(new Libro("El principito", "Antoine de Saint-Exupéry", "Reynal & Hitchcock", 299.99f, "06/04/1943"));

        String confirm = "S";
        int opc = 0, opc2 = 0;
        int numLib;
        Scanner entrada = new Scanner(System.in);

        System.out.println("\n\n···········Bienvenidos al sistema de administracion de la Libreria·············\n\n");

        while (opc != 4) {
            System.out.println("Escribe el numero de la seccion que deseas ver");
            System.out.println("1. Libros");
            System.out.println("2. Autores");
            System.out.println("3. Editoriales");
            System.out.println("4. Salir");
            opc = entrada.nextInt();
            entrada.nextLine();

            switch (opc) {
                case 1:  
                    opc2 = 0;
                    while (opc2 != 5) {
                        System.out.println("\n=== ADMINISTRADOR DE LIBROS ===");
                        System.out.println("1. Agregar Libros");
                        System.out.println("2. Editar Libros");
                        System.out.println("3. Consultar Libros");
                        System.out.println("4. Eliminar Libros");
                        System.out.println("5. Regresar al menu anterior");
                        opc2 = entrada.nextInt();
                        entrada.nextLine();

                        switch (opc2) {
                            case 1: 
                                System.out.print("Ingresa el titulo del libro: ");
                                String readTitulo = entrada.nextLine();
                                System.out.print("Ingresa el autor del libro: ");
                                String readAutor = entrada.nextLine();
                                System.out.print("Ingresa la editorial del libro: ");
                                String readEditorial = entrada.nextLine();
                                System.out.print("Ingresa el precio del libro: ");
                                float readPrecio = entrada.nextFloat();
                                entrada.nextLine();
                                System.out.print("Ingresa la fecha de publicacion (dd/mm/yyyy): ");
                                String readFpub = entrada.nextLine();

                                libros.add(new Libro(readTitulo, readAutor, readEditorial, readPrecio, readFpub));
                                System.out.println("Libro agregado exitosamente.");
                                break;

                            case 2: 
                                for (int i = 0; i < libros.size(); i++) {
                                    System.out.println((i + 1) + ". ");
                                    libros.get(i).infoLibro();
                                    System.out.println("----------------------------");
                                }
                                System.out.print("Escribe el numero del libro que quieres editar: ");
                                numLib = entrada.nextInt() - 1;
                                entrada.nextLine();
                                if (numLib >= 0 && numLib < libros.size()) {
                                    libros.get(numLib).infoLibro();
                                    System.out.println("\nIngresa el numero del dato que quieres editar:");
                                    System.out.println("1.Titulo  2.Autor  3.Editorial  4.Precio  5.Fecha");
                                    int datoMod = entrada.nextInt();
                                    entrada.nextLine();
                                    switch (datoMod) {
                                        case 1:
                                            System.out.print("Nuevo titulo: ");
                                            libros.get(numLib).setTitulo(entrada.nextLine());
                                            break;
                                        case 2:
                                            System.out.print("Nuevo autor: ");
                                            libros.get(numLib).setAutor(entrada.nextLine());
                                            break;
                                        case 3:
                                            System.out.print("Nueva editorial: ");
                                            libros.get(numLib).setEditorial(entrada.nextLine());
                                            break;
                                        case 4:
                                            System.out.print("Nuevo precio: ");
                                            libros.get(numLib).setPrecio(entrada.nextFloat());
                                            entrada.nextLine();
                                            break;
                                        case 5:
                                            System.out.print("Nueva fecha (dd/mm/yyyy): ");
                                            libros.get(numLib).setFecha(entrada.nextLine());
                                            break;
                                    }
                                    System.out.println("Libro editado exitosamente.");
                                }
                                break;

                            case 3: 
                                for (int i = 0; i < libros.size(); i++) {
                                    libros.get(i).infoLibro();
                                    System.out.println("----------------------------");
                                }
                                break;

                            case 4:
                                for (int i = 0; i < libros.size(); i++) {
                                    System.out.println((i + 1) + ". ");
                                    libros.get(i).infoLibro();
                                    System.out.println("----------------------------");
                                }

                                confirm = "S";
                                while (confirm.toUpperCase().equals("S")) {
                                    System.out.print("Escribe el numero del libro que quieres eliminar: ");
                                    numLib = entrada.nextInt() - 1;
                                    entrada.nextLine();

                                    if (numLib < 0 || numLib >= libros.size()) {
                                        System.out.println("Numero invalido.");
                                        System.out.print("¿Deseas eliminar otro libro? (S/N): ");
                                        confirm = entrada.nextLine();
                                        continue;
                                    }

                                    libros.get(numLib).infoLibro();
                                    System.out.println("\n¿Estás seguro que quieres eliminar este libro? (S/N)");
                                    confirm = entrada.nextLine();

                                    if ("S".equals(confirm.toUpperCase())) {
                                        libros.remove(numLib);
                                        System.out.println(" Libro eliminado exitosamente.");
                                    }

                                    System.out.print("¿Deseas eliminar otro libro? (S/N): ");
                                    confirm = entrada.nextLine();
                                }
                                break;

                            case 5:
                                break;
                            default:
                        }
                    }
                    break;

                case 2:  
                    opc2 = 0;
                    while (opc2 != 5) {
                        System.out.println("\n=== ADMINISTRADOR DE AUTORES ===");
                        System.out.println("1. Agregar autores");
                        System.out.println("2. Editar autores");
                        System.out.println("3. Consultar autores");
                        System.out.println("4. Eliminar autores");
                        System.out.println("5. Regresar al menu anterior");
                        opc2 = entrada.nextInt();
                        entrada.nextLine();

                        switch (opc2) {
                            case 1: autor.agregarAutor(); break;
                            case 2: autor.editarAutor(); break;
                            case 3: autor.infoAutores(); break;
                            case 4: autor.eliminarAutor(); break;
                            case 5: break;
                        }
                    }
                    break;

                case 3:  
                    opc2 = 0;
                    while (opc2 != 5) {
                        System.out.println("\n=== ADMINISTRADOR DE EDITORIALES ===");
                        System.out.println("1. Agregar editoriales");
                        System.out.println("2. Editar editoriales");
                        System.out.println("3. Consultar editoriales");
                        System.out.println("4. Eliminar editoriales");
                        System.out.println("5. Regresar al menu anterior");
                        opc2 = entrada.nextInt();
                        entrada.nextLine();

                        switch (opc2) {
                            case 1: editorial.agregarEditorial(); break;
                            case 2: editorial.editarEditorial(); break;
                            case 3: editorial.infoEditorial(); break;
                            case 4: editorial.eliminarEditorial(); break;
                            case 5: break;
                        }
                    }
                    break;

                case 4: 
                    System.out.println("...VUELVE PRONTO LECTOR...");
                    break;

                default:
            }
        }

        entrada.close();
    }
}
