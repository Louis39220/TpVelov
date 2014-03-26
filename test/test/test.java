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
import entities.Arrondissement;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Louis
 */
public class test {
    
    
     public static void main(String[] args) throws SQLException, IOException, Exception {
         AbstractDaoFactory s = AbstractDaoFactory.getDaoFactory(AbstractDaoFactory.DAO_MYSQL);
         Dao<Arrondissement> d = (Dao<Arrondissement>) s.getArrondissementDao();
         Arrondissement a = new Arrondissement(10, "Lyon 6eme");
         Arrondissement a1 = new Arrondissement(2, "Lyon 7eme");
         //int id = 1;
        
         try {
                d.insert(a);
                d.insert(a1);
               System.out.println(d.selectAll().toString());  
             
         }catch(SQLException | IOException e) {
             System.err.println(e.getMessage());
         }
         
         
     }
    
}
