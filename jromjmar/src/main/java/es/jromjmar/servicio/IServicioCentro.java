package es.jromjmar.servicio;

import es.jromjmar.centro.modelos.Alumno;
import es.jromjmar.centro.modelos.Grupo;

import java.util.Date;
import java.util.List;

public interface IServicioCentro {

    // Inserta un nuevo alumno, lanzara una excepcion si
    // falta id o esta duplicado
    // falta el nombre
    void nuevoAlumno(int id, String nombre, Date fechaNac) throws ServicioCentroException;

    // lanza excepcion si falta cualquier campo o id repetido
    void nuevoGrupo(int id, String nombre, boolean ciclos) throws ServicioCentroException;

    // lanza excepcion si el id del alumno no existe, es nulo (=0) o
    // no tiene nombre
    void modificarAlumno(int id, String nombre, Date fechaNac) throws ServicioCentroException;

    // lanza excepcion si no existen el alumno o el grupo con ese id
    void asignarAlumno(int idAlumno, int idGrupo) throws ServicioCentroException;

    // lanza excepcion si el id no existe
    void eliminarAlumno(int id) throws ServicioCentroException;

    // lanza excepcion si no existe el grupo o el grupo tiene alumnos
    void eliminarGrupo(int id) throws ServicioCentroException;

    List<Alumno> obtenerAlumnos();
    List<Grupo> obtenerGrupo();

}
