package br.com.pedroenju.view;

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
import javax.swing.table.DefaultTableModel;

public class ListViewCaixa extends JFrame {

    //Panel North
    private JPanel panelNorth;
    private JLabel search;
    private JTextField pesquise;
    private JButton btnListar, btnAbrir;
    //Panel South
    private JTable tabela;
    private JScrollPane scroll;
    //Action Listener
    private ActionListener al;

    public ListViewCaixa(ActionListener al) throws HeadlessException {

        super("Lista de Caixa");
        this.al = al;
        init();
        telaShow();

    }

    private void pNorth() {
        this.panelNorth = new JPanel(new FlowLayout());
        this.add(this.panelNorth, BorderLayout.NORTH);

        this.search = new JLabel("Pesquise");
        this.pesquise = new JTextField();
        this.pesquise.setPreferredSize(new Dimension(370, 25));
        this.btnListar = new JButton("Listar");
        this.btnListar.setActionCommand("caixa.listar");
        this.btnListar.addActionListener(this.al);
        this.btnAbrir = new JButton("Abrir Caixa");
        this.btnAbrir.setActionCommand("caixa.abrir");
        this.btnListar.addActionListener(this.al);

        this.panelNorth.add(this.search);
        this.panelNorth.add(this.pesquise);
        this.panelNorth.add(this.btnListar);
        this.panelNorth.add(this.btnAbrir);

    }

    private void pSouth() {

        this.tabela = new JTable();
        this.scroll = new JScrollPane(this.tabela);

        this.add(this.scroll, BorderLayout.SOUTH);
    }

    private void telaShow() {

        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    private void init() {

        this.setLayout(new BorderLayout());
        pNorth();
        pSouth();
    }

    public JTextField getPesquise() {
        return pesquise;
    }

    public JTable getTabela() {
        return tabela;
    }

}
