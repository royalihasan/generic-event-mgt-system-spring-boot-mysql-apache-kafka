package alpha1.o.com.genericeventmgtsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    // Venue Address (1 to 1  ) R
    @OneToOne(mappedBy = "address")
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<Venue> venueList = new ArrayList<>();

}
