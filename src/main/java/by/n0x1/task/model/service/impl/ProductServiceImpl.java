package by.n0x1.task.model.service.impl; // используйте ваш пакет

import by.n0x1.task.model.service.ProductService;
import by.n0x1.task.model.entity.Product;
import java.util.Arrays;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> findAll() {
        return Arrays.asList(
                new Product(1, "Ethiopia Yirgacheffe", "Регион: Иргачеффе. Обжарка: Светлая. Ноты: Жасмин, бергамот, персик.", 18.50),
                new Product(2, "Colombia Supremo", "Регион: Антиокия. Обжарка: Средняя. Ноты: Карамель, красное яблоко, шоколад.", 15.00),
                new Product(3, "Kenya AA", "Регион: Ньери. Обжарка: Светлая. Ноты: Черная смородина, гибискус, грейпфрут.", 22.00),
                new Product(4, "Brazil Yellow Bourbon", "Регион: Серрадо. Обжарка: Эспрессо. Ноты: Ореховая паста, темный шоколад, нуга.", 14.50)
        );
    }
}