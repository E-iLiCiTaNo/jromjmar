package es.jromjmar.centro.modelos;

import es.jromjmar.centro.modelos.Implementacion.AlumnoImpl;

import java.util.Date;
import java.util.List;

public interface Alumno {

    /**
     * Method to create a new object "Alumno".
     * @param id "Alumno" id.
     * @param name Name of the "Alumno".
     * @param birthDate "Alumno" birthdate.
     * @param group "Alumno" group.
     * @return
     */
    static Alumno create(int id, String name, Date birthDate, Grupo group) {
        return new AlumnoImpl(id, name, birthDate, group);
    }

    /**
     * Get the "Alumno" id.
     * @return "Alumno" object id.
     */
    int getId();

    /**
     * Get the "Alumno" name as String.
     * @return an String with the "Alumno" name.
     */
    String getName();

    /**
     * Get the "Alumno" birth date as a date object.
     * @return date object with the "Alumno" birth date.
     */
    Date getBirtDate();

    /**
     * Get the "Grupo" the "Alumno" is asociated with.
     * @return the current "Grupo" for the "Alumno".
     */
    Grupo getGroup();

}
