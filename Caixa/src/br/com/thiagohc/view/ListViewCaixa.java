/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thiagohc.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author thiag
 */
public class ListViewCaixa extends JFrame {
    JLabel label1;
    JTextField txt1;
    JButton Listar;
    JButton AbrirCaixa;
    JTable listadecaixa;
    ActionListener al;
    
    public ListViewCaixa (ActionListener al) throws HeadlessException{
        super("Lista De Caixa");
        this.al = al;
        this.setSize(475, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.ListaDeCaixa();
        this.setVisible(true);
        
    }

    public ListViewCaixa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private void ListaDeCaixa() {
        this.setLayout(new FlowLayout());
        Dimension tamanhoLabel = new Dimension(60,20);
        this.label1 = new JLabel();
        label1.setText("Pesquisar");
        label1.setPreferredSize(tamanhoLabel);
        this.add(label1);
        
        Dimension tamanhoCampo = new Dimension(200,20);
        
        this.txt1 = new JTextField();
        this.txt1.setPreferredSize(tamanhoCampo);
        this.add(txt1);
        
        this.Listar = new JButton("Listar");
        this.Listar.setActionCommand("listar.caixa");
        Listar.addActionListener(al);
        this.add(Listar);
        
        this.AbrirCaixa = new JButton("Abrir Caixa");
        this.AbrirCaixa.setActionCommand("abrircaixa.caixa");
        AbrirCaixa.addActionListener(al);
        this.add(AbrirCaixa);
        
        listadecaixa = new JTable();
        JScrollPane painelScroll = new JScrollPane(listadecaixa);
        add(painelScroll);
        
        
        
        
    }

    public JTextField getTxt1() {
        return txt1;
    }

    public JTable getListadecaixa() {
        return listadecaixa;
    }
    
    
    
}

