package car2.dto;

import lombok.Data;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class SignupDto {

    @NotBlank
    @Size(min=4, max=20, message = "Username must have at least 4 characters")
    private String username;

    @NotBlank
    @Size(min=8, max=128, message = "Password must have at least 8 characters")
    private String password;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank
    @Size(min=8, max=10, message = "Phone number must have at least 8 characters")
    private String phoneNumber;

    @NotBlank
    @Size(min=13, max=13, message = "Registration number must have 13 characters")
    private String registrationNumber;

    @NotBlank
    @Pattern(regexp = "^(ROLE_ADMIN|ROLE_USER)$",
            message = "Role is in an incorrect format.")
    private String role;

    @Lob
    private String img;
}
