package br.com.adrianob;

import br.com.adrianob.dao.CaixaDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author drink
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Properties config = new Properties();
        config.put("user", "devel");
        config.put("password", "developer");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn
                    = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/singleton",
                            config
                    );
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
