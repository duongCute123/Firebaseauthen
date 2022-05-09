package com.example.firebase;

public class Giay {
    private String ten;
    private  String nhaSX;
    private double gia;
    private int img;

    public Giay(String ten, String nhaSX, double gia, int img) {
        this.ten = ten;
        this.nhaSX = nhaSX;
        this.gia = gia;
        this.img = img;
    }

    public Giay() {
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNhaSX() {
        return nhaSX;
    }

    public void setNhaSX(String nhaSX) {
        this.nhaSX = nhaSX;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
