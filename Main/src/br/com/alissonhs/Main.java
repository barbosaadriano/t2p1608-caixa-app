/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alissonhs;

import br.com.alissonhs.dao.CaixaDao;
import br.com.alissonhs.view.CaixaTableModel;
import br.com.alissonhs.view.ListViewCaixa;
import br.com.caixa.Caixa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author Alisson H. Silva
 */
public class Main implements ActionListener {

    public static void main(String[] args) {
        new Main().Rodar();
    }

    public void Rodar() {
        Properties config = new Properties();
        config.put("user", "root");
        config.put("password", "root");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn
                    = DriverManager.getConnection(
                            "jdbc:mysql://127.0.0.1:3306/singleton",
                            config
                    );
            CaixaDao cd = new CaixaDao((com.mysql.jdbc.Connection) conn);
            ListViewCaixa lvc = new ListViewCaixa(this);
            lvc.setVisible(true);

            CaixaTableModel meuModel = new CaixaTableModel(cd.getAll(""));
            lvc.getTbInfo().setModel(meuModel);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
