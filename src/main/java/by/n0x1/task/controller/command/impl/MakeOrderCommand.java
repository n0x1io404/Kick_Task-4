package by.n0x1.task.controller.command.impl;

import by.n0x1.task.controller.command.Command;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MakeOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String productId = request.getParameter("productId");


        //orderService.createOrder(userId, productId);

        return "redirect:/controller?command=show_products&success=order_placed";
    }
}