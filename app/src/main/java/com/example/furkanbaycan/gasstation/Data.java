package com.example.furkanbaycan.gasstation;

public class Data {

    private int petrolID;
    private String isim;

    public Data() {
    }

    public Data(int petrolID, String isim) {
        this.petrolID = petrolID;
        this.isim = isim;
    }

    public int getPetrolID() {
        return petrolID;
    }

    public void setPetrolID(int petrolID) {
        this.petrolID = petrolID;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String sim) {
        this.isim = isim;
    }
}
