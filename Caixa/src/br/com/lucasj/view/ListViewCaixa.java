package br.com.lucasj.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lukas
 */
public class ListViewCaixa extends JFrame implements ActionListener {

    JTextField edPesquisa;
    JTable tbTabela;

    JPanel panelTop, panelBot;
    JLabel lbPesquisar;
    JButton btListar, btAbrir;
    DefaultTableModel dfm;
    
    ActionListener  al;

    public ListViewCaixa(ActionListener al) throws HeadlessException {
        super();
        this.al = al;
        this.setTitle("Lista de caixa");
        this.setSize(600, 500);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        drawComponents();
        //After all
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void drawComponents() {
        Dimension tamanhoLabel = new Dimension(120, 20);
        Dimension tamanhoTexto = new Dimension(130, 20);
        dfm = new DefaultTableModel(new Object[]{"Média"}, 70);
        lbPesquisar = new JLabel("Pesquisar");
        lbPesquisar.setPreferredSize(tamanhoLabel);
        
        edPesquisa = new JTextField();
        edPesquisa.setPreferredSize(tamanhoTexto);
        
        btListar = new JButton("Listar");
        btListar.setActionCommand("pesquisar");
        btAbrir = new JButton("Abrir");
        btAbrir.setActionCommand("caixa.abrir");
        
        btAbrir.addActionListener(al);
        btListar.addActionListener(al);
        
        panelTop = new JPanel(new FlowLayout());
        panelBot = new JPanel(new BorderLayout());
        tbTabela = new JTable(dfm);
        this.add(panelTop, BorderLayout.NORTH);
        this.add(panelBot, BorderLayout.SOUTH);
        panelBot.add(tbTabela);
        panelTop.add(lbPesquisar);
        panelTop.add(edPesquisa);
        panelTop.add(btListar);
        panelTop.add(btAbrir);

        JScrollPane rolagem = new JScrollPane(tbTabela);

        rolagem.setPreferredSize(new Dimension(200, 50));
        add(rolagem);

    }

    public JTextField getEdPesquisa() {
        return edPesquisa;
    }

    public JTable getTbTabela() {
        return tbTabela;
    }
    
    

}
