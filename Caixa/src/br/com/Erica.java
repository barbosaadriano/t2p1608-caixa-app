
package br.com;

import br.com.erica.dao.CaixaDao;
import br.com.erica.model.Caixas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author Erica
 */
public class Erica {

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
            
            Caixas c = new Caixas();
            c.setSaldoInicial(100);
            cd.salvar(c);
            
            c.setEntradas(50);
            cd.salvar(c);
            
            Caixas caixa = cd.getCaixas(new Date());
            System.out.println(caixa.getData());
            System.out.println(caixa.getSaldoInicial());
            System.out.println(caixa.getStatus());
                   
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
