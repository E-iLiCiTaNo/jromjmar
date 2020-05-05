package es.jromjmar.vistas;

import es.jromjmar.Main.Utilidades;
import es.jromjmar.centro.modelos.Alumno;
import es.jromjmar.centro.modelos.Grupo;
import es.jromjmar.servicio.ServicioCentro;
import es.jromjmar.servicio.ServicioCentroException;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VistasGrupo {

    private Scanner sc = new Scanner(System.in);
    public void menuAlumno() {
        int opcion = -1;
        while (opcion == -1) {
            System.out.println("Introduzca la opción: ");
            System.out.println("0: Salir\n1: Nuevo grupo\n2: Eliminar grupo \n");
            String entrada = sc.nextLine();

            if(!Utilidades.esEntero(entrada))
                opcion = -1;
            else
                opcion = Integer.parseInt(entrada);

            if(opcion == -1)
                System.out.println("Opción no válida.");
            else {
                switch (opcion) {
                    case 0:
                        System.out.println("Saliendo...");
                        System.exit(0);
                        break;
                    case 1:
                        nuevoGrupo();
                        break;
                    case 2:
                        eliminarGrupo();
                        break;
                    default:
                        System.out.println("Error.");
                        break;
                }
            }


        }
    }

    private void nuevoGrupo() {
        System.out.println("Creando grupo: ");
        int id = -1;
        String nombre = null;
        String entrada = "";
        boolean isCiclo = false;
        while (id == -1) {
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
        while (nombre == null) {
            System.out.print("Dime el nombre del grupo: ");
            nombre = sc.nextLine();
            if(nombre == null)
                System.out.println("El nombre del grupo no es valido.");
        }

        while(!entrada.equalsIgnoreCase("Si") || !entrada.equalsIgnoreCase("no")) {
            System.out.print("El grupo es un ciclo? (Si/No): ");
            entrada = sc.nextLine();
            if(!entrada.equalsIgnoreCase("Si") || !entrada.equalsIgnoreCase("no"))
                System.out.println("Opción no válida.");
        }
        if(entrada.equalsIgnoreCase("Si"))
            isCiclo = true;

        try {
            ServicioCentro.getServicioCentro().nuevoGrupo(id, nombre, isCiclo);
        } catch (ServicioCentroException e) {
            System.out.println("No se ha podido añadir el grupo.");
        }

    }

    private void eliminarGrupo() {
        System.out.print("ID del grupo para eliminarlo: ");
        int id = -1;
        String entrada;

        while (id == -1) {
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

        List<Grupo> grupoList = ServicioCentro.getServicioCentro().obtenerGrupo();
        int size = grupoList.size();
        for(int i = 0; i < size; i++) {
            Grupo al = grupoList.get(i);
            if(al.getId() == id) {
                try {
                    ServicioCentro.getServicioCentro().eliminarGrupo(id);
                    break;
                } catch (ServicioCentroException e) {
                    System.out.println("No se ha podido eliminar el alumno con id: " + id);
                }
            }
            System.out.println("No se ha encontrado al alumno con id: " + id);
        }
    }
}
