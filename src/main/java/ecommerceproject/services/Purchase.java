package ecommerceproject.services;

import ecommerceproject.entities.Cart;
import ecommerceproject.entities.CartItem;
import ecommerceproject.entities.Customer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Getter
@Setter
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}
