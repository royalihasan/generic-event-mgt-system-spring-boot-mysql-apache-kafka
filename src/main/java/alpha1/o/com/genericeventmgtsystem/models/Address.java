package alpha1.o.com.genericeventmgtsystem.models;

import jakarta.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    private String street;
    private String city;
    private String state;
    private String zipCode;

    @OneToOne(mappedBy = "address")
    private User user;

    // Constructors, getters, and setters

    public Address() {
    }

    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    // Getters and Setters

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
