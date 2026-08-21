package in.strikes.Crud_Dto_Demo_Eample.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;
    @Email(message = "Invalid email")
    private String email;
    @NotBlank(message ="Password is required")
    private String password;

    private String department;
    @Positive(message = "Salary must be-greater then  0")
    private double salary;

}
