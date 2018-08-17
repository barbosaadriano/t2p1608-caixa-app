package br.com.erica.dao;

import br.com.erica.model.Caixas;
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
 * @author Erica
 */
public class CaixaDao {
    
    private Connection cnx;
    private SimpleDateFormat sdf; //transformar data em texto e etexto em data

    public CaixaDao(Connection cnx) {
        this.cnx = cnx;
        this.sdf = new SimpleDateFormat("yyyy-MM-dd"); //para alterar o formato de data / dd-mm-yyyy
    }
    
    public void salvar(Caixas c){
        Caixas caixa = this.getCaixas(c.getData());
        String sql = "update tbl_caixa set saldoinicial = ?, entradas = ?, saidas = ?, saldofinal = ?, status = ?, where data = ?";
        if (caixa == null) { //se for nulo significa que devo inserir
            sql = "insert into tbl_caixa (saldoinicial, entradas, saidas, saldofinal, status, data) values "
                    + "(?, ?, ?, ?, ?, ?)";        
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
    
    public void remover(Caixas c){
        String sql = "delete from tbl_caixa where data = ?";
        try {
           PreparedStatement ps = this.cnx.prepareStatement(sql);
           ps.setString(1, sdf.format(c.getData()));
           ps.executeUpdate();
           
        } catch (SQLException ex) {

        }
    }
    //para retornar os dados
    public ArrayList<Caixas> getAll(String where) {
        ArrayList<Caixas> lista = new ArrayList<>(); //criando uma lista
        String sql = "select * from tbl_caixa " +where; 
        try {
            PreparedStatement ps = this.cnx.prepareStatement(sql); //preparar a sql para executar
            ResultSet res = ps.executeQuery(); //uma lista com os dados que vem do banco
            while (res.next()) {
                Caixas c = new Caixas();
                c.setData(res.getDate("data"));
                c.setSaldoInicial(res.getDouble("saldoinicial"));
                c.setEntradas(res.getDouble("entradas"));
                c.setSaidas(res.getDouble("saidas"));
                c.setSaldoFinal(res.getDouble("saldofinal"));
                String tmp = res.getString("status");
                if (tmp.equals("Fechado")){
                    c.setStatus(Caixas.StatusCaixa.FECHADO);
                }
                lista.add(c);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }
    //ver o caixa de um dia especifico
    public Caixas getCaixas(Date data){
        String dt = sdf.format(data); //retorna variavel tipo string chamada data
        ArrayList<Caixas> all = this.getAll(" where data = '"+dt+"' "); 
        if (!all.isEmpty()){
            return all.get(0);
        }
     return null;
    }
    //criando uma tabela
    public void createTable(){
        String sql = "CREATE TABLE IF NOT EXISTS tbl_caixa (data date not null primary key, "
                + "saldoinicial numeric(13,2), "
                + "entradas numeric(13,2), "
                + "saidas numeric (13,2), "
                + "saldofinal numeric(13,2), "
                + "status varchar(7) )";
        try {
            PreparedStatement ps = this.cnx.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
