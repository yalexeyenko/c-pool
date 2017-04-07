package factory;

import connection.ConnectionPool;
import connection.ProxyConnection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Yevgeniy_Alexeyenko on 4/7/2017.
 */
public class ConnectionPoolFactoryTest {
    private ConnectionPool pool;
    private ProxyConnection conn;

    private static final String TEST_SQL_QUERY = "select 2 from dual";

    @Before
    public void init() {
        this.pool = ConnectionPoolFactory.getConnectionPool();
        this.conn = pool.getConnection();
    }

    @Test
    public void shouldExecuteQueryAndReturnTwo() throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(TEST_SQL_QUERY);
        int result = 0;
        while (rs.next()) {
            result = rs.getInt(1);
        }
        assertEquals(2, result);
    }

    @After
    public void destroy() {
        pool.returnConnection(conn);
    }
}