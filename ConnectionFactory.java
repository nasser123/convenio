package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import org.ini4j.Profile.Section;

/**
 *
 * @author Usuario
 */
public class ConnectionFactory {

    private static Connection connection;
    private static Connection connectionNoDatabase;
    private static EntityManager entityManager;

    public static Connection getConnection() {
        if (connection == null) {
            Section config = ConfigurationFactory.getConfiguration();
            try {
                //aqui colocamos os dados de acesso ao banco
                if (config.get("db.name").equalsIgnoreCase("mysql")) {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connection = DriverManager.getConnection("jdbc:mysql://" + config.get("db.host") + ":3306/" + config.get("db.database") + "?autoReconnect=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8",
                            config.get("db.user"), config.get("db.password"));
                }
            } catch (InstantiationException | IllegalAccessException | SQLException | ClassNotFoundException ex) {
                ConfigurationFactory.getLOG().warn(ex.getMessage());
            }
        }
        return connection;
    }

    public static Connection getConnectionWithNoDatabase() {
        if (connectionNoDatabase == null) {
            Section config = ConfigurationFactory.getConfiguration();
            try {
                //aqui colocamos os dados de acesso ao banco
                if (config.get("db.name").equalsIgnoreCase("mysql")) {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connectionNoDatabase = DriverManager.getConnection("jdbc:mysql://" + config.get("db.host") + ":3306/?autoReconnect=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8",
                            config.get("db.user"), config.get("db.password"));
                }
            } catch (InstantiationException | IllegalAccessException | SQLException | ClassNotFoundException ex) {
               ConfigurationFactory.getLOG().warn(ex.getMessage());
            }
        }
        return connectionNoDatabase;
    }

    public static EntityManager getEntityManager() {
        Section config = ConfigurationFactory.getConfiguration();
        Map prop = new HashMap();
        if (entityManager == null) {
            EntityManagerFactory emf;
            prop.put("javax.persistence.jdbc.url", "jdbc:mysql://" + config.get("db.host") + ":3306/" + config.get("db.database"));
            prop.put("javax.persistence.jdbc.password", config.get("db.password"));
            prop.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
            prop.put("javax.persistence.jdbc.user", config.get("db.user"));
            emf = Persistence.createEntityManagerFactory("convenioPU", prop);
            try {
                entityManager = emf.createEntityManager();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Sem acesso ao banco de dados");
                ConfigurationFactory.getLOG().warn(e.getMessage());
            }

            return entityManager;
        } else {

            return entityManager;
        }
    }

}
