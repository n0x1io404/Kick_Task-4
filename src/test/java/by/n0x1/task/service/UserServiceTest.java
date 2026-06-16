package by.n0x1.task.service;

import by.n0x1.task.model.service.impl.UserServiceImpl;
import by.n0x1.task.model.entity.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Test
    public void testLoginValidation() {
        UserServiceImpl service = new UserServiceImpl();
        User result = service.login("", "");
        assertNull(result, "Empty credentials should result in null response (server-validation)");
    }
}
