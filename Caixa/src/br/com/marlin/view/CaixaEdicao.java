/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marlin.view;

import com.sun.javafx.scene.control.skin.LabeledText;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import sun.net.ExtendedOptionsImpl;

/**
 *
 * @author Marlon
 */
public class CaixaEdicao extends JFrame {
    
       ActionListener al;
      public CaixaEdicao(ActionListener al) throws HeadlessException {
        super("Caixa");
        this.al = al;
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.criaPaineis();
        this.setVisible(true);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
      }
    
      
    private void criaPaineis() {
        criaPainelSuperior();
        criaPainelCentral();
        criaPainelInferior();
       
    }
    
    private void criaPainelCentral() {
        JPanel centro = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.add(centro, BorderLayout.CENTER);
        JPanel esquerda = new JPanel(new GridLayout(0,1));
        centro.add(esquerda);
        JPanel direita = new JPanel(new GridLayout(0,1));
        centro.add(direita);
        
        JLabel ldata = new JLabel("Data: ");
        ldata.setPreferredSize(new Dimension(20, 23));
        esquerda.add(ldata);
        
        TextField data = new TextField();
        data.setPreferredSize(new Dimension(200, 23));
        direita.add(data);
        
        JLabel lsaldoini = new JLabel("Saldo Inicial: ");
        esquerda.add(lsaldoini);
        
        TextField saldoini = new TextField();
        direita.add(saldoini);
        
        JLabel lentrada = new JLabel("Entradas: ");
        esquerda.add(lentrada);
        
        TextField entrada = new TextField();
        direita.add(entrada);
        
        JLabel lsaidas = new JLabel("Saídas: ");
        esquerda.add(lsaidas);
        
        TextField saida = new TextField();
        direita.add(saida);
        
        JLabel lsaldofin = new JLabel("Saldo Final: ");
        esquerda.add(lsaldofin);
        
        TextField saldofin = new TextField();
        direita.add(saldofin);
        
        JLabel lstatus = new JLabel("Status: ");
        esquerda.add(lstatus);
        
        TextField status = new TextField();
        direita.add(status);
     
    }

    private void criaPainelInferior() {
        JPanel sul = new JPanel(new GridLayout(0,3));
        this.add(sul, BorderLayout.SOUTH);
        
        JButton btnsalvar = new JButton("Salvar");
        sul.add(btnsalvar);
        
        JButton btneditar = new JButton("Editar");
        sul.add(btneditar);
        
        JButton btndel = new JButton("Excluir");
        sul.add(btndel);
    }

    private void criaPainelSuperior() {
        JPanel norte = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.add(norte, BorderLayout.NORTH);
        
        JLabel titulo = new JLabel("CONTROLE DE CAIXA");
        norte.setBackground(Color.RED);
        titulo.setForeground(Color.white);
        Font f = new Font("SansSerif", Font.BOLD, 20);
        titulo.setFont(f);
        norte.add(titulo);
    }


    
}
