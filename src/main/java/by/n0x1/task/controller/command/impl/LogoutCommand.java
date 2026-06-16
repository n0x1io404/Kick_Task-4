package by.n0x1.task.controller.command.impl;

import by.n0x1.task.controller.command.Command;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        request.getSession().invalidate();
        return "redirect:/controller?command=login";
    }
}