package br.com.lucasj;

import br.com.lucasj.dao.CaixaDao;
import br.com.lucasj.model.Caixa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.Properties;

public class Main {

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
