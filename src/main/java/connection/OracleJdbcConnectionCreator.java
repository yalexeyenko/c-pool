package connection;

import manager.PropertyManager;
import oracle.jdbc.driver.OracleDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Yevgeniy_Alexeyenko on 4/7/2017.
 */
public class OracleJdbcConnectionCreator {
    private PropertyManager manager;
    private ProxyConnection pConn;
    private Properties properties;

    public OracleJdbcConnectionCreator() {
    }

    public ProxyConnection createConnection() {
        manager = new PropertyManager();
        properties = manager.getOracleJdbcProperties();
        Connection conn;
        try {
            Class.forName(properties.getProperty("driver"));
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
            pConn = new ProxyConnection(conn);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pConn;
    }


}
