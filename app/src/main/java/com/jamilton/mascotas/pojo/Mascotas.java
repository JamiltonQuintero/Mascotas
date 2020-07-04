package com.jamilton.mascotas.pojo;

public class Mascotas implements Comparable<Mascotas>{

    private int id;
    private String nMascota;
    private int numLikes;
    private int imagen, imagenHue;



    public Mascotas(String nMascota, int numLikes, int imagen, int imagenHue) {
        this.nMascota = nMascota;
        this.numLikes = numLikes;
        this.imagen = imagen;
        this.imagenHue = imagenHue;

    }

    public Mascotas() {

    }

    public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;

    }
    public String getnMascota() {
        return nMascota;
    }

    public void setnMascota(String nMascota) {
        this.nMascota = nMascota;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(int numLikes) {
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

    @Override
    public int compareTo(Mascotas mascotas) {
        if (mascotas.getNumLikes() < numLikes){
            return -1;
        }else if (mascotas.getNumLikes() < numLikes){
            return 0;
        } else {
            return 1;
        }

    }
}
