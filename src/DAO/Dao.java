/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Louis
 * @param <T>
 */
public abstract class Dao<T> {
    protected Connection connect = null;
    
    public Dao(Connection conn){
        this.connect = conn;
    }
    
    public abstract boolean insert(T obj)throws SQLException,IOException;
    
    public abstract boolean delete(T obj)throws SQLException,IOException;
    
    public abstract boolean update(T obj)throws SQLException,IOException;
    
    public abstract T select(int id)throws SQLException,IOException;
    
    public abstract HashMap<String, T> selectAll()throws Exception;
    
}
