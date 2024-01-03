package alpha1.o.com.genericeventmgtsystem.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userIdNumber;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String role;
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
    private Address address;
    private Boolean enable;

    @OneToMany(mappedBy = "eventOrganizer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Event> organizedEvents;
}
