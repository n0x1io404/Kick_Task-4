package by.n0x1.task.model.dao;
import by.n0x1.task.model.entity.User;

public interface UserDao extends BaseDao<User> {
    User findByUsernameAndPassword(String username, String pass);
}
