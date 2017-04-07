import oracle.jdbc.driver.OracleDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Yevgeniy_Alexeyenko on 4/7/2017.
 */
public class OracleJdbcConnectionFactory {
    private PropertyManager manager;
    private Connection conn;
    private Properties properties;
    private static final String ORACLE_JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";

    public OracleJdbcConnectionFactory() {
    }

    public Connection createConnection() {
        manager = new PropertyManager();
        properties = manager.getOracleJdbcProperties();
        try {
            Class.forName(ORACLE_JDBC_DRIVER);
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


}
