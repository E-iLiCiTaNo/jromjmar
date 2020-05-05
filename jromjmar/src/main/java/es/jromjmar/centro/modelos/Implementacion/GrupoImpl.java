package es.jromjmar.centro.modelos.Implementacion;

import es.jromjmar.centro.modelos.Grupo;

public class GrupoImpl implements Grupo {
    private static int idCounter = -1;

    private int id;
    private String name;
    private boolean ciclos;

    public GrupoImpl(String groupName, boolean isCiclos) {
        name = groupName;
        ciclos = isCiclos;
        id = getNewId();
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

    private static int getNewId() {
        idCounter++;
        return idCounter;
    }
}
