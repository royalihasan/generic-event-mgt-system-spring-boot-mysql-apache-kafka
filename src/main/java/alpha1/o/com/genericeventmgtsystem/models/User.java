package alpha1.o.com.genericeventmgtsystem.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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



    public User() {
    }

    public User(Long userId, String userIdNumber, String firstName, String lastName, String username, String password, String email, String role, String description, Address address, Boolean enable) {
        this.userId = userId;
        this.userIdNumber = userIdNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.description = description;
        this.address = address;
        this.enable = enable;
    }
}
