package com.example.furkanbaycan.gasstation.HTTPParser;

import java.io.Serializable;

public class DataModel implements Serializable {
    private String petrolMarka;
    private String petrolFiyat;
    private String petrolFiyat2;

    public DataModel(String petrolMarka, String petrolFiyat, String petrolFiyat2) {
        this.petrolMarka = petrolMarka;
        this.petrolFiyat = petrolFiyat;
        this.petrolFiyat2 = petrolFiyat2;
    }

    public String getPetrolMarka() {
        return petrolMarka;
    }

    public void setPetrolMarka(String petrolMarka) {
        this.petrolMarka = petrolMarka;
    }

    public String getPetrolFiyat() {
        return petrolFiyat;
    }

    public void setPetrolFiyat(String petrolFiyat) {
        this.petrolFiyat = petrolFiyat;
    }

    public String getPetrolFiyat2() {
        return petrolFiyat2;
    }

    public void setPetrolFiyat2(String petrolFiyat2) {
        this.petrolFiyat2 = petrolFiyat2;
    }

}
