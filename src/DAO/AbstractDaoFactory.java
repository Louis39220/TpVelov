/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Arrondissement;
import entities.Station;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Louis
 */
public abstract class AbstractDaoFactory {

    public static final int DAO_MYSQL = 0;
    public static final int DAO_ORACLE = 1;

    //Prototype des factory DAO 
    public abstract Dao<Station> getStationDao() throws IOException, SQLException;

    public abstract Dao<Arrondissement> getArrondissementDao() throws IOException, SQLException;


    public static AbstractDaoFactory getDaoFactory(int type) {
        switch (type) {
            case DAO_MYSQL:
                return new DaoFactoryMysql();
            case DAO_ORACLE:
                return new DaoFactoryOracle();
            default:
                return null;       
        }
    }

}
