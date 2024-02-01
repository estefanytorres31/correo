package com.api.correo.dto;

public class CorreoDTO {

    private String destinatario;
    private String asunto;
    private String contenido;
    private String nombre;
    private String apellidos;

    public String getNombre() {
        return nombre;
    }




    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




    public String getApellidos() {
        return apellidos;
    }




    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }




    public CorreoDTO() {
        // Constructor sin argumentos
    }

  


 public CorreoDTO(String destinatario, String asunto, String contenido, String nombre, String apellidos) {
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.contenido = contenido;
        this. nombre=nombre;
        this.apellidos=apellidos;
    }


    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
