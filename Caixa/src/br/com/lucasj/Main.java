package br.com.lucasj;

import br.com.lucasj.dao.CaixaDao;
import br.com.lucasj.model.Caixa;
import br.com.lucasj.view.CaixaEdicaoView;
import br.com.lucasj.view.CaixaTableModel;
import br.com.lucasj.view.ListViewCaixa;
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
        config.put("password", "root");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn
                    = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/singleton",
                            config
                    );
            //CaixaDao cd = new CaixaDao((com.mysql.jdbc.Connection) conn);

            //ListViewCaixa lvc = new ListViewCaixa(this);
            //CaixaTableModel ctm = new CaixaTableModel(cd.getAll(""));
            
            //lvc.getTbTabela().setModel(ctm);
            
            Caixa c = new Caixa();
            c.setEntradas(100);
            c.setSaidas(50);
            c.setSaldoFinal(100);
            c.setSaldoInicial(150);
            c.setStatus(Caixa.StatusCaixa.ABERTO);
            
            CaixaEdicaoView cev = new CaixaEdicaoView(this);
            cev.setC(c);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("caixa.salvar")) {
            System.out.println("Dorime");
        }
    }

}
