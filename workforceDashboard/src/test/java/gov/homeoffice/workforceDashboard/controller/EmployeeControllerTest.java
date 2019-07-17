package gov.homeoffice.workforceDashboard.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import gov.homeoffice.workforceDashboard.model.Employee;
import gov.homeoffice.workforceDashboard.repository.EmployeeRepository;
import gov.homeoffice.workforceDashboard.service.EmployeeService;
import gov.homeoffice.workforceDashboard.service.UploadService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)

public class EmployeeControllerTest {

    @MockBean
    private EmployeeService employeeService;

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private UploadService uploadService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @MockBean
    private Employee employee;

//    Employee employee = new Employee("CTF159",	"Developer", "Mike", "Adams", "Mike Adams",	123458,	"foo456@bar.gov.uk", "HEO",	"Police and Public Protection Technology",	"Operations",	"Software Engineering Group",	"Technical", 	"Software Developer",	"Engineering",	"Contractor",	"Function2", 	"Liverpool",	"Glasgow", "Yes", "No","",0.2f,"", "Joyce",	"Parker",	"Foo11",	"Contractor",	"Civil Servant",	"01/10/19",	"01/03/21",	0.5f,	"DdaT");


    @Test
    @DisplayName("Test listView")
    public void listView() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .get("/list")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Test findAll")
    public void findAllTest() throws Exception {

        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee("CTF159",	"Developer", "Mike", "Adams", "Mike Adams",	123458,	"foo456@bar.gov.uk", "HEO",	"Police and Public Protection Technology",	"Operations",	"Software Engineering Group",	"Technical", 	"Software Developer",	"Engineering",	"Contractor",	"Function2", 	"Liverpool",	"Glasgow", "Yes", "No","",0.2f,"", "Joyce",	"Parker",	"Foo11",	"Contractor",	"Civil Servant",	"01/10/19",	"01/03/21",	0.5f,	"DdaT"));
        employeeList.add(new Employee("CTF159",	"Developer", "Mike1", "Adams", "Mike Adams",	123458,	"foo456@bar.gov.uk", "HEO",	"Police and Public Protection Technology",	"Operations",	"Software Engineering Group",	"Technical", 	"Software Developer",	"Engineering",	"Contractor",	"Function2", 	"Liverpool",	"Glasgow", "Yes", "No","",0.2f,"", "Joyce",	"Parker",	"Foo11",	"Contractor",	"Civil Servant",	"01/10/19",	"01/03/21",	0.5f,	"DdaT"));
        employeeList.add(new Employee("CTF159",	"Developer", "Mike2", "Adams", "Mike Adams",	123458,	"foo456@bar.gov.uk", "HEO",	"Police and Public Protection Technology",	"Operations",	"Software Engineering Group",	"Technical", 	"Software Developer",	"Engineering",	"Contractor",	"Function2", 	"Liverpool",	"Glasgow", "Yes", "No","",0.2f,"", "Joyce",	"Parker",	"Foo11",	"Contractor",	"Civil Servant",	"01/10/19",	"01/03/21",	0.5f,	"DdaT"));

//        System.out.println(employeeList);

        when(employeeService.findAll()).thenReturn(employeeList);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/list")
//                .accept(MediaType.APPLICATION_JSON))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3))).andDo(print());

//                verify(employeeService,times(1)).findAll();
                //assert statement here
//                assertEquals(employees.size(), is(equals(3)));
                //Why is assertThat unavailable as option
                //assertThat(employees.size(), is(equals3)));
    }
}