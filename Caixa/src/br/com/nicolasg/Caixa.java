package br.com.nicolasg;

import br.com.nicolasg.dao.CaixaDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.Properties;

public class Caixa {

    public static void main(String[] args) {
        Properties config = new Properties();
        config.put("user", "root");
        config.put("password", "");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn
                    = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/singleton",config);
            CaixaDao cd = new CaixaDao((com.mysql.jdbc.Connection) conn);
            cd.createTable();
            
            br.com.nicolasg.model.Caixa c = new br.com.nicolasg.model.Caixa();
            c.setSaldoInicial(100);
            
            cd.salvar(c);
            
            c.setEntradas(50);
            
            cd.salvar(c);
            
            br.com.nicolasg.model.Caixa caixa = cd.getCaixa(new Date());
            System.out.println(caixa.getData());
            System.out.println(caixa.getSaldoInicial());
            System.out.println(caixa.getStatus());            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
