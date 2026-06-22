package by.n0x1.task.webservice;

import by.n0x1.task.model.service.ProductService;
import by.n0x1.task.model.service.impl.ProductServiceImpl;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/products")
public class ProductWebService extends HttpServlet {
    private final ProductService productService = new ProductServiceImpl();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(gson.toJson(productService.findAll()));
    }
}
