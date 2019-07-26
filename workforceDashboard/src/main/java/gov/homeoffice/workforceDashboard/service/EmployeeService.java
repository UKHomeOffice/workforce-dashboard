package gov.homeoffice.workforceDashboard.service;

import gov.homeoffice.workforceDashboard.model.Employee;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

public interface EmployeeService {

    void saveEmployee(Employee employee);

    List<Employee> findAll();

    void excelReader();

    List<Employee>findByFunction();

    List<String>getListOfUniqueFunctions();

    List<Employee>findByUniqueFunction(String selection);

}
