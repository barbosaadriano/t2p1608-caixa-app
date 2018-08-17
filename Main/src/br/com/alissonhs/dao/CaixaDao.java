/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alissonhs.dao;

import br.com.caixa.Caixa;
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
 * @author Alisson H. Silva
 */
public class CaixaDao {

    private Connection cnx;
    private SimpleDateFormat sdf;

    public CaixaDao(Connection cnx) {
        this.cnx = cnx;
        this.sdf = new SimpleDateFormat("yyyy-MM-dd");
               System.out.println("OPA!");
    }
    public void Salvar(Caixa c){
        Caixa caixa = this.getCaixa(c.getDate());
        String sql = "update tbl_caixa set saldoincial = ?, entradas = ?, saidas = ?, saldofinal = ?, status = ?, where data = ?";
        if (caixa == null) {
          sql = "insert into tbl_caixa (saldoincial, entradas, saidas, saldofinal, status, data) values (?,?,?,?,?,?)";
                 System.out.println("OPA!");
            
        }
        try {
            PreparedStatement ps = this.cnx.prepareStatement(sql);
            ps.setDouble(1, c.getSaldoInicial());
            ps.setDouble(2, c.getEntradas());
            ps.setDouble(3, c.getSaidas());
            ps.setDouble(4, c.getSaldoFinal());
            ps.setString(5, c.getStatus().name());
            ps.setString(6, sdf.format(c.getDate()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
           System.out.println("OPA!");
    }
    
    public void Remover (Caixa c) {
        String sql = "delete from tbl_caixa where data = ?";
        try {
            PreparedStatement ps = this.cnx.prepareStatement(sql);
            ps.setString(1, sdf.format(c.getDate()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            
}
    public ArrayList<Caixa> getAll(String where) {
        ArrayList<Caixa> lista = new ArrayList<>() ;
        String sql = "select * from tbl_caixa " + where;
        try {
            PreparedStatement ps = this.cnx.prepareStatement(sql);
           ResultSet res =  ps.executeQuery();
           while (res.next()){
               Caixa c = new Caixa();
               c.setDate(res.getDate("data"));
               c.setSaldoInicial(res.getDouble("saldoinicial"));
               c.setEntradas(res.getDouble("entradas"));
               c.setSaidas(res.getDouble("saidas"));
               c.setSaldoFinal(res.getDouble("saldofinal"));
               String tmp = res.getString(sql);
                      System.out.println("OPA!");
               if(tmp.equals("Fechado")){
                  c.setStatus(Caixa.statusCaixa.FECHADO);
               }
               lista.add(c);
           }
       System.out.println("OPA!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());;
        }
        
           return lista;
    }

    
    public Caixa getCaixa (Date Data){
        String dt = sdf.format(Data);
        ArrayList<Caixa> all = this.getAll("Where data = '"+dt+"'");
        if(!all.isEmpty()){
                return all.get(0);
        }
        return null;
    }

    
    
    public void createTable() {
        String sql = "create table if not exists tbl_caixa( "
                + "data date not null primary key,"
                + "saldoinicial numeric (13,2),"
                + "entradas numeric(13,2),"
                + "saidas numeric (13,2),"
                + "saldofinal numeric(13,2),"
                + "status varchar (7))";
        
        
 
        
        try {
            PreparedStatement ps = this.cnx.prepareStatement(sql);
            ps.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
