package gov.homeoffice.workforceDashboard.service;

import gov.homeoffice.workforceDashboard.repository.EmployeeRepository;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplTest {

    EmployeeServiceImpl employeeService;

    @Mock
    EmployeeRepository employeeRepository;

//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        Employee employee = new Employee("CTF159",	"Developer", "Mike", "Adams", "Mike Adams",	123458,	"foo456@bar.gov.uk", "HEO",	"Police and Public Protection Technology",	"Operations",	"Software Engineering Group",	"Technical", 	"Software Developer",	"Engineering",	"Contractor",	"Function2", 	"Liverpool",	"Glasgow", "Yes", "No","",0.2f,"", "Joyce",	"Parker",	"Foo11",	"Contractor",	"Civil Servant",	"01/10/19",	"01/03/21",	0.5f,	"DdaT");
//         employees = employeeService.saveEmployee(employee);
//        employeeService = new EmployeeServiceImpl(employeeRepository);
//    }
//
//    @Test
//    void findAll() throws Exception {
//        Employee employee = new Employee("CTF159",	"Developer", "Mike", "Adams", "Mike Adams",	123458,	"foo456@bar.gov.uk", "HEO",	"Police and Public Protection Technology",	"Operations",	"Software Engineering Group",	"Technical", 	"Software Developer",	"Engineering",	"Contractor",	"Function2", 	"Liverpool",	"Glasgow", "Yes", "No","",0.2f,"", "Joyce",	"Parker",	"Foo11",	"Contractor",	"Civil Servant",	"01/10/19",	"01/03/21",	0.5f,	"DdaT");
//        employeeService.saveEmployee(employee);
//
//        when(employeeRepository.findAll()).thenReturn(employee);
//        List<Employee> employee = employeeService.findAll();
//    }
}