/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alissonhs.view;

import br.com.caixa.Caixa;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alisson H. Silva
 */
public class CaixaTableModel extends AbstractTableModel {

    public CaixaTableModel(ArrayList<Caixa> dados) {
        this.dados = dados;
    }

    

    ArrayList<Caixa> dados;
    String[] colunas = {"Data", "Saldo Inicial", "Entradas", "Saídas", "Saldo Final", "Status"};

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Caixa cx = dados.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cx.getDate();
            case 2:
                return cx.getSaldoInicial();
            case 3:
                return cx.getSaidas();
            case 4:
                return cx.getSaldoFinal();
            case 5:
                return cx.getStatus();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    
}
