package br.com.lucasj.dao;

import br.com.lucasj.model.Caixa;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CaixaDao {

    private Connection cnx;
    private SimpleDateFormat sdf;

    public CaixaDao(Connection cnx) {
        this.cnx = cnx;
        this.sdf = new SimpleDateFormat("yyyy-MM-dd");

    }

    public void salvar(Caixa c) {
        Caixa caixa = this.getCaixa(c.getData());
        String sql = "update tbl_caixa set saldoinicial = ?, "
                + " entradas = ?, saidas = ?, saldofinal = ?, status = ? "
                + " where data = ? ;";
        if (caixa == null) {
            sql = "insert into tbl_caixa(saldoinicial, entradas, saidas, saldofinal, status, data) "
                    + " values(?,?,?,?,?,?);";
        }

        try {
            PreparedStatement ps = this.cnx.prepareStatement(sql);
            ps.setDouble(1, c.getSaldoInicial());
            ps.setDouble(2, c.getEntradas());
            ps.setDouble(3, c.getSaidas());
            ps.setDouble(4, c.getSaldoFinal());
            ps.setString(5, c.getStatus().name());
            ps.setString(6, sdf.format(c.getData()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("0");
            System.out.println(ex.getMessage());
        }
    }

    public void remover(Caixa c) {
        String sql = "delete from tbl_caixa where data = ?";
        try {
            PreparedStatement ps = this.cnx.prepareStatement(sql);
            ps.setString(1, sdf.format(c.getData()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("1");
            System.out.println(ex.getMessage());
        }
    }
    
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS tbl_caixa"
                + "( data date not null primary key, "
                + "saldoinicial numeric(13,2), "
                + "entradas numeric(13,2), "
                + "saidas numeric(13,2), "
                + "saldofinal numeric(13,2), "
                + "status varchar(7) )";
        try {
            PreparedStatement ps = this.cnx.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("3");
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<Caixa> getAll(String where) {
        ArrayList<Caixa> lista = new ArrayList<>();
        String sql = "select * from tbl_caixa" + where;
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
            System.out.println("4");
            System.out.println(ex.getMessage());
        }

        return lista;
    }

    public Caixa getCaixa(Date data) {
        
        ArrayList<Caixa> all = this.getAll(" where data = '" + sdf.format(data) + "'");
        if (!all.isEmpty()) {
            return all.get(0);
        }
        return null;
    }
}
