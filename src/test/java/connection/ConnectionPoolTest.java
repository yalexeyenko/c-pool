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

    @Before
    public void init() {
        this.pool = new ConnectionPool(10);
    }

    @Test
    public void shouldCreateConnectionPoolOfSizeTen() {
        assertEquals(10, pool.getMaxSize());
    }

    @Test
    public void shouldTakeOneConnectionFromThePool() {
        ProxyConnection conn = pool.getConnection();
        assertNotEquals(null, conn);
        assertEquals(9, pool.getMaxSize());

        pool.returnConnection(conn);
        assertEquals(10, pool.getMaxSize());
    }
}