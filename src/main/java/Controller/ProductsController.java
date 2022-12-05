package Controller;

import Model.Product;
import Service.implementations.ProductDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

public class ProductsController extends HttpServlet {
    ProductDaoImpl productDao;

    @Override
    public void init() throws ServletException {
        productDao = new ProductDaoImpl();
    }
    public void getAll() throws ServletException, IOException {
        List<Product> products = productDao.getAllProducts();
    }
    @Override
    public void getByCode(){
        List<Product> getByCode=productDao.getProductCode();
    }
}
