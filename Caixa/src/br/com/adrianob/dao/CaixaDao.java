
package br.com.adrianob.dao;

import br.com.adrianob.model.Caixa;
import com.mysql.jdbc.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author drink
 */
public class CaixaDao {
    
    private Connection cnx;
    private SimpleDateFormat sdf;

    public CaixaDao(Connection cnx) {
        this.cnx = cnx;
        this.sdf = new SimpleDateFormat("yyyy-MM-dd");
    }

    
    public void salvar(Caixa c) {
        
    }
    public void remover(Caixa c) {
        
    }
    public ArrayList<Caixa> getAll() {
        String sql = "";
        
        return null;
    }
    
    public Caixa getCaixa(Date data) {
        
        return null;
    }
    
}
