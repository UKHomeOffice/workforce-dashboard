package gov.homeoffice.workforceDashboard.repository;

import gov.homeoffice.workforceDashboard.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    List<Employee> findAll();
    void saveEmployee(Employee employee);
}
