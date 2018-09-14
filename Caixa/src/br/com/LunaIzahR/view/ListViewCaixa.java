package br.com.LunaIzahR.view;


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

public class ListViewCaixa extends JFrame{
    JTable tabela;
    JLabel lb1; 
    JTextField txt1; 
    ActionListener aL; 

    public ListViewCaixa(ActionListener al) throws HeadlessException{
        
        super("Lista de Caixa"); 
        
        this.aL = al; 
        
        
        this.setLayout(new BorderLayout());
        
        JPanel meupainel = new JPanel(new FlowLayout()); 
        meupainel.setBorder(new TitledBorder("Botões"));  
        this.add(meupainel, BorderLayout.NORTH); 
        
        this.lb1 = new JLabel(); 
        this.lb1.setText("Pesquisar");
        meupainel.add(lb1); 
        
        this.txt1= new JTextField(); 
        this.txt1.setPreferredSize(new Dimension(300, 30));
        meupainel.add(txt1); 
        
        JButton meubotao = new JButton("Listar"); 
        meubotao.setActionCommand("caixa.listener");
        meupainel.add(meubotao);
        
         JButton meuoutrobotao = new JButton("Abrir Caixa"); 
         meuoutrobotao.setActionCommand("caixa.open");
        meupainel.add(meuoutrobotao);
        
        meubotao.addActionListener(aL);
        meuoutrobotao.addActionListener(aL);
        
        JPanel outropainel = new JPanel(); 
        outropainel.setBorder(new TitledBorder(" "));
        this.add(outropainel, BorderLayout.CENTER); 
        
       
        
        JScrollPane scroll = new JScrollPane();
        scroll.setPreferredSize(new Dimension(1250, 650));
        outropainel.add(scroll);
        this.add(outropainel, BorderLayout.CENTER);
        
        tabela = new JTable(); 
        scroll.setViewportView(tabela); 
        
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
    }

    public JTable getTabela() {
        return tabela;
    }

    public JTextField getTxt1() {
        return txt1;
    }
    
    
    
}
