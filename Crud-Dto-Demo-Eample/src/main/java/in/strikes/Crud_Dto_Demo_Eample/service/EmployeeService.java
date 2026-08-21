package in.strikes.Crud_Dto_Demo_Eample.service;

import in.strikes.Crud_Dto_Demo_Eample.dto.EmployeeRequestDTO;
import in.strikes.Crud_Dto_Demo_Eample.dto.EmployeeResponseDTO;
import in.strikes.Crud_Dto_Demo_Eample.dto.mapper.EmployeeMapper;
import in.strikes.Crud_Dto_Demo_Eample.entity.Employee;
import in.strikes.Crud_Dto_Demo_Eample.repositary.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    //CREATE

    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO requestDTO){
        if(employeeRepository.existsByEmail(requestDTO.getEmail())){
            throw new RuntimeException("Email already exists");
        }
        //DTO-> Entity

        Employee employee= EmployeeMapper.toEntity(requestDTO);

        Employee savedEmployee=employeeRepository.save(employee);

        //Entity ->ResponseDTO

        return EmployeeMapper.toResponseDTO(savedEmployee);

    }

    //GET BY ID

    public EmployeeResponseDTO getEmployeeById(Long id){

        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->
                        new RuntimeException("Employee not found"));
        return EmployeeMapper.toResponseDTO(employee);
    }

    //GET ALL
    public List<EmployeeResponseDTO> getALlEmployee(){

        return employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::toResponseDTO)
                .toList();
    }

    //UPDATE
    public EmployeeResponseDTO updateEmployee(Long id,EmployeeRequestDTO requestDTO){
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->
                        new RuntimeException("Employee not found"));

        employee.setName(requestDTO.getName());
        employee.setEmail(requestDTO.getEmail());
        employee.setDepartment(requestDTO.getDepartment());
        employee.setSalary(requestDTO.getSalary());

        //Normally password should be encoded with PasswordEncoder
        employee.setPassword(requestDTO.getPassword());

        Employee updatedEmployee=employeeRepository.save(employee);

        return EmployeeMapper.toResponseDTO(updatedEmployee);
    }

    //DELETE

    public void deleteEmployee(Long id){
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->
                        new RuntimeException("Employee not found"));
        employeeRepository.delete(employee);


    }
}
