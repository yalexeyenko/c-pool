import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

/**
 * Created by Yevgeniy_Alexeyenko on 4/7/2017.
 */
public class OracleJdbcConnectionFactoryTest {
    private OracleJdbcConnectionFactory factory;
    private ProxyConnection conn;

    private static final String TEST_SQL_QUERY = "select 1 from dual";

    @Before
    public void init() {
        this.factory = new OracleJdbcConnectionFactory();
        this.conn = factory.createConnection();
    }

    @Test
    public void shouldCreateOracleJdbcConnection() {
        assertTrue(conn != null);
    }

    @Test
    public void shouldReturnOne() throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(TEST_SQL_QUERY);
        int result = 0;
        while (rs.next()) {
            result = rs.getInt(1);
        }
        assertEquals(1, result);
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