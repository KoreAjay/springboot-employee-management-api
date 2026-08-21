package in.strikes.Crud_Dto_Demo_Eample.dto;

import in.strikes.Crud_Dto_Demo_Eample.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String department;
    private double salary;


}