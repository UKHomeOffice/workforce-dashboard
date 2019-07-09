package gov.homeoffice.workforceDashboard.service;

import gov.homeoffice.workforceDashboard.model.Employee;
import gov.homeoffice.workforceDashboard.repository.EmployeeRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public void saveEmployee (Employee employee){
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll () {
        return employeeRepository.findAll();
    }

    @Override
    public void excelReader() {

        final String FILE_NAME = "DummyData.xlsx";


        try {
            //Locate resource to be used
//            FileInputStream file = new FileInputStream(new File("DummyData.xlsx"));
            FileInputStream file = new FileInputStream(new File(FILE_NAME));

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook book = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = book.getSheetAt(0);

            //Missing cell policy to return null as blanks
            Row.MissingCellPolicy mcp = XSSFRow.MissingCellPolicy.CREATE_NULL_AS_BLANK;

            book.setMissingCellPolicy(mcp);

            org.apache.poi.ss.usermodel.Row row;

            //Create a new employee object
            Employee employee = new Employee();

            //For each row, iterate through all the columns
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);

                String roleRef = row.getCell(0).getStringCellValue();
                String roleTitle = row.getCell(1).getStringCellValue();
                String employeeFirstName = row.getCell(2).getStringCellValue();
                String employeeSurname = row.getCell(3).getStringCellValue();
                String employeeFullName = row.getCell(4).getStringCellValue();
                Integer employeeAdelphiNumber = (int)Math.round(row.getCell(5).getNumericCellValue());
                String employeeEmail = row.getCell(6).getStringCellValue();
                String gradeEquivalent = row.getCell(7).getStringCellValue();
                String function = row.getCell(8).getStringCellValue();
                String businessUnit = row.getCell(9).getStringCellValue();
                String team = row.getCell(10).getStringCellValue();
                String professionCluster = row.getCell(11).getStringCellValue();
                String dDaTProfessionRole = row.getCell(12).getStringCellValue();
                String affiliatedDdaTProfessionRole = row.getCell(13).getStringCellValue();
                String currentResourceRollUp = row.getCell(14).getStringCellValue();
                String functionRollUp = row.getCell(15).getStringCellValue();
                String employeeCurrentPrimaryLocation = row.getCell(16).getStringCellValue();
                String employeeAnticipatedFutureLocation = row.getCell(17).getStringCellValue();
                String eUExit = row.getCell(18).getStringCellValue();
                String isThisRoleAVacancy = row.getCell(19).getStringCellValue();
                String vacancyType = row.getCell(20).getStringCellValue();
                Double vacancyStage = row.getCell(21).getNumericCellValue();
                String rechargedRoles = row.getCell(22).getStringCellValue();
                String operationalLineManagerFirstName = row.getCell(23).getStringCellValue();
                String operationalLineManagerSurname = row.getCell(24).getStringCellValue();
                String operationalLineManagerRoleReference = row.getCell(25).getStringCellValue();
                String currentResourceType = row.getCell(26).getStringCellValue();
                String targetResourceType = row.getCell(27).getStringCellValue();
                String projectedStartDateOfRole = row.getCell(28).getStringCellValue();
                String projectedEndDateOfTerminatingRole = row.getCell(29).getStringCellValue();
                Double fTE = row.getCell(30).getNumericCellValue();
                String dDaTOrNonDDaTResource = row.getCell(31).getStringCellValue();

                employee.setRoleRef(roleRef);
                employee.setRoleTitle(roleTitle);
                employee.setEmployeeFirstName(employeeFirstName);
                employee.setEmployeeSurname(employeeSurname);
                employee.setEmployeeFullName(employeeFullName);
                employee.setEmployeeAdelphiNumber(employeeAdelphiNumber);
                employee.setEmployeeEmail(employeeEmail);
                employee.setGradeEquivalent(gradeEquivalent);
                employee.setFunction(function);
                employee.setBusinessUnit(businessUnit);
                employee.setTeam(team);
                employee.setProfessionCluster(professionCluster);
                employee.setdDaTProfessionRole(dDaTProfessionRole);
                employee.setAffiliatedDdaTProfessionRole(affiliatedDdaTProfessionRole);
                employee.setCurrentResourceRollUp(currentResourceRollUp);
                employee.setFunctionRollUp(functionRollUp);
                employee.setEmployeeCurrentPrimaryLocation(employeeCurrentPrimaryLocation);
                employee.setEmployeeAnticipatedFutureLocation(employeeAnticipatedFutureLocation);
                employee.seteUExit(eUExit);
                employee.setIsThisRoleAVacancy(isThisRoleAVacancy);
                employee.setVacancyType(vacancyType);
                employee.setVacancyStage(vacancyStage);
                employee.setRechargedRoles(rechargedRoles);
                employee.setOperationalLineManagerFirstName(operationalLineManagerFirstName);
                employee.setOperationalLineManagerSurname(operationalLineManagerSurname);
                employee.setOperationalLineManagerRoleReference(operationalLineManagerRoleReference);
                employee.setCurrentResourceType(currentResourceType);
                employee.setTargetResourceType(targetResourceType);
                employee.setProjectedStartDateOfRole(projectedStartDateOfRole);
                employee.setProjectedEndDateOfTerminatingRole(projectedEndDateOfTerminatingRole);
                employee.setfTE(fTE);
                employee.setdDaTOrNonDDaTResource(dDaTOrNonDDaTResource);

                System.out.println("Employee record saved--" + employee.toString());
                saveEmployee(employee);

            } file.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
