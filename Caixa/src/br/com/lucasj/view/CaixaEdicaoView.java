package br.com.lucasj.view;

import br.com.lucasj.model.Caixa;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class CaixaEdicaoView extends JFrame {

    private Caixa c;
    private JLabel lbData, lbSaldoInical, lbEntradas, lbSaidas, lbSaldoFinal, lbStatus;
    private JTextField edData, edSaldoInicial, edEntradas, edSaidas, edSaldoFinal, edStatus;
    private JPanel panel;
    private JButton myButton;
    private ActionListener al;
    
    public CaixaEdicaoView(ActionListener al) {
        super("Edição de caixa!");
        this.al = al;
        init();
    }

    private void init() {
        panel = new JPanel(new GridLayout(0,2));
        lbData = new JLabel("Data");
        lbSaldoInical = new JLabel("Saldo Inicial");
        lbEntradas = new JLabel("Entradas");
        lbSaidas = new JLabel("Saidas");
        lbSaldoFinal = new JLabel("Saldo Final");
        lbStatus = new JLabel("Status");
        Dimension edDimension = new Dimension(200, 50);
        edData = new JTextField();
        edData.setPreferredSize(edDimension);

        edSaldoInicial = new JTextField();
        edSaldoInicial.setPreferredSize(edDimension);

        edEntradas = new JTextField();
        edEntradas.setPreferredSize(edDimension);

        edSaidas = new JTextField();
        edSaidas.setPreferredSize(edDimension);

        edSaldoFinal = new JTextField();
        edSaldoFinal.setPreferredSize(edDimension);

        edStatus = new JTextField();
        edStatus.setPreferredSize(edDimension);
        myButton = new JButton("Salvar");
        myButton.addActionListener(al);
        myButton.setActionCommand("caixa.salvar");

        this.add(panel);
        panel.add(lbData);
        panel.add(edData);
        panel.add(lbSaldoInical);
        panel.add(edSaldoInicial);
        panel.add(lbEntradas);
        panel.add(edEntradas);
        panel.add(lbSaidas);
        panel.add(edSaidas);
        panel.add(lbSaldoFinal);
        panel.add(edSaldoFinal);
        panel.add(lbStatus);
        panel.add(edStatus);
        panel.add(myButton);
        
        edData.setText(c.getData().toString());
        edSaldoInicial.setText( Double.toString(c.getSaldoInicial()) );
        edSaldoFinal.setText(Double.toString(c.getSaldoFinal()));
        edEntradas.setText(Double.toString(c.getEntradas()));
        edSaidas.setText(Double.toString(c.getSaidas()));
        edStatus.setText(c.getStatus().name());
        
        this.setVisible(true);
    }

    public void setC(Caixa c) {
        this.c = c;
    }

    public Caixa getC() {
        return c;
    }

}
