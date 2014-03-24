/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import connexion.ConnexionMysqlFactory;
import entities.Arrondissement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author Louis
 */
public class ArrondissementDaoMySQL extends Dao<Arrondissement> {
    private Connection connexionDB;
    
    public ArrondissementDaoMySQL(Connection conn){
        super(conn);
    }
    
    @Override
    public HashMap<String, Arrondissement> selectAll()throws Exception{
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        HashMap<String, Arrondissement> hc;
        Statement st = connexionDB.createStatement();
        rs = st.executeQuery("SELECT * FROM java.arrondissementVille");
        hc = new HashMap<>();
        while(rs.next()){
            hc.put(Integer.toString(rs.getInt(1)),new Arrondissement(rs.getInt(1), rs.getString(2)));
        }
        if(hc.isEmpty()) { throw new Exception("Table vide");}
        rs.close();
        connexionDB.close();
        return hc;
    }
    
    @Override
    public Arrondissement select(int id)throws SQLException,IOException{
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        Arrondissement a;
        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM java.arrondissementVille WHERE numeroArrondissementVille= ?")) {
            PS.setInt(1, id);
            rs = PS.executeQuery();
            rs.next();
            a = new Arrondissement(rs.getInt(1), rs.getString(2));
        }
        rs.close();
        connexionDB.close();
        return a;
    }
    
    @Override
    public boolean insert(Arrondissement a)throws SQLException,IOException{
                boolean res = true;
        connexionDB = ConnexionMysqlFactory.getInstance();
        try (PreparedStatement PS = connexionDB.prepareStatement("INSERT INTO java.arrondissementVille(numeroArrondissementVille,nomArrondissementVille) values(?,?)")) {
            PS.setInt(1, a.getIdArrondissement());
            PS.setString(2, a.getNomArrondissement());
            try {
                PS.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                PS.cancel();
                res = false;
            }
            PS.close();
            connexionDB.close();
        }
        return res;
    }
    
    @Override
     public boolean delete(Arrondissement a)throws SQLException,IOException{
        boolean res = true;
        connexionDB = ConnexionMysqlFactory.getInstance();
        try (PreparedStatement ps = connexionDB.prepareStatement("DELETE FROM java.arrondissementVille where numeroArrondissementVille=?")) {
            ps.setInt(1, a.getIdArrondissement());
            try {
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                ps.cancel();
                res = false;
            }
            ps.close();
            connexionDB.close();
        }
        return res;
    }
    
    @Override
   public boolean update(Arrondissement a)throws SQLException,IOException{
        boolean res = true;
        connexionDB = ConnexionMysqlFactory.getInstance();
        try (PreparedStatement ps = connexionDB.prepareStatement("UPDATE java.arrondissementVille SET nomArrondissementVille=? where numeroArrondissementVille=?")) {
            ps.setString(1, a.getNomArrondissement());
            ps.setInt(2,a.getIdArrondissement());
            try {
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                ps.cancel();
                res = false;
            }
            ps.close();
            connexionDB.close();
        }
        return res;
    }
    
}
