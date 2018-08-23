package br.com.adrianob;

import br.com.adrianob.dao.CaixaDao;
import br.com.adrianob.model.Caixa;
import br.com.adrianob.view.AdrianoCellRenderer;
import br.com.adrianob.view.CaixaTableModel;
import br.com.adrianob.view.EditViewCaixa;
import br.com.adrianob.view.ListViewCaixa;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author drink
 */
public class Main implements ActionListener {

    private ListViewCaixa lvc = null;
    private CaixaDao cd = null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main().open();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("caixa.search")) {
            lvc.getTabela().setModel(new CaixaTableModel(cd.getAll("")));
            lvc.getTabela().setDefaultRenderer(Object.class, new AdrianoCellRenderer());
        }
        if (e.getActionCommand().equals("caixa.add")) {
            EditViewCaixa edc = new EditViewCaixa(Main.this);
            Caixa caixa = cd.getCaixa(new Date());
            edc.setDataFromCaixa(caixa);
            edc.setVisible(true);
        }
    }

    private void open() {
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

            cd = new CaixaDao((com.mysql.jdbc.Connection) conn);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        lvc = new ListViewCaixa(this);
        lvc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lvc.setVisible(true);
    }

}
