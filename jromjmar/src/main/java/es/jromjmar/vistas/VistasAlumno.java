package es.jromjmar.vistas;

import es.jromjmar.Main.Utilidades;
import es.jromjmar.centro.modelos.Alumno;
import es.jromjmar.servicio.ServicioCentro;
import es.jromjmar.servicio.ServicioCentroException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VistasAlumno {
    private Scanner sc = new Scanner(System.in);
    public void menuAlumno() {
        int opcion = -1;
        while (opcion == -1) {
            System.out.println("Introduzca la opción: ");
            System.out.println("0: Salir\n1: Nuevo Alumno\n2: Modificar Alumno \n" +
                    "3: Asignar alumno a grupo\n4: Eliminar Alumno\n5: Ver todos los alumnos");
            String entrada = sc.nextLine();

            if(!Utilidades.esEntero(entrada))
                opcion = -1;
            else
                opcion = Integer.parseInt(entrada);

            if(opcion == -1)
                System.out.println("Opción no válida.");
            else
                switch (opcion) {
                    case 0:
                        System.out.println("Saliendo...");
                        System.exit(0);
                        break;
                    case 1:
                        nuevoAlumno();
                        break;
                    case 2:
                        modificarAlumno();
                        break;
                    case 3:
                        asignarAGrupo();
                        break;
                    case 4:
                        eliminarAlumno();
                        break;
                    case 5:
                        verAlumnos();
                        break;
                    default:
                        System.out.println("Error.");
                        break;
                }


        }
    }

    private void verAlumnos() {
        List<Alumno> alumnoList = ServicioCentro.getServicioCentro().obtenerAlumnos();
        if(alumnoList == null) {
            System.out.println("No hay alumnos.");
            return;
        }
        int size = alumnoList.size();
        for(int i = 0; i < size; i++) {
            Alumno al = alumnoList.get(i);
            System.out.println("Id: " + al.getId() + "\tNombre: " + al.getName() + "\tFechaNac: " + al.getBirtDate().toString() + "Grupo: " + al.getGroup().getName());
        }
    }

    private void eliminarAlumno() {
        List<Alumno> alumnoList = ServicioCentro.getServicioCentro().obtenerAlumnos();
        if(alumnoList == null) {
            System.out.println("No hay alumnos.");
            return;
        }
        int size = alumnoList.size();

        System.out.print("ID del alumno para eliminar: ");
        int id = -1;
        String entrada;

        while (id == -1) {
            System.out.print("Dime el id: ");
            entrada = sc.nextLine();
            if (!Utilidades.esEntero(entrada)) {
                id = -1;
                System.out.println("El id debe ser numérico.");
            } else {
                id = Integer.parseInt(entrada);
                if (id < 0) {
                    System.out.println("El id no puede ser menor que 0.");
                    id = -1;
                }
            }
        }

        for(int i = 0; i < size; i++) {
            Alumno al = alumnoList.get(i);
            if(al.getId() == id) {
                try {
                    ServicioCentro.getServicioCentro().eliminarAlumno(id);
                    break;
                } catch (ServicioCentroException e) {
                    System.out.println("No se ha podido eliminar el alumno con id: " + id);
                }
            }
            System.out.println("No se ha encontrado al alumno con id: " + id);
        }
    }

    private void asignarAGrupo() {
        List<Alumno> alumnoList = ServicioCentro.getServicioCentro().obtenerAlumnos();
        if(alumnoList == null) {
            System.out.println("No hay alumnos.");
            return;
        }
        int size = alumnoList.size();
        System.out.print("ID del alumno para agregar grupo: ");
        int id = -1;
        int idGrupo = -1;
        String entrada;

        while (id == -1) {
            System.out.print("Dime el id: ");
            entrada = sc.nextLine();
            if (!Utilidades.esEntero(entrada)) {
                id = -1;
                System.out.println("El id debe ser numérico.");
            } else {
                id = Integer.parseInt(entrada);
                if (id < 0) {
                    System.out.println("El id no puede ser menor que 0.");
                    id = -1;
                }
            }
        }
        while (idGrupo == -1) {
            System.out.print("Dime el id del grupo: ");
            entrada = sc.nextLine();
            if (!Utilidades.esEntero(entrada)) {
                id = -1;
                System.out.println("El id debe ser numérico.");
            } else {
                id = Integer.parseInt(entrada);
                if (id < 0) {
                    System.out.println("El id no puede ser menor que 0.");
                    id = -1;
                }
            }
        }

        for(int i = 0; i < size; i++) {
            Alumno al = alumnoList.get(i);
            if(al.getId() == id) {
                try {
                    ServicioCentro.getServicioCentro().asignarAlumno(id, idGrupo);
                    break;
                } catch (ServicioCentroException e) {
                    System.out.println("No se ha podido asignar el grupo al alumno con id: " + id);
                }
            }
            System.out.println("No se ha encontrado al alumno con id: " + id);
        }
    }

    private void modificarAlumno() {
        System.out.println("Modificando usuario: ");
        int id = -1;
        String nombre = null;
        String entrada;
        Date fechaNac = null;
        while (id == -1) {
            System.out.print("Dime el id: ");
            entrada = sc.nextLine();
            if (!Utilidades.esEntero(entrada)) {
                id = -1;
                System.out.println("El id debe ser numérico.");
            } else {
                id = Integer.parseInt(entrada);
                if (id < 0) {
                    System.out.println("El id no puede ser menor que 0.");
                    id = -1;
                }
            }
        }
        while (nombre == null) {
            System.out.print("Dime el nombre: ");
            nombre = sc.nextLine();
            if(nombre == null)
                System.out.println("El nombre no es valido.");
        }
        while (fechaNac == null) {
            String fecha = "";
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            boolean valid = false;
            while (!valid) {
                System.out.print("Introduce la fecha de nacimiento(dd/MM/yyyy): ");
                fecha = sc.nextLine();
                try {
                    fechaNac = sdf.parse(fecha);
                    valid = true;
                } catch (Exception e) {
                    valid = false;
                    fechaNac = null;
                }
                if (!valid)
                    System.out.println("Fecha no valida.");
                else
                    fechaNac = Utilidades.obtenerFecha(fecha);
            }
        }

        try {
            ServicioCentro.getServicioCentro().modificarAlumno(id, nombre, fechaNac);
        } catch (ServicioCentroException e) {
            System.out.println("No se ha podido mdoficar el alumno.");
        }
    }

    private void nuevoAlumno() {
        System.out.println("Creando usuario: ");
        int id = -1;
        String nombre = null;
        String entrada;
        Date fechaNac = null;
        while (id == -1) {
            System.out.print("Dime el id: ");
            entrada = sc.nextLine();
            if (!Utilidades.esEntero(entrada)) {
                id = -1;
                System.out.println("El id debe ser numérico.");
            } else {
                id = Integer.parseInt(entrada);
                if (id < 0) {
                    System.out.println("El id no puede ser menor que 0.");
                    id = -1;
                }
            }
        }
        while (nombre == null) {
            System.out.print("Dime el nombre: ");
            nombre = sc.nextLine();
            if(nombre == null)
                System.out.println("El nombre no es valido.");
        }
        while (fechaNac == null) {
            String fecha = "";
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            boolean valid = false;
            while (!valid) {
                System.out.print("Introduce la fecha de nacimiento(dd/MM/yyyy): ");
                fecha = sc.nextLine();
                try {
                    fechaNac = sdf.parse(fecha);
                    valid = true;
                } catch (Exception e) {
                    valid = false;
                    fechaNac = null;
                }
                if (!valid)
                    System.out.println("Fecha no valida.");
                else
                    fechaNac = Utilidades.obtenerFecha(fecha);
            }
        }

        try {
            System.out.println("Usuario añadido.");
            ServicioCentro.getServicioCentro().nuevoAlumno(id, nombre, fechaNac);
        } catch (ServicioCentroException e) {
            System.out.println("No se ha podido añadir el alumno.");
        }

    }


}
