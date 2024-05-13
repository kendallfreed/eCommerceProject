package ecommerceproject.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
//import java.lang.Object;
//import java.lang.Enum;

@Entity
@Table(name = "carts")
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name = "package_price")
    private BigDecimal package_price;

    @Column(name = "party_size")
    private int party_size;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusType status;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @JoinColumn(name = "customer_id", nullable=false)
    @ManyToOne
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItem = new HashSet<>();

    public Cart() {
    }


    public void add(CartItem cartItem){
        this.cartItem.add(cartItem);
        cartItem.setCart(this);

    }


    public Cart(long id, String orderTrackingNumber, BigDecimal package_price, int party_size,
                 StatusType status, Date create_date, Date last_update){
        super();
        this.id = id;
        this.orderTrackingNumber = orderTrackingNumber;
        this.package_price = package_price;
        this.party_size = party_size;
        this.status = status;
        this.create_date = create_date;
        this.last_update = last_update;

    }

}
