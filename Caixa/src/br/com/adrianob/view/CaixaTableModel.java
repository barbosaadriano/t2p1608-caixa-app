package br.com.adrianob.view;

import br.com.adrianob.model.Caixa;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author drink
 */
public class CaixaTableModel extends AbstractTableModel {

    private ArrayList<Caixa> dados;
    private String[] colunas = {"Data", "Saldo inicial", "Entradas", "Saídas", "Saldo", "Situação"};

    public CaixaTableModel(ArrayList<Caixa> dados) {
        super();
        this.dados = dados;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public String getColumnName(int column) {
        return this.colunas[column];
    }

    @Override
    public int getRowCount() {
        return this.dados.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Caixa get = this.dados.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        switch (columnIndex) {
            case 0:
                return sdf.format(get.getData());
            case 1:
                return get.getSaldoInicial();
            case 2:
                return get.getEntradas();
            case 3:
                return get.getSaidas();
            case 4:
                return get.getSaldoFinal();
            case 5:
                return get.getStatus().toString();
        }
        return null;
    }
            
}
