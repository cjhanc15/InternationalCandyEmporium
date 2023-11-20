package com.gcu.internationalcandyemporium.Data;

import java.util.List;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.gcu.internationalcandyemporium.Interfaces.DataAccessInterface;
import com.gcu.internationalcandyemporium.Models.ProductModel;

@Service
public class ProductsDataService implements DataAccessInterface<ProductModel> {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    // @Autowired
    public ProductsDataService(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public List<ProductModel> findAll() {
        String sql = "SELECT * FROM PRODUCTS";

        List<ProductModel> products =  new ArrayList<ProductModel>();
        try {
            SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
            while (srs.next()) {
                ProductModel product = new ProductModel(
                srs.getLong("ID"), 
                srs.getString("NAME"),
                srs.getString("DESCRIPTION"),
                srs.getString("IMAGE_URL"),
                srs.getDouble("PRICE"),
                srs.getInt("QUANTITY"));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public ProductModel findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean create(ProductModel product) {
        String sql = "INSERT INTO PRODUCTS(NAME, DESCRIPTION, IMAGE_URL, PRICE, QUANTITY) VALUES(?, ?, ?, ?, ?)";
        try {
            int rows = jdbcTemplateObject.update(sql, product.getName(), product.getDescription(), product.getImageUrl(), product.getPrice(), product.getQuantity());
            return rows == 1 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(ProductModel product) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean delete(ProductModel product) {
        // TODO Auto-generated method stub
        return true;
    }

}