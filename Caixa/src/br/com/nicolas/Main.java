package br.com.nicolas;

import br.com.nicolasg.dao.CaixaDao;
import br.com.nicolasg.view.CaixaTableModel;
import br.com.nicolasg.view.ListViewCaixa;
import br.com.nicolasg.view.TelaCaixa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import javax.swing.table.TableModel;

/**
 *
 * @author drink
 */
public class Main implements ActionListener {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       new Main().rodar();
       
    }
    
    public void rodar(){
        Properties config = new Properties();
        config.put("user", "root");
        config.put("password", "");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn
                    = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/singleton",
                            config
                    );
            
            CaixaDao cd 
                    = new CaixaDao((com.mysql.jdbc.Connection) conn);
           
            ListViewCaixa lvc = new ListViewCaixa(this);
            lvc.setVisible(true);
            
            CaixaTableModel meuModel = new CaixaTableModel(cd.getAll(""));
                        
            lvc.getTabela().setModel(meuModel);            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }

}