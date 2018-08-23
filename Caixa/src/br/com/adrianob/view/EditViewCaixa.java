package br.com.adrianob.view;

import br.com.adrianob.model.Caixa;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author drink
 */
public class EditViewCaixa extends JFrame implements FocusListener{

    //controles
    JButton btnCancelar, btnSalvar, btnFechar;
    //campos
    JTextField txtData, txtSaldoInicial,
            txtEntradas, txtSaidas, txtSaldoFinal;
    //containers
    JPanel pnControles, pnCampos;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    
    public EditViewCaixa(ActionListener al) throws HeadlessException {
        super("Edição de caixa");
        init(al);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
    
    private void init(ActionListener al) {
        this.setLayout(new BorderLayout());
        pnControles = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        this.add(pnControles,BorderLayout.SOUTH);
        pnCampos = new JPanel(new GridLayout(0, 2,5,5));
        this.add(pnCampos,BorderLayout.CENTER);
        btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(al);
        btnSalvar.setActionCommand("caixa.salvar");
        btnFechar = new JButton("Fechar caixa");
        btnFechar.setActionCommand("caixa.fechar");
        btnFechar.addActionListener(al);
        btnCancelar = new JButton("Voltar");
        btnCancelar.setActionCommand("caixa.voltar");
        btnCancelar.addActionListener(al);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        pnControles.add(btnSalvar);
        pnControles.add(btnFechar);
        pnControles.add(btnCancelar);
        
        txtData = new JTextField();
        txtData.setEditable(false);
        txtSaldoInicial = new JTextField();
        txtEntradas = new JTextField();
        txtSaidas = new JTextField();
        txtSaldoInicial.addFocusListener(this);
        txtEntradas.addFocusListener(this);
        txtSaidas.addFocusListener(this);
        txtSaldoFinal = new JTextField();
        txtSaldoFinal.setEditable(false);
        
        pnCampos.add(new JLabel("Data"));
        pnCampos.add(txtData);
        pnCampos.add(new JLabel("Saldo inicial"));
        pnCampos.add(txtSaldoInicial);
        pnCampos.add(new JLabel("Entradas"));
        pnCampos.add(txtEntradas);
        pnCampos.add(new JLabel("Saídas"));
        pnCampos.add(txtSaidas);
        pnCampos.add(new JLabel("Saldo Final"));
        pnCampos.add(txtSaldoFinal);
        this.pack();
    }
    
    public void setDataFromCaixa(Caixa c) {
        this.txtData.setText(sdf.format(c.getData()));
        this.txtSaldoInicial.setText(Double.toString(c.getSaldoInicial()));
        this.txtEntradas.setText(Double.toString(c.getEntradas()));
        this.txtSaidas.setText(Double.toString(c.getSaidas()));
        this.txtSaldoFinal.setText(Double.toString(c.getSaldoFinal()));
    }
    public Caixa getCaixaFromData() {
        Caixa c = new Caixa();
        try {
            c.setData(sdf.parse(txtData.getText()));
            c.setSaldoInicial(Double.parseDouble(txtSaldoInicial.getText()));
            c.setEntradas(Double.parseDouble(txtEntradas.getText()));
            c.setSaidas(Double.parseDouble(txtSaidas.getText()));
            c.setSaldoFinal(Double.parseDouble(txtSaldoFinal.getText()));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        return c;
    }

    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        calculaValores();
    }

    private void calculaValores() {
        Caixa caixa = getCaixaFromData();
        caixa.calculaSaldo();
        this.setDataFromCaixa(caixa);
    }
}
