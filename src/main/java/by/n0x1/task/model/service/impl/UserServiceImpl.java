package by.n0x1.task.model.service.impl;

import by.n0x1.task.model.service.UserService;
import by.n0x1.task.model.dao.UserDao;
import by.n0x1.task.model.dao.impl.UserDaoImpl;
import by.n0x1.task.model.entity.User;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();
    
    @Override
    public User login(String username, String pass) {
        // Server-side validation (FE handled in JSP/JS, BE handled here)
        if (username == null || username.trim().isEmpty() || pass == null || pass.trim().isEmpty()) {
            return null;
        }
        return userDao.findByUsernameAndPassword(username, pass);
    }
}
