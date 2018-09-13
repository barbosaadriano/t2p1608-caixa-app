/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rff;

import br.com.rff.dao.CaixaDao;
import br.com.rff.view.CaixaTableModel;
import br.com.rff.view.ListViewCaixa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import sun.applet.Main;

/**
 *
 * @author refra
 */
public class CaixaPrincipal implements ActionListener {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       new CaixaPrincipal().rodar();
    }
    
    public void rodar(){
         Properties config = new Properties();
        config.put("user", "root");
        config.put("password", "");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn
                    = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/singleton",
                            config
                    );
            
            CaixaDao cd 
                    = new CaixaDao((com.mysql.jdbc.Connection) conn);
           
            ListViewCaixa lvc = new ListViewCaixa(this);
            lvc.setVisible(true);
            
            CaixaTableModel meuModel = new CaixaTableModel(cd.getAll(""));
                        
            lvc.getTabela().setModel(meuModel);
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
}