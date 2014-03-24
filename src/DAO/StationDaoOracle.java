/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import connexion.ConnexionOracleFactory;
import entities.Station;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Louis
 */
public class StationDaoOracle extends Dao<Station> {
    
    private Connection connexionDB;
    
    public StationDaoOracle(Connection conn){
        super(conn);
    }
    
    
    @Override
    public HashMap<String,Station> selectAll()throws Exception{
        connexionDB = ConnexionOracleFactory.getInstance();
        ResultSet rs;
        Statement st = connexionDB.createStatement();
        rs = st.executeQuery("SELECT * FROM java.station");
        HashMap<String,Station> hs = new HashMap<>();
        while(rs.next()){
            hs.put(rs.getString(1),new Station(rs.getString(1), rs.getString(2), rs.getString(3)));
        }
        rs.close();
        connexionDB.close();
        return hs;
    }
    
    @Override
    public Station select(int id)throws SQLException,IOException{
        connexionDB = ConnexionOracleFactory.getInstance();
        ResultSet rs;
        Station s;
        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM java.station WHERE numeroIdentification=?")) {
            PS.setString(1, String.valueOf(id));
            rs = PS.executeQuery();
            rs.next();
            s = new Station(rs.getString(1),rs.getString(2),rs.getString(3));
        }
        rs.close();
        connexionDB.close();
        return s;
    }
    
    @Override
    public boolean insert(Station s)throws SQLException,IOException{
        boolean res = true;
        connexionDB = ConnexionOracleFactory.getInstance();
        try (PreparedStatement PS = connexionDB.prepareStatement("INSERT INTO java.station(numeroIdentification,nomStation,localisationStation) values(?,?,?)")) {
            PS.setString(1, s.getNumeroIdentification());
            PS.setString(2, s.getNomStation());
            PS.setString(3, s.getLocalisationStation());
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
    public boolean delete(Station s)throws SQLException,IOException{
        boolean res = true;
        connexionDB = ConnexionOracleFactory.getInstance();
        try (PreparedStatement ps = connexionDB.prepareStatement("DELETE FROM java.station where numeroIdentification=?")) {
            ps.setString(1, s.getNumeroIdentification());
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
    public boolean update(Station s)throws SQLException,IOException{
        boolean res = true;
        connexionDB = ConnexionOracleFactory.getInstance();
        try (PreparedStatement ps = connexionDB.prepareStatement("UPDATE java.station SET nomStation=? localisationStation=? where numeroIdentification=?")) {
            ps.setString(1, s.getNomStation());
            ps.setString(2, s.getLocalisationStation());
            ps.setString(3,s.getNumeroIdentification());
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
