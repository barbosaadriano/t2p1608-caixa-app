/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caixa;

import java.util.Date;

/**
 *
 * @author Alisson H. Silva
 */
public class Caixa {
    private Date date;
    private double saldoInicial;
    private double entradas;
    private double saidas;
    private double saldoFinal;
    private statusCaixa status;
    
    public Caixa(){
        date = new Date();
        status = Caixa.statusCaixa.ABERTO;
        
    }
    
    public enum statusCaixa{
        ABERTO,FECHADO;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public double getEntradas() {
        return entradas;
    }

    public void setEntradas(double entradas) {
        this.entradas = entradas;
    }

    public double getSaidas() {
        return saidas;
    }

    public void setSaidas(double saidas) {
        this.saidas = saidas;
    }

    public double getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public statusCaixa getStatus() {
        return status;
    }

    public void setStatus(statusCaixa status) {
        this.status = status;
    }
    
    
}
