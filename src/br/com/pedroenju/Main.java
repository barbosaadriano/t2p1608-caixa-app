package br.com.pedroenju;

import br.com.pedroenju.dao.CaixaDao;
import br.com.pedroenju.view.CaixaTableModel;
import br.com.pedroenju.view.ListViewCaixa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Main implements ActionListener {

    public static void main(String[] args) {
        new Main().rodar();
    }

    public void rodar() {

        Properties config = new Properties();
        config.put("user", "root");
        config.put("password", "enju");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn
                    = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/singleton",
                            config
                    );
            CaixaDao cd = new CaixaDao((com.mysql.jdbc.Connection) conn);
            cd.createtable();

            ListViewCaixa lvc = new ListViewCaixa(this);
            
            CaixaTableModel ctm = new CaixaTableModel(cd.getAll(""));
            
            lvc.getTabela().setModel(ctm);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

}
