package gov.homeoffice.workforceDashboard.service;

import gov.homeoffice.workforceDashboard.model.Employee;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadExcel {

    private static final String FILE_NAME = "/home/cdp/Downloads/ctoWorkforceSearch/src/main/resources/static/CTOAggregatedColumns_anonTestData_excel.xlsx";


    public static void buildArray() throws Exception {

        List <Employee> employeeList = new ArrayList<>();
        FileInputStream excelFile = null;

        try {
            excelFile = new FileInputStream(FILE_NAME);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();
//            NB: trying out a data formatter below
//            DataFormatter formatter = new DataFormatter();

            if (iterator.hasNext())
                iterator.next();

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                for (int i = 0; i < 31; i++) {
                    Employee employee = new Employee();
                    Cell cell = cellIterator.next();

                    switch (i) {
                        case 0: employee.setRoleRef(cell.getRichStringCellValue().toString());
                        case 1: employee.setRoleTitle(cell.getRichStringCellValue().toString());
                        case 2: employee.setEmployeeFirstName(cell.getRichStringCellValue().toString());
                        case 3: employee.setEmployeeSurname(cell.getRichStringCellValue().toString());
                        case 4: employee.setEmployeeFullName(cell.getRichStringCellValue().toString());
                        case 5: employee.setEmployeeAdelphiNumber(cell.getNumericCellValue());
                        case 6: employee.setEmployeeEmail(cell.getRichStringCellValue().toString());
                        case 7: employee.setGradeEquivalent(cell.getRichStringCellValue().toString());
                        case 8: employee.setFunction(cell.getRichStringCellValue().toString());
                        case 9: employee.setBusinessUnit(cell.getRichStringCellValue().toString());
                        case 10: employee.setTeam(cell.getRichStringCellValue().toString());
                        case 11: employee.setProfessionCluster(cell.getRichStringCellValue().toString());
                        case 12: employee.setdDaTProfessionRole(cell.getRichStringCellValue().toString());
                        case 13: employee.setAffiliatedDdaTProfessionRole(cell.getRichStringCellValue().toString());
                        case 14: employee.setCurrentResourceRollUp(cell.getRichStringCellValue().toString());
                        case 15: employee.setFunctionRollUp(cell.getRichStringCellValue().toString());
                        case 16: employee.setEmployeeCurrentPrimaryLocation(cell.getRichStringCellValue().toString());
                        case 17: employee.setEmployeeAnticipatedFutureLocation(cell.getRichStringCellValue().toString());
                        case 18: employee.seteUExit(cell.getRichStringCellValue().toString());
                        case 19: employee.setIsThisRoleAVacancy(cell.getRichStringCellValue().toString());
                        case 20: employee.setVacancyType(cell.getRichStringCellValue().toString());
                        case 21: employee.setVacancyStage(cell.getRichStringCellValue().toString());
                        case 22: employee.setRechargedRoles(cell.getRichStringCellValue().toString());
                        case 23: employee.setOperationalLineManagerFirstName(cell.getRichStringCellValue().toString());
                        case 24: employee.setOperationalLineManagerSurname(cell.getRichStringCellValue().toString());
                        case 25: employee.setOperationalLineManagerRoleReference(cell.getRichStringCellValue().toString());
                        case 26: employee.setCurrentResourceType(cell.getRichStringCellValue().toString());
                        case 27: employee.setTargetResourceType(cell.getRichStringCellValue().toString());
                        case 28: employee.setProjectedStartDateOfRole(cell.getRichStringCellValue().toString());
                        case 29: employee.setProjectedEndDateOfTerminatingRole(cell.getRichStringCellValue().toString());

//                            NB: This needs to be a Double or a Float as holds decimal value
                        case 30: employee.setfTE(cell.getNumericCellValue());


                        case 31: employee.setdDaTOrNonDDaTResource(cell.getRichStringCellValue().toString());
                            break;
                        default: break;
                    }
                    employeeList.add(employee);
                }
            }System.out.print(employeeList);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (excelFile != null) {
                excelFile.close();
            }
        }
        System.out.print(employeeList);
    }

}

