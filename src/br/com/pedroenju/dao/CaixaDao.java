package br.com.pedroenju.dao;

import br.com.pedroenju.model.Caixa;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CaixaDao {
    //Data Access Object
    //Ele faz a ponte entre o BANCO DE DADOS e o MODEL(onde os dados estão)

    private Connection cnx;
    private SimpleDateFormat sdf;

    public CaixaDao(Connection cnx) {
        this.cnx = cnx;
        this.sdf = new SimpleDateFormat("yyyy-MM-dd");
    }

    public void salvar(Caixa c) { //Insert e Update

    }

    public void remover(Caixa c) { //Delete

    }

    public ArrayList<Caixa> getAll() { //Select
        ArrayList<Caixa> lista = new ArrayList<>();

        String sql = "select * from tbl_caixa ";

        try {
            PreparedStatement ps = this.cnx.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Caixa c = new Caixa();
                c.setData(rs.getDate("data"));
                c.setSaldoInicial(rs.getDouble("saldoinicial"));
                c.setEntradas(rs.getDouble("entradas"));
                c.setSaidas(rs.getDouble("saidas"));
                c.setSaldoFinal(rs.getDouble("saldofinal"));
                String tmp = rs.getString("status");
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
