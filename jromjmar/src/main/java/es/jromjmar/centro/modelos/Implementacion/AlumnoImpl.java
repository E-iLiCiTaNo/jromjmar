package es.jromjmar.centro.modelos.Implementacion;

import es.jromjmar.centro.modelos.Alumno;
import es.jromjmar.centro.modelos.Grupo;

import java.util.Date;
import java.util.List;

public class AlumnoImpl implements Alumno {

    private static int idCounter = -1;

    private int id;
    private String name;
    private Date birthDate;
    private Grupo group;

    public AlumnoImpl(String name, Date birthDate, Grupo group) {
        id = getNewId();
        this.name = name;
        this.birthDate = birthDate;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public String getNanme() {
        return name;
    }

    public Date getBirtDate() {
        return birthDate;
    }

    public Grupo getGroup() {
        return group;
    }

    private static int getNewId() {
       idCounter++;
       return idCounter;
    }
}
