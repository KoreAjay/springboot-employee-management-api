package in.strikes.Crud_Dto_Demo_Eample.repositary;

import in.strikes.Crud_Dto_Demo_Eample.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {


    boolean existsByEmail(String email);
}
