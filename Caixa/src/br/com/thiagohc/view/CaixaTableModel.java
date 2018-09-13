/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thiagohc.view;

import br.com.thiagohc.model.Caixa;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author thiag
 */
public class CaixaTableModel extends AbstractTableModel {
    
    ArrayList<Caixa> dados;
    String[] colunas = {"Data","Saldo Inicial","Entradas","Saidas","Saldo Final","Status"};

    public CaixaTableModel(ArrayList<Caixa> dados) {
        this.dados = dados;
    }
    
    

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
              return cx.getData();
           case 1:
              return cx.getSaldoInicial();
           case 2:
              return cx.getEntradas();
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
