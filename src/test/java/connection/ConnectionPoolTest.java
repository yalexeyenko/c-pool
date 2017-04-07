package connection;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Yevgeniy_Alexeyenko on 4/7/2017.
 */
public class ConnectionPoolTest {
    private ConnectionPool pool;
    private ProxyConnection conn;

    @Before
    public void init() {
        this.pool = new ConnectionPool(10);
    }

    @Test
    public void shouldCreateConnectionPoolOfSizeTen() {
        assertEquals(10, pool.getSize());
    }

    @Test
    public void shouldRetrieveAndReturnConnectionFromThePool() {
        this.conn = pool.getConnection();
        assertNotEquals(null, conn);
        assertEquals(9, pool.getSize());
        pool.returnConnection(conn);
        assertEquals(10, pool.getSize());
    }

}