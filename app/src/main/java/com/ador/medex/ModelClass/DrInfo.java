package com.ador.medex.ModelClass;

public class DrInfo {
    private int id;
    private String drName;
    private String drSpeciality;
    private String drPhoneNumber;
    private String drAddress;

    public DrInfo(String drName, String drSpeciality, String drPhoneNumber, String drAddress) {
        this.drName = drName;
        this.drSpeciality = drSpeciality;
        this.drPhoneNumber = drPhoneNumber;
        this.drAddress = drAddress;
    }

    public DrInfo(int id, String drName, String drSpeciality, String drPhoneNumber, String drAddress) {
        this.id = id;
        this.drName = drName;
        this.drSpeciality = drSpeciality;
        this.drPhoneNumber = drPhoneNumber;
        this.drAddress = drAddress;
    }

    public int getId() {
        return id;
    }

    public String getDrName() {
        return drName;
    }

    public String getDrSpeciality() {
        return drSpeciality;
    }

    public String getDrPhoneNumber() {
        return drPhoneNumber;
    }

    public String getDrAddress() {
        return drAddress;
    }
}
