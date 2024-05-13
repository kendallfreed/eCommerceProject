package ecommerceproject.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.util.Lazy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_first_name", nullable = false)
    private String firstName;

    @Column(name = "customer_last_name", nullable = false)
    private String lastName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "postal_code", nullable = false)
    private String postal_code;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @JoinColumn(name = "division_id")
    @ManyToOne
    private Division division;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Cart> carts = new HashSet<>();


    // Constructor we will be using to set up test customers for database
    public Customer(String firstName, String lastName, String address, String postal_code,
                    String phone, Division division){
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.postal_code=postal_code;
        this.phone=phone;
        this.division=division;
    }

    public void add(Cart cart) {
        if (cart != null) {
            this.carts.add(cart);
            cart.setCustomer(this);
        } else if (carts == null) {
            this.carts = new HashSet<>();
        }
    }
    public Customer(Long id, String firstName, String lastName, String address, String postal_code,
                String phone, Date create_date, Date last_update, Division division){
            this.id=id;
            this.firstName=firstName;
            this.lastName=lastName;
            this.address=address;
            this.postal_code=postal_code;
            this.phone=phone;
            this.create_date=create_date;
            this.last_update=last_update;
            this.division=division;
        }

    public Customer() {

        }


}
