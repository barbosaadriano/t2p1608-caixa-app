/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thalyscalory.dao;

import br.com.thalyscalory.Model.Caixa;
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
 * @author Usuario
 */
public class CaixaDao {
    
    private Connection cnx;
    private SimpleDateFormat sdf;
    
    public CaixaDao(Connection cnx) {
        this.cnx = cnx;
        this.sdf = new SimpleDateFormat("yyy-MM-dd");
    }
    
    public void salvar(Caixa c){
        Caixa caixa = this.getCaixa(c.getData());
        String sql = "update caixa set saldo_inicial = ?, entrada = ?"
                + ", saida = ?, saldo_final = ?, status = ? where data = ?";
        if (caixa == null) {
            sql = "insert into caixa (saldo_inicial, entrada, saida"
                    + ", saldo_final, status, data) values"
                    + " (?,?,?,?,?,?)";
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
            System.out.println(ex.getMessage());
        }
    }
    
    public void remover(Caixa c){
        String sql = "delete from caixa where data = ?";
        try {
            PreparedStatement ps = this.cnx.prepareStatement(sql);
            ps.setString(1, sdf.format(c.getData()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public ArrayList<Caixa> getAll(String where){
        ArrayList<Caixa> lista = new ArrayList<>();
        
        String sql = "select * from caixa " + where;
        try {
            PreparedStatement ps = this.cnx.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                Caixa c = new Caixa();
                c.setData(result.getDate("data"));
                c.setSaldoInicial(result.getDouble("saldo_inicial"));
                c.setEntradas(result.getDouble("entrada"));
                c.setSaidas(result.getDouble("saida"));
                c.setSaldoFinal(result.getDouble("saldo_final"));
                String tmp = result.getString("status");
                if (tmp.equals("Fechado")) {
                    c.setStatus(Caixa.statusCaixa.FECHADO);
                }
                lista.add(c);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return null;
    }
    
    public Caixa getCaixa(Date data) {
        String dt = sdf.format(data);
        ArrayList<Caixa> all = this.getAll("where data = '" + dt +"'");
        if (!all.isEmpty()) {
            return all.get(0);
        }
        return null;
    }
    
    public void createTable(){
        String sql = "create table if not exists caixa("
                + "data date not null primary key,"
                + " saldo_inicial numeric(13,2),"
                + " entrada numeric(13,2),"
                + " saida numeric(13,2),"
                + " saldo_final numeric(13,2),"
                + "status varchar(7)"
                + ")";
        try {
            PreparedStatement ps = this.cnx.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
