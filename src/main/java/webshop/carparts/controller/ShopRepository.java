package webshop.carparts.controller;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import webshop.carparts.StoreProducts;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ShopRepository {

    @Autowired
    private NamedParameterJdbcTemplate shopDatabase;

    public void addClient(String companyName, BigDecimal registrationNumber, String companyVat, String companyAddress,
                          String contactName, String password, String email) {
        String sql = "INSERT INTO storeuser (company_name, registration_nr, vat_number, company_address, " +
                "contact_name, password, email) VALUES (:companyName, :registrationNumber, :companyVat, " +
                ":companyAddress, :contactName, :password, :email)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("companyName", companyName);
        paramMap.put("registrationNumber", registrationNumber);
        paramMap.put("companyVat", companyVat);
        paramMap.put("companyAddress", companyAddress);
        paramMap.put("contactName", contactName);
        paramMap.put("password", password);
        paramMap.put("email", email);
        shopDatabase.update(sql, paramMap);
    }
    public String getClient(String email) {
        String sql = "SELECT password FROM storeuser WHERE email = :email";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("email", email);
        return shopDatabase.queryForObject(sql, paramMap, String.class);
    }

    public List<StoreProducts> productInfo(String partNumber) {
        String sql = "SELECT part_number, part_name FROM spare_parts WHERE part_number = :partNumber";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("partNumber", partNumber);
        List<StoreProducts> resultList = shopDatabase.query(sql, paramMap, new ShopProductRowMapper());
        return resultList;
    }

    public void shopingCart(String partNumber, String partName, BigDecimal quantity, BigDecimal price) {
        String sql = "SELECT part_number, part_name, price FROM spare_parts JOIN shopping_cart sc on spare_parts.id = sc.part_id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sparepart", partNumber);
        shopDatabase.update(sql, paramMap);
    }
}
