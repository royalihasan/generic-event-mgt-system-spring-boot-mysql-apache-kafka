package alpha1.o.com.genericeventmgtsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    // User Address Detail User ( 1 to 1 ) R
    @OneToOne(mappedBy = "address")
    private User user;
    // Venue Address (1 to 1  ) R
    @OneToOne(mappedBy = "address")
    private Venue venue;
}
