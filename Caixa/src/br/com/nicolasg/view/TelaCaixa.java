package br.com.nicolasg.view;

import br.com.nicolas.Main;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.geom.Area;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;

public class TelaCaixa extends JFrame{
    
    public static void main(String[] args) {
       new TelaCaixa();
       
    }
    public TelaCaixa() throws HeadlessException{
        super ("Tela Caixa");
        
        this.setLayout(new BorderLayout());        
        JPanel meuPainel = new JPanel(new GridLayout(0,1));
        meuPainel.setBorder(new TitledBorder("Caixa Edição"));
        this.add(meuPainel, BorderLayout.CENTER);
        
        //SpringLayout spl = new SpringLayout();
        //meuPainel.setLayout(spl);
               
        JLabel lbArea = new JLabel("Data");
        meuPainel.add(lbArea);
        JTextField txArea = new JTextField();
        meuPainel.add(txArea);
        
        JLabel lbArea2 = new JLabel("Saldo Inicial");
        meuPainel.add(lbArea2);
        JTextField txArea2 = new JTextField();
        meuPainel.add(txArea2);
        
        JLabel lbArea3 = new JLabel("Entradas");
        meuPainel.add(lbArea3);
        JTextField txArea3 = new JTextField();
        meuPainel.add(txArea3);
        
        JLabel lbArea4 = new JLabel("Saidas");
        meuPainel.add(lbArea4);
        JTextField txArea4 = new JTextField();
        meuPainel.add(txArea4);
        
        JLabel lbArea5 = new JLabel("Saldo Final");
        meuPainel.add(lbArea5);
        JTextField txArea5 = new JTextField();
        meuPainel.add(txArea5);
        
        JLabel lbArea6 = new JLabel("Status");
        meuPainel.add(lbArea6);
        JTextField txArea6 = new JTextField();
        meuPainel.add(txArea6);
        
        JButton meuBotao = new JButton("Salvar");
        meuPainel.add(meuBotao);
        
        //spl.putConstraint(SpringLayout.WEST, txArea, 15, SpringLayout.EAST, lbArea);

        this.setVisible(true);
        
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
}