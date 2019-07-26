package gov.homeoffice.workforceDashboard.repository;

import gov.homeoffice.workforceDashboard.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query("SELECT a FROM Employee a ORDER BY a.function ASC, a.team ASC, a.employeeSurname ASC")
    List<Employee> findByFunction();

    @Query("SELECT DISTINCT f.function FROM Employee f ORDER BY f.function ASC")
    List<String> fieldSelect();

    @Query("SELECT s FROM Employee s WHERE s.function= ?1 ORDER BY s.employeeSurname ASC")
    List<Employee> findBySelection(String selection);

}





