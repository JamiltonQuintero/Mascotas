package com.jamilton.mascotas.restappi.model;

public class IdInstagram {
    private String ig_id;
    private String id;


    public IdInstagram(String ig_id) {
        this.ig_id = ig_id;

    }
    public IdInstagram() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIg_id() {
        return ig_id;
    }

    public void setIg_id(String ig_id) {
        this.ig_id = ig_id;
    }

}
