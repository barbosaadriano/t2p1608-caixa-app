package br.com.erica.view;

import br.com.erica.model.Caixas;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Erica
 */
public class CaixaEdView extends JFrame {

    JTextField txt1, txt2, txt3, txt4, txt5, txt6;
    JLabel lb1, lb2, lb3, lb4, lb5, lb6;
    JButton btn;
    Caixas c;
    
        public CaixaEdView() throws HeadlessException {
        super("Caixa Edição");
        
        init();
         
        this.pack();
        
                
    }

    public Caixas getC() {
        return c;
    }

    public void setC(Caixas c) {
        this.c = c;
        this.txt1.setText(c.getData().toString());
        this.txt2.setText(Double.toString(c.getSaldoInicial()));//convertendo double para string
        this.txt3.setText(Double.toString(c.getEntradas()));
        this.txt4.setText(Double.toString(c.getSaidas()));
        this.txt5.setText(Double.toString(c.getSaldoFinal()));
        this.txt6.setText(c.getStatus().toString());
    
        
        
    }
    
    private void init (){
        this.setLayout(new BorderLayout());
        
        JPanel painel1 = new JPanel(new FlowLayout());
        painel1.setBorder(new TitledBorder(""));
        this.add(painel1, BorderLayout.CENTER);
        
        this.lb1 = new JLabel();
        this.lb1.setText("Data");
        painel1.add (lb1);
                
        this.txt1 = new JTextField();
        this.txt1.setPreferredSize(new Dimension(200, 50));
        painel1.add (txt1);
        
        this.lb2 = new JLabel();
        this.lb2.setText("Saldo Inicial");
        painel1.add (lb2);
                
        this.txt2 = new JTextField();
        this.txt2.setPreferredSize(new Dimension(200, 50));
        painel1.add (txt2);
        
        this.lb3 = new JLabel();
        this.lb3.setText("Entradas");
        painel1.add (lb3);
                
        this.txt3 = new JTextField();
        this.txt3.setPreferredSize(new Dimension(200, 50));
        painel1.add (txt3);
        
        this.lb4 = new JLabel();
        this.lb4.setText("Saidas");
        painel1.add (lb4);
                
        this.txt4 = new JTextField();
        this.txt4.setPreferredSize(new Dimension(200, 50));
        painel1.add (txt4);
        
        this.lb5 = new JLabel();
        this.lb5.setText("Saldo Final");
        painel1.add (lb5);
                
        this.txt5 = new JTextField();
        this.txt5.setPreferredSize(new Dimension(200, 50));
        painel1.add (txt5);
        
        this.lb6 = new JLabel();
        this.lb6.setText("Status");
        painel1.add (lb6);
                
        this.txt6 = new JTextField();
        this.txt6.setPreferredSize(new Dimension(200, 50));
        painel1.add (txt6);
        
        btn = new JButton("Salvar");
        painel1.add(btn);
        
    }
    
}
