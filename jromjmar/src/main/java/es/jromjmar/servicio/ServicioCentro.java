package es.jromjmar.servicio;

import es.jromjmar.centro.modelos.Alumno;
import es.jromjmar.centro.modelos.Grupo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServicioCentro implements IServicioCentro {
    // Ejemplo del patron singleton
    // El constructor es privado

    private List<Alumno> alumnos;
    private List<Grupo> grupos;

    private static ServicioCentro servicioCentro;

    private ServicioCentro() {
        alumnos = new ArrayList<>();
        grupos = new ArrayList<>();
    }

    public static ServicioCentro getServicioCentro() {
        if (servicioCentro == null) {
            servicioCentro = new ServicioCentro();
        }
        return servicioCentro;
    }

    public void nuevoAlumno(int id, String nombre, Date fechaNac) throws ServicioCentroException {
        if (id <= 0) {
            throw new ServicioCentroException("El id no puede ser ni 0 ni negativo");
        }
        if (nombre.equals("")) {
            throw new ServicioCentroException("El alumno debe tener un nombre");
        }
        for (Alumno a :alumnos) {
            if (a.getId() == id) {
                throw new ServicioCentroException("Ya existe un alumno con ese id.");
            }
        }
        Alumno a = Alumno.create(id, nombre, fechaNac, null);
        alumnos.add(a);
    }

    public void nuevoGrupo(int id, String nombre, boolean ciclos) throws ServicioCentroException {

    }

    public void modificarAlumno(int id, String nombre, Date fechaNac) throws ServicioCentroException {

    }

    public void asignarAlumno(int idAlumno, int idGrupo) throws ServicioCentroException {

    }

    public void eliminarAlumno(int id) throws ServicioCentroException {

    }

    public void eliminarGrupo(int id) throws ServicioCentroException {

    }

    public List<Alumno> obtenerAlumnos() {
        return null;
    }

    public List<Grupo> obtenerGrupo() {
        return null;
    }
}
