/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Louis
 */
public class ConnexionOracleFactory {

    private static Connection connectionOracle;

    public static Connection getInstance() throws IOException, SQLException {
        if (connectionOracle == null) {
            try {
                Properties props = new Properties();
                FileInputStream fichier = new FileInputStream("src/connexion/connexionOracle.properties");
                props.load(fichier);
                OracleDataSource ods = new OracleDataSource();
                ods.setDriverType(props.getProperty("pilote"));
                ods.setPortNumber(new Integer(props
                        .getProperty("port")).intValue());
                ods.setServiceName(props.getProperty("service"));
                ods.setUser(props.getProperty("user"));
                ods.setPassword(props.getProperty("pwd"));
                ods.setServerName(props.getProperty("serveur"));
                return (ods.getConnection());
            } catch (IOException | SQLException e) {
                System.err.println("Erreur lors de la connection : " + e.getMessage());
            }
        }
        return connectionOracle;
    }

    public void closeConnection() throws SQLException {
        connectionOracle.close();
    }

}
