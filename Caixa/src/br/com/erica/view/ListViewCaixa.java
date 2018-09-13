package br.com.erica.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Erica
 */
public class ListViewCaixa  extends JFrame {
    
    JLabel lb1;
    JTextField txt1;
    JTable tabel; 
    ActionListener al;
    
    public ListViewCaixa(ActionListener al) throws HeadlessException{
        super("Lista de Caixa");
        this.al = al;
        
        this.setLayout(new BorderLayout());
        
        JPanel meuPainel = new JPanel(new FlowLayout());
        meuPainel.setBorder(new TitledBorder(""));  
        this.add(meuPainel,BorderLayout.NORTH);
        
        this.lb1 = new JLabel();
        this.lb1.setText("Pesquisar");
        meuPainel.add(lb1);
        
        this.txt1 = new JTextField();
        this.txt1.setPreferredSize(new Dimension(300, 20));
        meuPainel.add(txt1);
        
        JButton botao1 = new JButton("Listar");
        botao1.setActionCommand("caixa.search");
        meuPainel.add(botao1);
      
        JButton botao2 = new JButton("Abrir Caixa");
        botao2.setActionCommand("caixa.abrir");
        meuPainel.add(botao2);
        
        botao1.addActionListener(al);
        botao2.addActionListener(al);
        
        JPanel painel2 = new JPanel(new FlowLayout());
        painel2.setBorder(new TitledBorder("  "));
        this.add(painel2, BorderLayout.CENTER);
        
        JScrollPane scroll = new JScrollPane();
        scroll.setPreferredSize(new Dimension(1300, 600));
        painel2.add(scroll);
        this.add(painel2, BorderLayout.CENTER);
        
        tabel = new JTable ();
        scroll.setViewportView(tabel);
        
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JTextField getTxt1() {
        return txt1;
    }

    public JTable getTabel() {
        return tabel;
    }
    
}
