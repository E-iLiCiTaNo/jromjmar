package es.jromjmar.centro.modelos.Implementacion;

import es.jromjmar.centro.modelos.Grupo;

public class GrupoImpl implements Grupo {

    private int id;
    private String name;
    private boolean ciclos;

    public GrupoImpl(int id, String groupName, boolean isCiclos) {
        name = groupName;
        ciclos = isCiclos;
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isCiclos() {
        return ciclos;
    }
}
