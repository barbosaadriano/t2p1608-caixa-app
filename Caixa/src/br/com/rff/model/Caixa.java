/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rff.model;

import java.util.Date;

/**
 *
 * @author refra
 */
public class Caixa {
    
    private Date data;
    private double saldoInicial;
    private double entrada;
    private double saida;
    private double saldoFinal;
    private StatusCaixa status;

    public Caixa() {
        data = new Date();
        status = Caixa.StatusCaixa.ABERTO;
    }

   
    
    
    
    public enum StatusCaixa {
        ABERTO,FECHADO;
        
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public double getEntrada() {
        return entrada;
    }

    public void setEntrada(double entrada) {
        this.entrada = entrada;
    }

    /**
     *
     * @return
     */
    public double getSaidas() {
        return saida;
    }

    public void setSaidas(double saidas) {
        this.saida = saidas;
    }

    public double getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public StatusCaixa getStatus() {
        return status;
    }

    public void setStatus(StatusCaixa status) {
        this.status = status;
    }
    
    
    
}
