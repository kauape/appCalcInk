package com.example.appcalcink.model;

public class Wall {
    private Double altura;
    private Double largura;
    private Integer portas;
    private Integer janelas;

    public Wall(Double altura, Double largura, Integer portas, Integer janelas) {
        this.altura = altura;
        this.largura = largura;
        this.portas = portas;
        this.janelas = janelas;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Integer getPortas() {
        return portas;
    }

    public void setPortas(Integer portas) {
        this.portas = portas;
    }

    public Integer getJanelas() {
        return janelas;
    }

    public void setJanelas(Integer janelas) {
        this.janelas = janelas;
    }
}
