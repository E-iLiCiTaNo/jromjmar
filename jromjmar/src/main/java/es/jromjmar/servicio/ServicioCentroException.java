package es.jromjmar.servicio;

public class ServicioCentroException extends Exception {

    public ServicioCentroException(String msg, Exception e) {
        super(msg, e);
    }

    public ServicioCentroException(String msg) {
        super(msg);
    }

}
