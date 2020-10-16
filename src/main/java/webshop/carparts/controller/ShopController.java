package webshop.carparts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import webshop.carparts.ShoppingCart;
import webshop.carparts.StoreProducts;
import webshop.carparts.StoreUser;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ShopController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("addclient")
    public void addclient(@RequestBody StoreUser request){
        storeService.addClient(request.getCompanyName(), request.getRegistrationNumber(),
                request.getCompanyVat(), request.getCompanyAddress(), request.getContactName(),
                passwordEncoder.encode(request.getPassword()), request.getEmail());
    }

    @GetMapping("productview")
    public List<StoreProducts> productView(@RequestParam String partNumber){
        return storeService.ShowProduct(partNumber);
    }

    @GetMapping("shopingcart")
    public void shopinngCart(@RequestBody ShoppingCart request){
        storeService.createShopingCart(request.getPartNumber(), request.getPartName(), request.getQuantity(),
                request.getPrice());
    }
}
