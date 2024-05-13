package ecommerceproject.services;

import ecommerceproject.dao.CartItemRepository;
import ecommerceproject.dao.CartRepository;
import ecommerceproject.dao.CustomerRepository;
import ecommerceproject.entities.Cart;
import ecommerceproject.entities.CartItem;
import ecommerceproject.entities.Customer;
import ecommerceproject.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository){
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        // According to common fail points don't need to save customer, just cart to cart repository.

        // retrieve the order info
        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();
        if (purchase.getCartItems().stream().count() == 0){
            return new PurchaseResponse("Cart is empty!");
        }
        Set<CartItem> cartItems = purchase.getCartItems();

        // generate tracking #
        String orderTrackingNumber = generateOrderTrackingNumber();
        System.out.print("Order tracking number generated is " + orderTrackingNumber);
        cart.setOrderTrackingNumber(orderTrackingNumber);
        cart.setStatus(StatusType.ordered);

        // populate cart with cartItems
        cartItems.forEach(cartItem -> {
            cart.add(cartItem);

        });

        // populate customer with order
        customer.add(cart);

        // save to the database
      //  customerRepository.save(customer);
        cartRepository.save(cart);
        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // generate random UUID number (UUID version-4) - standardized method of generating unique IDs
        return UUID.randomUUID().toString();
    }
}
