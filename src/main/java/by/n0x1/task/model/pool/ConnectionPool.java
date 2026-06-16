package by.n0x1.task.model.pool;

import java.sql.Connection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Thread-safe Connection Pool implementation WITHOUT using 'synchronized' or 'volatile'.
 * Utilizes ArrayBlockingQueue and ReentrantLock pattern.
 */
public class ConnectionPool {
    private static ConnectionPool instance;
    private static final Lock lock = new ReentrantLock();
    
    private final BlockingQueue<Connection> freeConnections;

    private ConnectionPool() {
        freeConnections = new ArrayBlockingQueue<>(10);
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            System.out.println("Driver initialization failed");
        }
    }

    public static ConnectionPool getInstance() {
        lock.lock();
        try {
            if (instance == null) {
                instance = new ConnectionPool();
            }
            return instance;
        } finally {
            lock.unlock();
        }
    }

    public Connection getConnection() {
        try {
            return freeConnections.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Error taking connection", e);
        }
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            freeConnections.offer(connection);
        }
    }
}
