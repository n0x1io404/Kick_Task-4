package by.n0x1.task.model.dao.impl;

import by.n0x1.task.model.dao.UserDao;
import by.n0x1.task.model.entity.User;
import by.n0x1.task.model.pool.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * DAO Pattern Layer with JDBC.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User findByUsernameAndPassword(String username, String pass) {
        // SQL Injection Protection using PreparedStatement
        String sql = "SELECT id, username, role FROM users WHERE username = ? AND password = ?";
        
        Connection conn = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, pass);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                 return new User(rs.getInt("id"), rs.getString("username"), rs.getString("role"));
            }
        } catch (Exception e) {
            // Handle exception or rethrow
        } finally {
           ConnectionPool.getInstance().releaseConnection(conn);
        }
        
        return null; 
    }

    @Override
    public List<User> findAll() { return null; }
    @Override
    public User findById(int id) { return null; }
    @Override
    public void create(User entity) { }
    @Override
    public void update(User entity) {}
    @Override
    public void delete(int id) {}
}
