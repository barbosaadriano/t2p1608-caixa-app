package br.com.erica.view;

import br.com.erica.model.Caixas;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Erica
 */
public class CaixaTableModel extends AbstractTableModel {

    ArrayList<Caixas> dados;   
    String[] colunas = {"Data","Saldo Inicial","Entradas","Saidas","Saldo Final","Status"};

    public CaixaTableModel(ArrayList<Caixas> dados) {
        this.dados = dados;
    }
    
    @Override
    public int getRowCount() { //retorna quantidade de linhas
        return dados.size();
    }

    @Override
    public int getColumnCount() { 
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Caixas cx = dados.get(rowIndex);
        switch (columnIndex){
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
