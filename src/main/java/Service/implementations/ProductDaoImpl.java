package Service.implementations;

import Model.Product;
import Repository.ProductRepository;
import Service.Dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import javax.naming.directory.SearchResult;
import java.util.*;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;

public class ProductDaoImpl implements ProductDao {
    @Autowired
    FlexibleSearchService flexibleSearchService;
   private ProductRepository productRepository;

    @Override
    public void getAllProducts() {
        System.out.println("Showing all products");
        productRepository.findAll().forEach(System.out::println);
    }

    @Override
    public List<Product> getByProductCode() {

            final Map<String, Object> params = new HashMap<String, Object>();
            String FIND_PRODUCT_QUERY = "SELECT {*} FROM {Product AS p} WHERE {p:code} LIKE ?code";
            params.put("code","001");
            final SearchResult<Product> searchResult = flexibleSearchService.search(query, params);
            return searchResult.getResults();
    }







}
