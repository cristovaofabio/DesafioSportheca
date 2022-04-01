package com.desafio.sportheca.domain;

public class WorldCup {
    private double max;
    private double pla;
    private int pos;

    public int getMax() {
        int i = (int) this.max;
        return i;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public int getPla() {
        int i = (int) this.pla;
        return i;
    }

    public void setPla(double pla) {
        this.pla = pla;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
