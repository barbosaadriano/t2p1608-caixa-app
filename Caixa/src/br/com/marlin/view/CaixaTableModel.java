
package br.com.marlin.view;

import br.com.marlin.model.Caixa;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class CaixaTableModel extends AbstractTableModel {

    ArrayList<Caixa> dados;
    String[] colunas = {"Status","Saldo Inicial","Entradas","Saídas","Saldo Final","Data"};

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
                return cx.getStatus();
            case 1:
                return cx.getSaldoInicial();
            case 2:
                return cx.getEntradas();
            case 3:
                return cx.getSaidas();
            case 4: 
                return cx.getSaldoFinal();
            case 5:
                return cx.getData();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    
}
