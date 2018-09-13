package br.com.alissonhs.view;

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

public class ListViewCaixa extends JFrame {

    JTable tbInfo = new JTable();
    JButton btListar = new JButton("Listar");

    JButton btAbrir = new JButton("Abrir");

    JTextField edPesquisa = new JTextField();
    ActionListener al;

    public ListViewCaixa(ActionListener al) throws HeadlessException {
        super("Lista de Caixa!");
        this.al = al;

        this.setLayout(new BorderLayout());
        JPanel panelCaixa = new JPanel();
        this.add(panelCaixa);
        Dimension dimensaoCaixa = new Dimension(200, 150);
        JPanel panelBotoes = new JPanel();
        this.add(panelBotoes, BorderLayout.NORTH);
        JPanel panelInfo = new JPanel();
        this.add(panelInfo);

        JLabel lbPesquisa = new JLabel("Pesquisar");

        edPesquisa.setPreferredSize(new Dimension(370, 25));

        btListar.setPreferredSize(new Dimension(150, 25));
        btListar.setActionCommand("caixa.search");
        btListar.addActionListener(al);
        btAbrir.setPreferredSize(new Dimension(150, 25));
        btAbrir.setActionCommand("caixa.open");
        btAbrir.addActionListener(al);
        JScrollPane scrollPane = new JScrollPane(tbInfo);
        scrollPane.setPreferredSize(new Dimension(750, 500));

        panelBotoes.add(lbPesquisa);
        panelBotoes.add(edPesquisa);
        panelBotoes.add(btListar);
        panelBotoes.add(btAbrir);
        panelInfo.add(scrollPane);

        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public JTable getTbInfo() {
        return tbInfo;
    }

    public JTextField getEdPesquisa() {
        return edPesquisa;
    }

}
