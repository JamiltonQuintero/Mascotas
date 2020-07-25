package com.jamilton.mascotas.pojo;

public class MiMascotaM {

    private String urlImagen;// imagenHue,numLikes;
    private String idM;
    private String nombreCompleto;
    private String fecha;



    public MiMascotaM(String urlImagen, String idM, String nombreCompleto, String fecha) {
        this.urlImagen = urlImagen;
        this.idM = idM;
        this.nombreCompleto = nombreCompleto;
        this.fecha= fecha;
    }

    public MiMascotaM() {

    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getIdM() {
        return idM;
    }

    public void setIdM(String idM) {
        this.idM = idM;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}

