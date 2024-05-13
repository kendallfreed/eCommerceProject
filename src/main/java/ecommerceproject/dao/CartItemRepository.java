package ecommerceproject.dao;

import ecommerceproject.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

// <Entity, primary key type>
@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "cartItems", path = "cartItems")
public interface CartItemRepository extends JpaRepository <CartItem, Long> {
}

