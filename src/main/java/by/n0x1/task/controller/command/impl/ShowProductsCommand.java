package by.n0x1.task.controller.command.impl;

import by.n0x1.task.controller.command.Command;
import by.n0x1.task.model.service.ProductService;
import by.n0x1.task.model.service.impl.ProductServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShowProductsCommand implements Command {
    private final ProductService productService = new ProductServiceImpl();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("products", productService.findAll());
        return "/WEB-INF/jsp/products.jsp";
    }
}
