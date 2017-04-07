package factory;

import connection.ConnectionPool;
import connection.ProxyConnection;

/**
 * Created by Yevgeniy_Alexeyenko on 4/7/2017.
 */
public class ConnectionPoolFactory {
    private static final ConnectionPool POOL = create();

    private static ConnectionPool create() {
        if (POOL != null) {
            return POOL;
        } else {
            return new ConnectionPool(10);
        }
    }

    public static ConnectionPool getConnectionPool() {
        return POOL;
    }
}
