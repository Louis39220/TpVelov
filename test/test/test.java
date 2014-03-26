/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import DAO.AbstractDaoFactory;
import DAO.ArrondissementDaoMySQL;
import DAO.ArrondissementDaoOracle;
import DAO.Dao;
import DAO.DaoFactoryMysql;
import Fenetre.ModeleTable;
import entities.Arrondissement;
import entities.Station;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Louis
 */
public class test {
    
    
     public static void main(String[] args) throws SQLException, IOException, Exception {
        AbstractDaoFactory abs = AbstractDaoFactory.getDaoFactory(AbstractDaoFactory.DAO_ORACLE);
        Dao<Station> dao = (Dao<Station>) abs.getStationDao();
        HashMap<String, Station> liste = dao.selectAll();
        
        Collection<Station> collec = liste.values();
        for (Station s : collec) System.out.println(s.toString());
     }
    
}
