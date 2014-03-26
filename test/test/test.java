/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import DAO.AbstractDaoFactory;
import DAO.Dao;
import entities.Arrondissement;
import entities.Station;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Louis
 */
public class test {
    
    
     public static void main(String[] args) throws SQLException, IOException, Exception {
         AbstractDaoFactory s = AbstractDaoFactory.getDaoFactory(AbstractDaoFactory.DAO_ORACLE);
         Dao<Arrondissement> d = (Dao<Arrondissement>) s.getArrondissementDao();
         Dao<Station> stat = (Dao<Station>) s.getStationDao();
         Arrondissement a = new Arrondissement(3, "Lyon 6eme");
         Arrondissement a1 = new Arrondissement(4, "Lyon 7eme");
         //int id = 1;
        
         try {
               
               System.out.println(stat.selectAll().toString());  
             
         }catch(SQLException | IOException e) {
             System.err.println(e.getMessage());
         }
         
         
     }
    
}
