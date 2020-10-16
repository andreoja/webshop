package webshop.carparts.controller;

import webshop.carparts.StoreProducts;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShopProductRowMapper implements RowMapper<StoreProducts> {

    @Override
    public StoreProducts mapRow(ResultSet resultSet, int i) throws SQLException{
        StoreProducts storeProduct = new StoreProducts();
//        storeProduct.setSparePartId(resultSet.getLong("id"));
        storeProduct.setPartNumber(resultSet.getString("part_number"));
        storeProduct.setPartName(resultSet.getString("part_name"));
        return storeProduct;
    }
}
