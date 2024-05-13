package ecommerceproject.services;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
