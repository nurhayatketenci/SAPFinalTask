package Service.implementations;

import Model.Product;
import Service.Dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDaoImpl implements ProductDao {
    @Autowired
    FlexibleSearchService flexibleSearchService;
    public List<Product> getProducts()
    {
        final Map<String, Object> params = new HashMap<String, Object>();
        String query =”SELECT {p:pk} FROM {Product AS p} WHERE {p:code} LIKE ?code”
        params.put("code",”1”);
        final SearchResult<Product> searchResult = flexibleSearchService.search(query, params);
        return searchResult.getResults();
    }

}
