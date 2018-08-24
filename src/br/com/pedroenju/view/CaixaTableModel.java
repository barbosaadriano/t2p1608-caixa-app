package br.com.pedroenju.view;

import br.com.pedroenju.model.Caixa;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class CaixaTableModel extends AbstractTableModel {

    private ArrayList<Caixa> dados;
    private String[] colunas = {"Data", "Saldo Inicial", "Entradas", "Saídas", "Saldo Final", "Status"};

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

        Caixa c = dados.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return c.getData();
            case 1:
                return c.getSaldoInicial();
            case 2:
                return c.getEntradas();
            case 3:
                return c.getSaidas();
            case 4:
                return c.getSaldoFinal();
            case 5:
                return c.getStatus();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    
    
}
