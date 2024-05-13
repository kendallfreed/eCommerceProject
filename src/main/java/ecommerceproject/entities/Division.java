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
@Table(name = "divisions")
@Getter
@Setter
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;

    @Column(name = "division")
    private String division_name;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id", nullable = false, insertable = false, updatable = false)
    private Country country;

    @Column(name = "country_id")
    private long country_id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "division")
    private Set<Customer> customers = new HashSet<>();

    public Division() {

    }

    public void setCountry(Country country) {
        setCountry_id(country.getId());
        this.country = country;
    }
    public Division(Long id, String division_name, Date create_date, Date last_update, Country country, long country_id){
        this.id=id;
        this.division_name=division_name;
        this.create_date=create_date;
        this.last_update=last_update;
        this.country=country;
        this.country_id=country_id;

    }
}
