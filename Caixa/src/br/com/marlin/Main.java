package br.com.marlin;

// @author Marlon
import br.com.marlin.dao.CaixaDao;
import br.com.marlin.view.CaixaEdicao;
import br.com.marlin.view.CaixaTableModel;
import br.com.marlin.view.ListViewCaixa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main implements ActionListener {

    public static void main(String[] args) {

        new Main().rodar();
    }

    public void rodar() {
        Properties config = new Properties();
        config.put("user", "root");
        config.put("password", "");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/singleton",
                    config
            );

            CaixaDao cd = new CaixaDao((com.mysql.jdbc.Connection) conn);
            ListViewCaixa lvc = new ListViewCaixa(this);
            CaixaEdicao ce = new CaixaEdicao(this);
            CaixaTableModel ctm = new CaixaTableModel(cd.getAll(""));
            lvc.getTabela().setModel(ctm);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
