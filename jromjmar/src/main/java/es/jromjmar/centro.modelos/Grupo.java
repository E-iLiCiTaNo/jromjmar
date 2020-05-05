package es.jromjmar.centro.modelos;

import es.jromjmar.centro.modelos.Implementacion.GrupoImpl;

public interface Grupo {

    /**
     *
     * @param groupName "Grupo" name.
     * @param isCiclos is "Grupo" a "Ciclo"?
     * @return new "Grupo" object.
     */
    static Grupo create(String groupName, boolean isCiclos) {
        return new GrupoImpl(groupName, isCiclos);
    }

    /**
     * Get the group id.
     * @return integer with the group id.
     */
    int getId();

    /**
     * Get the group name.
     * @return String with the group name.
     */
    String getName();

    /**
     * Boolean to know if the group is a "ciclo" or not.
     * @return boolean.
     */
    boolean isCiclos();
}
