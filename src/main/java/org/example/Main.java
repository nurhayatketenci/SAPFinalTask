package org.example;

import Model.Product;
import Service.Dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        @Autowired
        ProductDao testDao;

        List<Product> lstProducts=testDao.getProducts();

        for(Product product : lstProducts)
        {
            System.out.println("Product code: "+product.getCode()):
        }
    }
}