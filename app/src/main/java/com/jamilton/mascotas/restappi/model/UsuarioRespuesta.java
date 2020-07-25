package com.jamilton.mascotas.restappi.model;

public class UsuarioRespuesta {

    private String iddispositivo;
    private String idusuarioinstagram;



    public UsuarioRespuesta(String iddispositivo, String idusuarioinstagram) {
        this.iddispositivo = iddispositivo;
        this.idusuarioinstagram = idusuarioinstagram;

    }

    public UsuarioRespuesta() {

    }

    public String getIddispositivo() {
        return iddispositivo;
    }

    public void setIddispositivo(String iddispositivo) {
        this.iddispositivo = iddispositivo;
    }

    public String getIdusuarioinstagram() {
        return idusuarioinstagram;
    }

    public void setIdusuarioinstagram(String idusuarioinstagram) {
        this.idusuarioinstagram = idusuarioinstagram;
    }

}
