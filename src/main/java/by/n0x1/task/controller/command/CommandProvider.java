package by.n0x1.task.controller.command;

import by.n0x1.task.controller.command.impl.LoginCommand;
import by.n0x1.task.controller.command.impl.LogoutCommand;
import by.n0x1.task.controller.command.impl.MakeOrderCommand;
import by.n0x1.task.controller.command.impl.ShowProductsCommand;
import by.n0x1.task.controller.command.impl.*;
import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("show_products", new ShowProductsCommand());
        commands.put("make_order", new MakeOrderCommand());
    }

    public Command getCommand(String name) {
        if (name == null || !commands.containsKey(name)) {
            return commands.get("show_products");
        }
        return commands.get(name);
    }
}
