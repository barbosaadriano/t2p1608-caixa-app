
package br.com.adrianob.dao;

import br.com.adrianob.model.Caixa;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        ArrayList<Caixa> lista = new ArrayList<>();
        String sql = "select * from tbl_caixa ";
        try {
            PreparedStatement ps 
                    = this.cnx.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Caixa c = new Caixa();
                c.setData(res.getDate("data"));
                c.setSaldoInicial(res.getDouble("saldoinicial"));
                c.setEntradas(res.getDouble("entradas"));
                c.setSaidas(res.getDouble("saidas"));
                c.setSaldoFinal(res.getDouble("saldofinal"));
                String tmp = res.getString("status");
                if (tmp.equals("Fechado")) {
                    c.setStatus(Caixa.StatusCaixa.FECHADO);
                }
                lista.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }
    
    public Caixa getCaixa(Date data) {
        
        return null;
    }
    
}
