package gov.homeoffice.ctoWorkforceSearch.Service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gov.homeoffice.ctoWorkforceSearch.Model.Employee;

public class ReadExcel {

    //    NB: Excel file
    private static final String FILE_NAME = "/home/cdp/Downloads/ctoWorkforceSearch/src/main/resources/input/CTOAggregatedColumns_anonTestData_excel.xlsx";

    public static void buildArray() throws Exception {

        List<Employee> employeeList = new ArrayList<>();

        FileInputStream excelFile = null;

        try {
            excelFile = new FileInputStream(FILE_NAME);
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();
            Employee employee = new Employee();

            if (iterator.hasNext())
                iterator.next();

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
//                NB: Further investigate Iterator<Cell>

                for (int i = 0; i < 31; i++) {
                    Cell cell = cellIterator.next();
                    System.out.println("Cell Column index-----" + cell.getColumnIndex());

//                        NB: Each Case statement corresponds to a column - some have added loggers for visibility
                    switch (i) {
                        case 0: employee.setRoleRef(cell.getStringCellValue());
                            System.out.println(cell.getRichStringCellValue().toString());
                            System.out.println("Cell Column index-----" + cell.getColumnIndex() + "Row index-----" + cell.getRowIndex());


                        case 1: employee.setRoleTitle(cell.getRichStringCellValue().toString());
                        case 2: employee.setEmployeeFirstName(cell.getRichStringCellValue().toString());
                        case 3: employee.setEmployeeSurname(cell.getRichStringCellValue().toString());
                        case 4: employee.setEmployeeFullName(cell.getRichStringCellValue().toString());

//                            NB: previous code
//                            case 5: employee.setEmployeeAdelphiNumber(cell.getNumericCellValue());


                        case 5: if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                            employee.setEmployeeAdelphiNumber(cell.getNumericCellValue());}
//                                else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
//                                    employee.setEmployeeAdelphiNumber(Double.parseDouble(cell.getRichStringCellValue()));
//                            }
                            System.out.println("Case 5 CellType is " + cell.getCellTypeEnum());
                            System.out.println("Cell Column index-----" + cell.getColumnIndex());

//                            case 6: employee.setEmployeeEmail(cell.getRichStringCellValue().toString());
                        case 6: System.out.println("Case 6 CellType is " + cell.getCellTypeEnum() + " with value= " + cell.getRichStringCellValue().toString() + "Cell Column index-----" + cell.getColumnIndex());


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

                        case 30: if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                            employee.setfTE(cell.getNumericCellValue());
                        }
                            System.out.println("Case 30 CellType is " + cell.getCellTypeEnum());


                        case 31: employee.setdDaTOrNonDDaTResource(cell.getRichStringCellValue().toString());
                            break;
                        default: break;
                    }
                    employeeList.add(employee);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (excelFile != null) {
                excelFile.close();
            }
        }
//        System.out.print(employeeList);
    }

}

