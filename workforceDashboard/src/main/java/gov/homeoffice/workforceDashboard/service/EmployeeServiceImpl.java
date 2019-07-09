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
            FileInputStream file = new FileInputStream(new File(FILE_NAME));

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook book = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = book.getSheetAt(0);

            //Missing cell policy to return null as blanks
            Row.MissingCellPolicy mcp = XSSFRow.MissingCellPolicy.CREATE_NULL_AS_BLANK;

            book.setMissingCellPolicy(mcp);

            Row row;
            //Create a new employee object
            Employee employee = new Employee();

            //For each row, iterate through all the columns
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);

                employee.setRoleRef(row.getCell(0).getStringCellValue());
                employee.setRoleTitle(row.getCell(1).getStringCellValue());
                employee.setEmployeeFirstName(row.getCell(2).getStringCellValue());
                employee.setEmployeeSurname(row.getCell(3).getStringCellValue());
                employee.setEmployeeFullName(row.getCell(4).getStringCellValue());
                employee.setEmployeeAdelphiNumber((int)Math.round(row.getCell(5).getNumericCellValue()));
                employee.setEmployeeEmail(row.getCell(6).getStringCellValue());
                employee.setGradeEquivalent(row.getCell(7).getStringCellValue());
                employee.setFunction(row.getCell(8).getStringCellValue());
                employee.setBusinessUnit(row.getCell(9).getStringCellValue());
                employee.setTeam(row.getCell(10).getStringCellValue());
                employee.setProfessionCluster(row.getCell(11).getStringCellValue());
                employee.setdDaTProfessionRole(row.getCell(12).getStringCellValue());
                employee.setAffiliatedDdaTProfessionRole(row.getCell(13).getStringCellValue());
                employee.setCurrentResourceRollUp(row.getCell(14).getStringCellValue());
                employee.setFunctionRollUp(row.getCell(15).getStringCellValue());
                employee.setEmployeeCurrentPrimaryLocation(row.getCell(16).getStringCellValue());
                employee.setEmployeeAnticipatedFutureLocation(row.getCell(17).getStringCellValue());
                employee.seteUExit(row.getCell(18).getStringCellValue());
                employee.setIsThisRoleAVacancy(row.getCell(19).getStringCellValue());
                employee.setVacancyType(row.getCell(20).getStringCellValue());
                employee.setVacancyStage((float)Math.round(row.getCell(21).getNumericCellValue()));
                employee.setRechargedRoles(row.getCell(22).getStringCellValue());
                employee.setOperationalLineManagerFirstName(row.getCell(23).getStringCellValue());
                employee.setOperationalLineManagerSurname(row.getCell(24).getStringCellValue());
                employee.setOperationalLineManagerRoleReference(row.getCell(25).getStringCellValue());
                employee.setCurrentResourceType(row.getCell(26).getStringCellValue());
                employee.setTargetResourceType(row.getCell(27).getStringCellValue());
                employee.setProjectedStartDateOfRole(row.getCell(28).getStringCellValue());
                employee.setProjectedEndDateOfTerminatingRole(row.getCell(29).getStringCellValue());
                employee.setfTE((float)Math.round(row.getCell(30).getNumericCellValue()));
                employee.setdDaTOrNonDDaTResource(row.getCell(31).getStringCellValue());

                System.out.println("Employee record saved--" + employee.toString());
                saveEmployee(employee);

            } file.close();
              book.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
