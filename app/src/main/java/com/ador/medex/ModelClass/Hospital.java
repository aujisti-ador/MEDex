package com.ador.medex.ModelClass;


public class Hospital {

    private String h_name,h_status,h_open,h_phone;
    private int h__img;

    public Hospital(String h_name, String h_status, String h_open, String h_phone, int h__img) {
        this.h_name = h_name;
        this.h_status = h_status;
        this.h_open = h_open;
        this.h_phone = h_phone;
        this.h__img = h__img;
    }

    public String getH_name() {

        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public String getH_status() {
        return h_status;
    }

    public void setH_status(String h_status) {
        this.h_status = h_status;
    }

    public String getH_open() {
        return h_open;
    }

    public void setH_open(String h_open) {
        this.h_open = h_open;
    }

    public String getH_phone() {
        return h_phone;
    }

    public void setH_phone(String h_phone) {
        this.h_phone = h_phone;
    }

    public int getH__img() {
        return h__img;
    }

    public void setH__img(int h__img) {
        this.h__img = h__img;
    }
}
