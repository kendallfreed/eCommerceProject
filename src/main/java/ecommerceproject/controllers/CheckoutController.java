package ecommerceproject.controllers;

import ecommerceproject.services.CheckoutService;
import ecommerceproject.services.Purchase;
import ecommerceproject.services.PurchaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
    private CheckoutService checkoutService;

    @Autowired
    public CheckoutController (CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    @CrossOrigin("http://localhost:4200")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){
        // return purchseResponse via rest API
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
        return purchaseResponse;
    }
}
