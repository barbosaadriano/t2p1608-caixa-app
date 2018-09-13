/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thiagohc.view;


import br.com.thiagohc.model.Caixa;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author thiag
 */
public class CaixaEdicao extends JFrame implements ActionListener{
    JLabel lbdata, lbsi, lbentradas, lbsaidas, lbsf, lbstatus;
    JTextField txtdata, txtsi, txtent, txtsai, txtsf, txtstatus;
    JButton Salvar;
    private Caixa cx;
    

    public Caixa getCx() {
        return cx;
    }

    public void setCx(Caixa cx) {
        this.cx = cx;
        this.preencherCampos();
    }
    
    public void preencherCampos () {
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        txtdata.setText(sdf.format(this.cx.getData()));
        txtsi.setText(Double.toString(this.cx.getSaldoInicial()));
        txtent.setText(Double.toString(this.cx.getEntradas()));
        txtsai.setText(Double.toString(this.cx.getSaidas()));
        txtsf.setText(Double.toString(this.cx.getSaldoFinal()));
        txtstatus.setText(this.cx.getStatus().toString());
        
        
        
    }
    
    public CaixaEdicao() throws HeadlessException{
        super("Caixa Edição");
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.TelaPadrao();
        this.setVisible(true);
        
        
    }

   


    private void TelaPadrao() {
        JPanel painelcampos = new JPanel(new GridLayout(0,2));
        JPanel painelbotoes = new JPanel(new FlowLayout());
        
        this.setLayout(new BorderLayout());
        this.lbdata = new JLabel();
        this.add(painelcampos, BorderLayout.CENTER);
        
        lbdata.setText("Data");
        painelcampos.add(lbdata);
        
        this.txtdata = new JTextField();
        painelcampos.add(txtdata);
        
        this.lbsi = new JLabel();
        lbsi.setText("Saldo Inicial");
        painelcampos.add(lbsi);
        
        this.txtsi = new JTextField();
        painelcampos.add(txtsi);
        
        this.lbentradas = new JLabel();
        lbentradas.setText("Entradas");
        painelcampos.add(lbentradas);
        
        this.txtent = new JTextField();
        painelcampos.add(txtent);
        
        this.lbsaidas = new JLabel();
        lbsaidas.setText("Saidas");
        painelcampos.add(lbsaidas);
        
        this.txtsai = new JTextField();
        painelcampos.add(txtsai);
        
        this.lbsf = new JLabel();
        lbsf.setText("Saldo Final");
        painelcampos.add(lbsf);
        
        this.txtsf = new JTextField();
        painelcampos.add(txtsf);
        
        this.lbstatus = new JLabel();
        lbstatus.setText("Status");
        painelcampos.add(lbstatus);
        
        this.txtstatus = new JTextField();
        painelcampos.add(txtstatus);
        
        this.Salvar = new JButton("Salvar");
        this.Salvar.setActionCommand("Salvar");
        painelbotoes.add(Salvar);
        this.add(painelbotoes,BorderLayout.SOUTH);
        
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
