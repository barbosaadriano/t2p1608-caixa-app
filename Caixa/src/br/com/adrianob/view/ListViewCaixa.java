package br.com.adrianob.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author drink
 */
public class ListViewCaixa extends JFrame {

    /**
     * Componentes de entrada
     */
    private JTextField searchField;
    private JButton btnSearch, btnOpen;

    //Tabela
    private JTable tabela;

    //containers
    private JPanel pnControles;
    private JScrollPane scroll;
    
    //ActionListener
    ActionListener al;

    public ListViewCaixa(ActionListener al) throws HeadlessException {
        super("Listar Caixas");
        this.al = al;
        init();
        this.setLocationRelativeTo(null);
    }

    private void init() {
        this.setLayout(new BorderLayout());
        pnControles = new JPanel(new FlowLayout(FlowLayout.LEFT));
        scroll = new JScrollPane();
        this.add(pnControles, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.CENTER);
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(150, 28));
        JLabel lblSearch = new JLabel("Localizar");
        pnControles.add(lblSearch);
        pnControles.add(searchField);
        btnSearch = new JButton("Pesquisar");
        btnSearch.setActionCommand("caixa.search");
        btnSearch.addActionListener(al);
        pnControles.add(btnSearch);
        btnOpen = new JButton("Abrir Caixa");
        btnOpen.setActionCommand("caixa.add");
        btnOpen.addActionListener(al);
        pnControles.add(btnOpen);
        tabela = new JTable();
        scroll.setViewportView(tabela);
        this.pack();
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public JTable getTabela() {
        return tabela;
    }


}
