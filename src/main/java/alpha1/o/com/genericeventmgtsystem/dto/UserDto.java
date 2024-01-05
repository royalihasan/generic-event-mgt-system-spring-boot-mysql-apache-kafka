package alpha1.o.com.genericeventmgtsystem.dto;

import alpha1.o.com.genericeventmgtsystem.models.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {

    private Long userId;
    @NotNull
    private String userIdNumber;
    private String firstName;
    private String lastName;
    private String username;
    @Size(min = 8)
    private String password;
    @Email()
    private String email;
    private String role;
    private String description;
    private Address address;

}
