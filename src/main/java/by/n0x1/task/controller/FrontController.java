package by.n0x1.task.controller;

import by.n0x1.task.controller.command.Command;
import by.n0x1.task.controller.command.CommandProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet("/controller")
public class FrontController extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();
    private final CommandProvider provider = new CommandProvider();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter("command");
        logger.info("Executing command: {}", commandName);
        
        Command command = provider.getCommand(commandName);
        String page = command.execute(req, resp);
        
        if (page != null) {
            // Post/Redirect/Get Pattern realization for F5 protection
            if (page.startsWith("redirect:")) {
                resp.sendRedirect(req.getContextPath() + page.substring("redirect:".length()));
            } else {
                req.getRequestDispatcher(page).forward(req, resp);
            }
        }
    }
}
