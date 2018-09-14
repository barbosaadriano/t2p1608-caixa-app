package br.com.adrianob;

import br.com.LunaIzahR.view.CaixaTableModel;
import br.com.LunaIzahR.view.EditViewCaixa;
import br.com.LunaIzahR.view.ListViewCaixa;
import br.com.adrianob.dao.CaixaDao;
import br.com.adrianob.model.Caixa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author drink
 */
public class Main implements ActionListener {

        
    public static void main(String[] args) {
      
        new Main().rodar();
        
      
        Caixa c = new Caixa(); 
        
        
        EditViewCaixa evc = new EditViewCaixa(); 
            evc.setVisible(true);
            evc.setLocationRelativeTo(null);
            evc.setC(c);
            
       
        c.setSaldoInicial(58);
        c.setEntradas(60);
               
    }
    
    public void rodar(){
        
          Properties config = new Properties();
        config.put("user", "root");
        config.put("password", "root");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn
                    = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/singletton",
                            config
                    );
            
            CaixaDao cd 
                    = new CaixaDao((com.mysql.jdbc.Connection) conn);
            
            ListViewCaixa lvc = new ListViewCaixa(this); 
            lvc.setVisible(true);
            lvc.setLocationRelativeTo(null);
            
            
            
            CaixaTableModel meumodel = new CaixaTableModel(cd.getAll("")); 
            lvc.getTabela().setModel(meumodel);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        
        
    }

}
