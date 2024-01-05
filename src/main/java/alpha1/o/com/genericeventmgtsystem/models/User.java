package alpha1.o.com.genericeventmgtsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * User is generic Entity which hold [ admin , Manager , Team , Organizer ... ] data
 * */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(unique = true)
    private String userIdNumber;
    private String userPassKey;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String username;
    private String password;
    @Column(unique = true)
    private String email;
    private String role;
    private String description;
    private Boolean enable;
    // one to one mapping with user's Address
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_address_id", referencedColumnName = "address_id")
    private Address address;

}
