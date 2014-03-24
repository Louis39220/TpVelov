/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connexion.ConnexionMysqlFactory;
import connexion.ConnexionOracleFactory;
import entities.Arrondissement;
import entities.Station;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Louis
 */
public class DaoFactoryMysql extends AbstractDaoFactory {

    protected static Connection conn;
    
    //retourne un objet Station interagissant avec la BDD MYSQL
    @Override
    public Dao<Station> getStationDao() throws IOException, SQLException {
        conn = ConnexionMysqlFactory.getInstance();
        return new StationDaoMySQL(conn);
    }

    //Retourne un objet Arrondissement interagissant avec la BDD MYSQL
    @Override
    public  Dao<Arrondissement> getArrondissementDao() throws IOException, SQLException {
        conn = ConnexionMysqlFactory.getInstance();
        return new ArrondissementDaoMySQL(conn);
    }







}
