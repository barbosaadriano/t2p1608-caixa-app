/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rff.view;

import br.com.rff.model.Caixa;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author refra
 */
public class CaixaTableModel extends AbstractTableModel {
    
    ArrayList<Caixa> dados;
    String[] colunas = {"Data","saldo Inicial", "Entrada", "Saida", "Saldo Final", "Status"};

    public CaixaTableModel(ArrayList<Caixa> all) {
        this.dados = all;
    
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
        switch (columnIndex){
            case 0:
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                return sdf.format(cx.getData());
            case 1:
                return cx.getSaldoInicial(); 
            case 2:
                return cx.getEntrada();  
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
