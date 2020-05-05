package es.jromjmar.Main;

import es.jromjmar.vistas.VistasAlumno;
import es.jromjmar.vistas.VistasGrupo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        VistasAlumno va = new VistasAlumno();
        VistasGrupo vg = new VistasGrupo();
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("Introduce la opción");
            System.out.println("0.Salir");
            System.out.println("1.Gestion Grupos");
            System.out.println("2.Gestion de Alumnos");

            Scanner sc = new Scanner(System.in);
            String entrada = sc.nextLine();
            // Comprobamos número valido
            if (!Utilidades.esEntero(entrada)) {
                opcion = -1;
            } else {
                opcion = Integer.parseInt(entrada);
            }

            if (opcion >= 3 || opcion < 0) {
                System.out.println("Opcion No valida");
                opcion = -1;
            }
            if (opcion == 2) {
                va.menuAlumno();
            }
            // TODO opcion 1
        }

    }
}
