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
@Table(name = "vacations")
@Getter
@Setter
public class Vacation {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Long id;

    @Column(name = "vacation_title")
    private String vacation_title;

    @Column(name = "description")
    private String description;

    @Column(name = "travel_fare_price")
    @JsonProperty("travel_price")
    private BigDecimal travel_price;

    @Column(name = "image_url")
    @JsonProperty("image_URL")
    private String image_URL;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacation")
    private Set<Excursion> excursions = new HashSet<>();
    public Vacation(Long id, String vacation_title, String description, BigDecimal travel_price,
                    String image_URL, Date create_date, Date last_update){
        this.id=id;
        this.vacation_title=vacation_title;
        this.description=description;
        this.travel_price=travel_price;
        this.image_URL=image_URL;
        this.create_date=create_date;
        this.last_update=last_update;
    }

    public Vacation() {

    }
}
