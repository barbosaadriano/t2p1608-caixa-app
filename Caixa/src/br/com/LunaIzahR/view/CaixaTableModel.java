package br.com.LunaIzahR.view;

import br.com.adrianob.model.Caixa;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class CaixaTableModel extends AbstractTableModel{

    ArrayList<Caixa> dados; 
    String[] colunas = {"Data","Saldo Inicial", "Entradas", "Saídas", 
    "Saldo Final", "Status"}; 

    public CaixaTableModel(ArrayList<Caixa> dados) {
        this.dados = dados;
    }
    
    
    
    @Override
    public int getRowCount() {
        return dados.size(); // metodo ou construtor q passa parametros por isso de (). 
    }

    @Override
    public int getColumnCount() {
        return colunas.length; // atributo nao passa paramentro por isso n precisa de (); 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Caixa cx = dados.get(rowIndex);
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
