package alpha1.o.com.genericeventmgtsystem.dto;

import lombok.Data;

@Data
public class AddressDto {
    private Long addressId;
    private String street;
    private String city;
    private String state;
    private String zipCode;
}
