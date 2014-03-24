package connexion;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Louis
 */
public class ConnexionMysqlFactory {

    private static Connection connectionMySQL;

    // Ouvre une connexion s'il n'en existe pas déja une
    public static Connection getInstance() throws IOException, SQLException {
        if (connectionMySQL == null) {
            try {
                Properties props = new Properties();
                FileInputStream fichier = new FileInputStream("src/connexion/connexion.properties");
                props.load(fichier);
                MysqlDataSource mds = new MysqlDataSource();
                mds.setUser(props.getProperty("user"));
                mds.setServerName(props.getProperty("serveur"));
                return (mds.getConnection());
            } 
            catch (IOException | SQLException e) {
                System.err.println("Erreur lors de la connection : " + e.getMessage());
            }
        }
        return connectionMySQL;
    }

    public void closeConnection() throws SQLException {
        connectionMySQL.close();
    }

}
