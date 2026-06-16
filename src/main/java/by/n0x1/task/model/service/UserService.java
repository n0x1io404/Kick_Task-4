package by.n0x1.task.model.service;
import by.n0x1.task.model.entity.User;

public interface UserService {
    User login(String username, String pass);
}
