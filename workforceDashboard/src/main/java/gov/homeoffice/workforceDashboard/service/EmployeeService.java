package gov.homeoffice.workforceDashboard.service;

import gov.homeoffice.workforceDashboard.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    void saveEmployee(Employee employee);

    List<Employee> findAll();
}
