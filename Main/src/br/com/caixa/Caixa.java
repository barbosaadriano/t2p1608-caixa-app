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
    private Date data;
    private double SaldoInicial;
    private double entradas;
    private double saidas;
    private double saldoFinal;
    private statusCaixa status;
    
    public Caixa(){
        data = new Date();
        status = Caixa.statusCaixa.ABERTO;
        
    }

      
    public enum statusCaixa{
        ABERTO,FECHADO;
    }

    public Date getDate() {
        return data;
    }

    public void setDate(Date date) {
        this.data = date;
    }

    public double getSaldoInicial() {
        return SaldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.SaldoInicial = saldoInicial;
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
