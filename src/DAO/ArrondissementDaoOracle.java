/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import connexion.ConnexionOracleFactory;
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
public class ArrondissementDaoOracle extends Dao<Arrondissement> {
     private Connection connexionDB;
    
    public ArrondissementDaoOracle(Connection conn){
        super(conn);
    }
    
    @Override
    public HashMap<String, Arrondissement> selectAll()throws Exception{
        connexionDB = ConnexionOracleFactory.getInstance();
        ResultSet rs;
        Statement st = connexionDB.createStatement();
        rs = st.executeQuery("SELECT * FROM arrondissementVille");

        HashMap<String, Arrondissement> hc = new HashMap<>();
        while(rs.next()){
            hc.put(Integer.toString(rs.getInt(1)),new Arrondissement(rs.getInt(1), rs.getString(2)));
        }
        rs.close();
        connexionDB.close();
        return hc;
    }
    
    @Override
    public Arrondissement select(int id)throws SQLException,IOException{
        connexionDB = ConnexionOracleFactory.getInstance();
        ResultSet rs;
        Arrondissement a;
        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM arrondissementVille WHERE numeroArrondissementVille= ?")) {
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
        connexionDB = ConnexionOracleFactory.getInstance();
        try (PreparedStatement PS = connexionDB.prepareStatement("INSERT INTO ARRONDISSEMENTVILLE(NUMEROARRONDISSEMENTVILLE,NOMARRONDISSEMENTVILLE) values(?,?)")) {
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
        connexionDB = ConnexionOracleFactory.getInstance();
        try (PreparedStatement ps = connexionDB.prepareStatement("DELETE FROM ARRONDISSEMENTVILLE where NUMEROARRONDISSEMENTVILLE=?")) {
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
        connexionDB = ConnexionOracleFactory.getInstance();
        try (PreparedStatement ps = connexionDB.prepareStatement("UPDATE arrondissementVille SET nomArrondissementVille=? where numeroArrondissementVille=?")) {
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
