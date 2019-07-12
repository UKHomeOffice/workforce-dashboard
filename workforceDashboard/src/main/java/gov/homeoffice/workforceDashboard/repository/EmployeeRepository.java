package gov.homeoffice.workforceDashboard.repository;

import gov.homeoffice.workforceDashboard.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    //  WS - The below is the code to return a sorted list by Function
    @Query("SELECT a FROM Employee a ORDER BY a.function ASC, a.team ASC, a.employeeFullName ASC")
    List<Employee> findByFunction();
}

