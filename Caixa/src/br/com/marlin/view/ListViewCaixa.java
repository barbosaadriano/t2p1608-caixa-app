/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marlin.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Marlon
 */
public class ListViewCaixa extends JFrame {

    JTable tabela;
    JTextField pesquisar;


    public JTable getTabela() {
        return tabela;
    }

    public JTextField getPesquisar() {
        return pesquisar;
    }

    ActionListener al;
    
    
    public ListViewCaixa(ActionListener al) throws HeadlessException {
        super("Lista de Caixa");
        this.al = al;
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.criaPaineis();
        this.setVisible(true);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setResizable(false);
    }

    private void criaPaineis() {
        criaPainelCentral();
        criaPainelSuperior();
    }

    private void criaPainelCentral() {
        JScrollPane barra = new JScrollPane();
        this.add(barra);
        tabela = new JTable();
        barra.setViewportView(tabela);
    }

    private void criaPainelSuperior() {
        JPanel topo = new JPanel(new FlowLayout());
        this.add(topo, BorderLayout.NORTH);
        JLabel label = new JLabel("Pesquisar:");
        topo.add(label);
        pesquisar = new JTextField();
        pesquisar.setPreferredSize(new Dimension(800, 25));
        topo.add(pesquisar);
        JButton btnlistar = new JButton("Listar");
        btnlistar.setActionCommand("caixa.listar");
        JButton btnabrir = new JButton("Abrir Caixa");
        btnabrir.setActionCommand("caixa.abrir");
        btnabrir.addActionListener(al);
        btnlistar.addActionListener(al);
        topo.add(btnlistar);
        topo.add(btnabrir);
    }
}
