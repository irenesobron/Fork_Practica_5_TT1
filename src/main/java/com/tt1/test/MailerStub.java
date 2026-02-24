package com.tt1.test;

public class MailerStub {
    private String email;
    private String mensaje;

    public MailerStub(String email, String mensaje) {
        this.email = email;
        this.mensaje = mensaje;
    }
    boolean enviarCorreo(){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

}
