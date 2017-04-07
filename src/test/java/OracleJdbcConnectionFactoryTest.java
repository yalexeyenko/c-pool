import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by Yevgeniy_Alexeyenko on 4/7/2017.
 */
public class OracleJdbcConnectionFactoryTest {
    private OracleJdbcConnectionFactory factory;
    private Connection conn;

    @Before
    public void init() {
        this.factory = new OracleJdbcConnectionFactory();
    }

    @Test
    public void shouldCreateOracleJdbcConnection() {
        this.conn = factory.createConnection();
        assertTrue(conn != null);
    }

    @After
    public void destroy() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}