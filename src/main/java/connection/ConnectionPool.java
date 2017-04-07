package connection;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Yevgeniy_Alexeyenko on 4/7/2017.
 */
public class ConnectionPool {
    private ArrayBlockingQueue<ProxyConnection> pool;
    private OracleJdbcConnectionCreator factory;
    private int maxSize;

    public ConnectionPool(int size) {
        this.maxSize = size;
        this.pool = new ArrayBlockingQueue<ProxyConnection>(maxSize);
        this.factory = new OracleJdbcConnectionCreator();
        initPool(maxSize);
    }

    private void initPool(int size) {
        while (!isFull()) {
            pool.offer(factory.createConnection());
        }
    }

    public synchronized ProxyConnection getConnection() {
        ProxyConnection conn = null;
        if (pool.size() > 0) {
            return pool.poll();
        }
        return null;
    }

    public synchronized void returnConnection(ProxyConnection conn) {
        pool.offer(conn);
    }

    public int getMaxSize() {
        return pool.size();
    }

    private boolean isFull() {
        if (pool.size() < maxSize) {
            return false;
        } else {
            return true;
        }
    }
}
