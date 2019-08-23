package greencity.dto.user_own_security;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegisterDto {

    @NotBlank
    @Length(max = 20)
    private String firstName;

    @NotBlank
    @Length(max = 20)
    private String lastName;

    @NotBlank @Email private String email;

    @NotBlank
    @Pattern(regexp = "^[A-z0-9~`!@#$%^&*()+=_{}|:;”’?/<>,.\\]\\[]{8,}$")
    private String password;
}
