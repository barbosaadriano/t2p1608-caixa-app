/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rff.view;
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

/**
 *
 * @author thiag
 */
public class ListViewCaixa extends JFrame  {
    
    
    JTable tabela;
    JTextField pesquisa;
    JButton btnPesquisar, btnAbrir;
    
    JScrollPane pnScroll;
    JPanel pnControles;
    ActionListener al; 

    public ListViewCaixa(ActionListener al) throws HeadlessException {
        super("Lista de caixas");
        this.al = al;
        init();
        this.setLocationRelativeTo(null);
    }

    private void init() {
        this.setLayout(new BorderLayout());
        pnControles = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.add(pnControles,BorderLayout.NORTH);
        pnScroll = new JScrollPane();
        this.add(pnScroll,BorderLayout.CENTER);
        
        pnControles.add(new JLabel("Pesquisar:"));
        pesquisa = new JTextField();
        pesquisa.setPreferredSize(new Dimension(300,28));
        pnControles.add(pesquisa);
        btnPesquisar = new JButton("pesquisar");
        btnPesquisar.setActionCommand("caixa.search");
        btnAbrir = new JButton("Abrir Caixa");
        btnAbrir.setActionCommand("caixa.abrir");
        btnAbrir.addActionListener(al);
        btnPesquisar.addActionListener(al);
        pnControles.add(btnPesquisar);
        pnControles.add(btnAbrir);
        tabela = new JTable();
        pnScroll.setViewportView(tabela);
        this.pack();
    }

    public JTable getTabela() {
        return tabela;
    }

    public JTextField getPesquisa() {
        return pesquisa;
    }
   
    
    
}

