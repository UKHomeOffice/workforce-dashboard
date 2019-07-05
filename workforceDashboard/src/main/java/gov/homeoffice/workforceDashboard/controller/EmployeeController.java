package gov.homeoffice.workforceDashboard.controller;

import gov.homeoffice.workforceDashboard.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/")
    public String getIntro() {
        return "Hello World!";
    }
}
