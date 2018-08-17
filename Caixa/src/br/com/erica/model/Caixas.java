//todo objeto tem um modelo
package br.com.erica.model;

import java.util.Date;

/**
 *
 * @author Erica
 */
public class Caixas {
    
    private Date data; 
    private double saldoInicial;
    private double entradas;
    private double saidas;
    private double saldoFinal;
    private StatusCaixa status; //primeiro criar a subclasee para atribuir valores

    public Caixas() {
        data = new Date(); //ja cria com a data atual
        status = Caixas.StatusCaixa.ABERTO;
    }
        
    //sub classe 
    public enum StatusCaixa {
        ABERTO,FECHADO;
    }
    
    //ALT + INSERT / get e setter / seleciona tudo
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

    public StatusCaixa getStatus() {
        return status;
    }

    public void setStatus(StatusCaixa status) {
        this.status = status;
    }
     
    
}
