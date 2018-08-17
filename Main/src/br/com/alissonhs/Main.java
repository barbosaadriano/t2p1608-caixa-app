/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alissonhs;

import br.com.alissonhs.dao.CaixaDao;
import br.com.caixa.Caixa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author Alisson H. Silva
 */
public class Main {
    
    public static void main(String[] args) {
        
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
            cd.createTable();
            Caixa c = new Caixa();
            c.setSaldoInicial(100);
            cd.Salvar(c);
            c.setEntradas(50);
            cd.Salvar(c);
            cd.getCaixa(new Date());
            Caixa caixa = cd.getCaixa(new Date());
            System.out.println(caixa.getDate());
            System.out.println(caixa.getSaldoInicial());
            System.out.println(caixa.getStatus());
            System.out.println(c);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
