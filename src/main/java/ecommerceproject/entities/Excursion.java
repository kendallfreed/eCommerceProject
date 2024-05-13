package ecommerceproject.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;



@Entity
@Table(name = "excursions")
@Getter
@Setter
public class Excursion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    private long id;

    @Column(name = "excursion_title")
    @JsonProperty("excursion_title")
    private String excursion_title;

    @Column(name = "excursion_price")
    private BigDecimal excursion_price;

    @Column(name = "image_url")
    @JsonProperty("image_URL")
    private String image_URL;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @JoinColumn(name = "vacation_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private Vacation vacation;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "excursions")
    private Set <CartItem> cartitems = new HashSet<>();
    public Excursion(long id, String excursion_title, BigDecimal excursion_price, String image_URL,
                     Date create_date, Date last_update, Vacation vacation){
        this.id=id;
        this.excursion_title=excursion_title;
        this.excursion_price=excursion_price;
        this.image_URL=image_URL;
        this.create_date=create_date;
        this.last_update=last_update;
        this.vacation=vacation;
    }

    public Excursion() {

    }
}
