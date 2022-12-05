package Service.implementations;

import Model.Product;
import Service.Dao.ProductDao;
import config.MySqlConnector;
import org.springframework.beans.factory.annotation.Autowired;

import javax.naming.directory.SearchResult;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDaoImpl implements ProductDao {

    @Autowired
    FlexibleSearchService flexibleSearchService;
    @Override
    public List<Product> getAllProducts() {
        List<Product> result = new ArrayList<>();
        try {
            Connection con =  MySqlConnector.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM products");
            while (rs.next()){
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setCreatedAt(rs.getDate("createdAt"));
                p.setStatus(rs.getString("status"));
                p.setPrice(rs.getInt("price"));
                result.add(p);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Product> getProductCode() {
        final Map<String, Object> params = new HashMap<String, Object>();
        String query ="SELECT * FROM {product AS p} WHERE {p:code} LIKE ?code";
        params.put("code","1");
        final SearchResult<Product> searchResult = flexibleSearchService.search(query, params);
        return searchResult.getResults();

    }

}
