package Service.Dao;

import Model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {
    public void getAllProducts();
    public List<Product> getByProductCode();
}
