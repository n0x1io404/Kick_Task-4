package by.n0x1.task.controller.command.impl;

import by.n0x1.task.controller.command.Command;
import by.n0x1.task.model.service.UserService;
import by.n0x1.task.model.service.impl.UserServiceImpl;
import by.n0x1.task.model.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginCommand implements Command {
    private final UserService userService = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        
        try {
            User user = userService.login(username, pass);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                // POST/Redirect/GET protection
                return "redirect:/controller?command=show_products";
            } else {
                request.setAttribute("error", "Invalid credentials");
                return "/WEB-INF/jsp/login.jsp";
            }
        } catch (Exception e) {
            request.setAttribute("error", "Server Error");
            return "/WEB-INF/jsp/error.jsp";
        }
    }
}
