package ecommerceproject.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;

    @JoinColumn(name = "vacation_id")
    @ManyToOne
    private Vacation vacation;

    @ManyToMany
    @JoinTable(name ="excursion_cartitem",
          joinColumns = @JoinColumn(name = "cart_item_id"),
          inverseJoinColumns = @JoinColumn(name = "excursion_id"))
    private Set<Excursion> excursions = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    public CartItem(Long id, Vacation vacation, Cart cart, Date create_date, Date last_update){
        this.id=id;
        this.vacation=vacation;
        this.cart=cart;
        this.create_date=create_date;
        this.last_update=last_update;
    }

    public CartItem() {

    }
}
