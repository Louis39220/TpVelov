/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import DAO.AbstractDaoFactory;
import DAO.ArrondissementDaoMySQL;
import DAO.ArrondissementDaoOracle;
import DAO.DaoFactoryMysql;
import entities.Arrondissement;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Louis
 */
public class test {
    
    
     public static void main(String[] args) throws SQLException, IOException, Exception {
         AbstractDaoFactory s = AbstractDaoFactory.getDaoFactory(AbstractDaoFactory.DAO_ORACLE);
         ArrondissementDaoOracle d = (ArrondissementDaoOracle) s.getArrondissementDao();
         Arrondissement a = new Arrondissement(1, "Lyon 6eme");
         //int id = 1;
        
         try {
             boolean insert = d.insert(a);
             System.out.println(d.selectAll().toString());
             a.setNomArrondissement("Lyon 5eme");
             d.update(a);
             System.out.println(d.selectAll().toString());            
         }catch(SQLException | IOException e) {
             System.err.println(e.getMessage());
         }
         
         
     }
    
}
