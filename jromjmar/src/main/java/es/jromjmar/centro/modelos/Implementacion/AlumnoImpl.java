package es.jromjmar.centro.modelos.Implementacion;

import es.jromjmar.centro.modelos.Alumno;
import es.jromjmar.centro.modelos.Grupo;

import java.util.Date;
import java.util.List;

public class AlumnoImpl implements Alumno {

    private int id;
    private String name;
    private Date birthDate;
    private Grupo group;

    public AlumnoImpl(int id, String name, Date birthDate, Grupo group) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirtDate() {
        return birthDate;
    }

    public Grupo getGroup() {
        return group;
    }

}
