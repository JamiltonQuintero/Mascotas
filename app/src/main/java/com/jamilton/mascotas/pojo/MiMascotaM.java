package com.jamilton.mascotas.pojo;

public class MiMascotaM {
    private String numLikes;
    private int imagen, imagenHue;

    public String getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(String numLikes) {
        this.numLikes = numLikes;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getImagenHue() {
        return imagenHue;
    }

    public void setImagenHue(int imagenHue) {
        this.imagenHue = imagenHue;
    }

    public MiMascotaM(String numLikes, int imagen, int imagenHue) {
        this.numLikes = numLikes;
        this.imagen = imagen;
        this.imagenHue = imagenHue;
    }
}

