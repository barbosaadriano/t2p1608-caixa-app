
package br.com;

import br.com.erica.dao.CaixaDao;
import br.com.erica.model.Caixas;
import br.com.erica.view.CaixaEdView;
import br.com.erica.view.CaixaTableModel;
import br.com.erica.view.ListViewCaixa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.Properties;
import javax.swing.text.html.ListView;

/**
 *
 * @author Erica
 */
public class Erica implements ActionListener{

    public static void main(String[] args) {
        
              new Erica().rodar();
              
              Caixas c = new Caixas();
              c.setSaldoInicial(20);
              c.setEntradas(90);
              c.setSaidas(7);
              c.setSaldoFinal(6);
              c.setStatus(Caixas.StatusCaixa.ABERTO);
              
              CaixaEdView cev = new CaixaEdView(); 
              cev.setVisible(true);
              cev.setLocationRelativeTo(null); 
              cev.setC(c);
              
         
              
    }
    
    public void rodar(){
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
         
            ListViewCaixa lvc = new ListViewCaixa(this);
            lvc.setVisible(true);
            
            CaixaTableModel meuModel = new CaixaTableModel(cd.getAll(""));
            
            lvc.getTabel().setModel(meuModel);
            
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
   
    
}
