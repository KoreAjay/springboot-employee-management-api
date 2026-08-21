package in.strikes.Crud_Dto_Demo_Eample.controller;

import in.strikes.Crud_Dto_Demo_Eample.dto.EmployeeRequestDTO;
import in.strikes.Crud_Dto_Demo_Eample.dto.EmployeeResponseDTO;
import in.strikes.Crud_Dto_Demo_Eample.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    // CREATE
    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> createEmployee(
            @Valid @RequestBody EmployeeRequestDTO requestDTO) {

        EmployeeResponseDTO response =
                employeeService.createEmployee(requestDTO);

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED
        );
    }


    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployee(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                employeeService.getEmployeeById(id)
        );
    }


    // GET ALL
    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees() {

        return ResponseEntity.ok(
                employeeService.getALlEmployee()
        );
    }


    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeRequestDTO requestDTO) {

        return ResponseEntity.ok(
                employeeService.updateEmployee(id, requestDTO)
        );
    }


    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable Long id) {

        employeeService.deleteEmployee(id);

        return ResponseEntity.ok("Employee deleted successfully");
    }
}