package com.desafio.sportheca.domain;

public class Jogador {
    private String img;
    private String name;
    private double percentual;
    private String pos;
    private String country;
    private Barra Barras;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPercentage() {
        return String.format("%.2f", this.percentual);
    }

    public void setPercentage(double percentage) {
        this.percentual = percentage;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Barra getBarras() {
        return Barras;
    }

    public void setBarras(Barra barras) {
        Barras = barras;
    }
}
