package com.example.furkanbaycan.gasstation.Model;

import java.util.List;

public class FirebaseSehirModel {
    private String il;
    private Long plaka;
    private List<String> ilceleri;

    public FirebaseSehirModel() {
    }

    public FirebaseSehirModel(String il, Long plaka, List<String> ilceleri) {
        this.il = il;
        this.plaka = plaka;
        this.ilceleri = ilceleri;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public Long getPlaka() {
        return plaka;
    }

    public void setPlaka(Long plaka) {
        this.plaka = plaka;
    }

    public List<String> getIlceleri() {
        return ilceleri;
    }

    public void setIlceleri(List<String> ilceleri) {
        this.ilceleri = ilceleri;
    }
}
