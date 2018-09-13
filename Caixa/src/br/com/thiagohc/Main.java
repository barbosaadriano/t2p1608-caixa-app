/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thiagohc;

import br.com.thiagohc.dao.CaixaDao;
import br.com.thiagohc.model.Caixa;
import br.com.thiagohc.view.CaixaEdicao;
import br.com.thiagohc.view.CaixaTableModel;
import br.com.thiagohc.view.ListViewCaixa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author thiag
 */
public class Main implements ActionListener {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new Main().rodar();

    }

    public void rodar() {
        Properties config = new Properties();
        config.put("user", "root");
        config.put("password", "root");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn
                    = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/singleton",
                            config
                    );
            CaixaDao cd = new CaixaDao((com.mysql.jdbc.Connection) conn);

            ListViewCaixa lvc = new ListViewCaixa(this);
            lvc.setVisible(true);
            
            CaixaTableModel meuModel = new CaixaTableModel(cd.getAll(""));
            
            lvc.getListadecaixa().setModel(meuModel);
            
            CaixaEdicao ce = new CaixaEdicao();
            ce.setVisible(true);
            ArrayList<Caixa> all = cd.getAll("");
            ce.setCx(all.get(1));
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    
}

