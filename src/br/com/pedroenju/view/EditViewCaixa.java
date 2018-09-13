package br.com.pedroenju.view;

import br.com.pedroenju.model.Caixa;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditViewCaixa extends JFrame {
    
    private Caixa c;
    private JTextField data, saldoInicial, entradas, saidas, saldoFinal, status;
    private ActionListener al;
    private SimpleDateFormat sdf;
    
    public EditViewCaixa(ActionListener al) throws HeadlessException {
        
        super("Caixa - Editor");
        this.sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.al = al;
        init();
        showWindow();
        
        
    }
    
    private void init() {
        
        this.setLayout(new BorderLayout());
        JPanel pn_north = new JPanel(new FlowLayout());
        JPanel pn_center = new JPanel();
        JPanel pn_centralMain = new JPanel(new BorderLayout());
        JPanel pn_centralL = new JPanel(new GridLayout(0, 1, 0, 4));
        JPanel pn_centralR = new JPanel(new GridLayout(0, 1, 0, 4));
        JPanel pn_south = new JPanel(new FlowLayout());
        
        Font font_lb = new Font("Tahoma", Font.BOLD, 15);
        
        JLabel lb_head = new JLabel("Caixa");
        JLabel lb_data = new JLabel("Data.:");
        JLabel lb_saldoInicial = new JLabel("Saldo Inicial.:  ");
        JLabel lb_entradas = new JLabel("Entradas.:");
        JLabel lb_saidas = new JLabel("Saidas.:");
        JLabel lb_saldoFinal = new JLabel("Saldo Final.:");
        JLabel lb_status = new JLabel("Status.:");
        
        lb_head.setFont(new Font("Tahoma", Font.BOLD, 35));
        lb_data.setFont(font_lb);
        lb_saldoInicial.setFont(font_lb);
        lb_entradas.setFont(font_lb);
        lb_saidas.setFont(font_lb);
        lb_saldoFinal.setFont(font_lb);
        lb_status.setFont(font_lb);
        
        
        JButton btn_salvar = new JButton("  Salvar  ");
        JButton btn_cancel = new JButton("Cancelar");
        btn_salvar.setActionCommand("caixa.salvar");
        btn_salvar.addActionListener(this.al);
        btn_cancel.setActionCommand("caixa.cancel");
        btn_cancel.addActionListener(this.al);
        
        Dimension d_field = new Dimension(200, 20);
        
        this.data = new JTextField();
        this.saldoInicial = new JTextField();
        this.entradas = new JTextField();
        this.saidas = new JTextField();
        this.saldoFinal = new JTextField();
        this.status = new JTextField();
        
        this.data.setPreferredSize(d_field);
        this.saldoInicial.setPreferredSize(d_field);
        this.entradas.setPreferredSize(d_field);
        this.saidas.setPreferredSize(d_field);
        this.saldoFinal.setPreferredSize(d_field);
        this.status.setPreferredSize(d_field);
        
        
        this.add(pn_north, BorderLayout.NORTH);
        pn_center.add(pn_centralMain);
        this.add(pn_center, BorderLayout.CENTER);
        this.add(pn_south, BorderLayout.SOUTH);
        
        
        pn_north.add(lb_head);
        
        pn_centralMain.add(pn_centralL, BorderLayout.WEST);
        pn_centralMain.add(pn_centralR, BorderLayout.CENTER);
        
        pn_centralL.add(lb_data);
        pn_centralL.add(lb_saldoInicial);
        pn_centralL.add(lb_entradas);
        pn_centralL.add(lb_saidas);
        pn_centralL.add(lb_saldoFinal);
        pn_centralL.add(lb_status);
        
        pn_centralR.add(this.data);
        pn_centralR.add(this.saldoInicial);
        pn_centralR.add(this.entradas);
        pn_centralR.add(this.saidas);
        pn_centralR.add(this.saldoFinal);
        pn_centralR.add(this.status);
        
        pn_south.add(btn_cancel);
        pn_south.add(btn_salvar);
        
        
//        pn_north.setBackground(Color.BLACK);
        lb_head.setForeground(Color.DARK_GRAY);
        this.saldoFinal.setBackground(Color.LIGHT_GRAY);
        this.saldoFinal.setEnabled(false);
    }
    
    private void showWindow() {
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        
    }
    
    private void toCampos() {
        
        this.data.setText(this.sdf.format(this.c.getData()));
        this.saldoInicial.setText(String.valueOf(this.c.getSaldoInicial()));
        this.entradas.setText(String.valueOf(this.c.getEntradas()));
        this.saidas.setText(String.valueOf(this.c.getSaidas()));
        this.saldoFinal.setText(String.valueOf(this.c.getSaldoFinal()));
        this.status.setText(this.c.getStatus().name());
        
    }
    
    public Caixa getCaixa() {
        return c;
    }
    
    public void setCaixa(Caixa c) {
        this.c = c;
        toCampos();
    }
    
}
