/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thalyscalory;

import br.com.thalyscalory.Model.Caixa;
import br.com.thalyscalory.dao.CaixaDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author Usuario
 */
public class CaixaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
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
            cd.createTable();
            
            Caixa c = new Caixa();
            c.setSaldoInicial(100);
            cd.salvar(c);
            
            c.setEntradas(50);
            cd.salvar(c);
            
            Caixa caixa = cd.getCaixa(new Date());
            
            System.out.println(caixa.getData());
            System.out.println(caixa.getSaldoInicial());
            System.out.println(caixa.getStatus());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
