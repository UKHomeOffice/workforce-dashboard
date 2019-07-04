package gov.homeoffice.workforceDashboard.service;

import gov.homeoffice.workforceDashboard.model.Employee;
import gov.homeoffice.workforceDashboard.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;


    public void saveEmployee (Employee employee) {
        employeeRepository.save(employee);
    }


    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
