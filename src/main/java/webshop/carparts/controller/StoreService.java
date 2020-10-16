package webshop.carparts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.carparts.StoreProducts;

import java.math.BigDecimal;
import java.util.List;

@Service
public class StoreService {

    @Autowired
    private ShopRepository shopRepository;

    public void addClient(String companyName, BigDecimal registrationNumber, String companyVat,
                          String companyAddress, String contactName, String password, String email) {
        shopRepository.addClient(companyName, registrationNumber, companyVat, companyAddress, contactName, password, email);
    }

    public List<StoreProducts> ShowProduct(String partNumber) {
        List<StoreProducts> requestList = shopRepository.productInfo(partNumber);
        return requestList;
    }

    public void createShopingCart(String partNumber, String partName, BigDecimal quantity, BigDecimal price) {
        shopRepository.shopingCart(partNumber, partName, quantity,price);
    }
}
