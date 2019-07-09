package gov.homeoffice.workforceDashboard.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    private String roleRef;
    private String roleTitle;
    private String employeeFirstName;
    private String employeeSurname;
    @Id
    private String employeeFullName;
    private Integer employeeAdelphiNumber;
    private String employeeEmail;
    private String gradeEquivalent;
    private String function;
    private String businessUnit;
    private String team;
    private String professionCluster;
    private String dDaTProfessionRole;
    private String affiliatedDdaTProfessionRole;
    private String currentResourceRollUp;
    private String functionRollUp;
    private String employeeCurrentPrimaryLocation;
    private String employeeAnticipatedFutureLocation;
    private String eUExit;
    private String isThisRoleAVacancy;
    private String vacancyType;
    private Double vacancyStage;
    private String rechargedRoles;
    private String operationalLineManagerFirstName;
    private String operationalLineManagerSurname;
    private String operationalLineManagerRoleReference;
    private String currentResourceType;
    private String targetResourceType;
    private String projectedStartDateOfRole;
    private String projectedEndDateOfTerminatingRole;
    private Double fTE;
    private String dDaTOrNonDDaTResource;

    public Employee() {
    }

    public Employee(String roleRef, String roleTitle, String employeeFirstName, String employeeSurname, String employeeFullName, Integer employeeAdelphiNumber, String employeeEmail, String gradeEquivalent, String function, String businessUnit, String team, String professionCluster, String dDaTProfessionRole, String affiliatedDdaTProfessionRole, String currentResourceRollUp, String functionRollUp, String employeeCurrentPrimaryLocation, String employeeAnticipatedFutureLocation, String eUExit, String isThisRoleAVacancy, String vacancyType, Double vacancyStage, String rechargedRoles, String operationalLineManagerFirstName, String operationalLineManagerSurname, String operationalLineManagerRoleReference, String currentResourceType, String targetResourceType, String projectedStartDateOfRole, String projectedEndDateOfTerminatingRole, Double fTE, String dDaTOrNonDDaTResource) {
        this.roleRef = roleRef;
        this.roleTitle = roleTitle;
        this.employeeFirstName = employeeFirstName;
        this.employeeSurname = employeeSurname;
        this.employeeFullName = employeeFullName;
        this.employeeAdelphiNumber = employeeAdelphiNumber;
        this.employeeEmail = employeeEmail;
        this.gradeEquivalent = gradeEquivalent;
        this.function = function;
        this.businessUnit = businessUnit;
        this.team = team;
        this.professionCluster = professionCluster;
        this.dDaTProfessionRole = dDaTProfessionRole;
        this.affiliatedDdaTProfessionRole = affiliatedDdaTProfessionRole;
        this.currentResourceRollUp = currentResourceRollUp;
        this.functionRollUp = functionRollUp;
        this.employeeCurrentPrimaryLocation = employeeCurrentPrimaryLocation;
        this.employeeAnticipatedFutureLocation = employeeAnticipatedFutureLocation;
        this.eUExit = eUExit;
        this.isThisRoleAVacancy = isThisRoleAVacancy;
        this.vacancyType = vacancyType;
        this.vacancyStage = vacancyStage;
        this.rechargedRoles = rechargedRoles;
        this.operationalLineManagerFirstName = operationalLineManagerFirstName;
        this.operationalLineManagerSurname = operationalLineManagerSurname;
        this.operationalLineManagerRoleReference = operationalLineManagerRoleReference;
        this.currentResourceType = currentResourceType;
        this.targetResourceType = targetResourceType;
        this.projectedStartDateOfRole = projectedStartDateOfRole;
        this.projectedEndDateOfTerminatingRole = projectedEndDateOfTerminatingRole;
        this.fTE = fTE;
        this.dDaTOrNonDDaTResource = dDaTOrNonDDaTResource;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "roleRef='" + roleRef + '\'' +
                ", roleTitle='" + roleTitle + '\'' +
                ", employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeSurname='" + employeeSurname + '\'' +
                ", employeeFullName='" + employeeFullName + '\'' +
                ", employeeAdelphiNumber='" + employeeAdelphiNumber + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", gradeEquivalent='" + gradeEquivalent + '\'' +
                ", function='" + function + '\'' +
                ", businessUnit='" + businessUnit + '\'' +
                ", team='" + team + '\'' +
                ", professionCluster='" + professionCluster + '\'' +
                ", dDaTProfessionRole='" + dDaTProfessionRole + '\'' +
                ", affiliatedDdaTProfessionRole='" + affiliatedDdaTProfessionRole + '\'' +
                ", currentResourceRollUp='" + currentResourceRollUp + '\'' +
                ", functionRollUp='" + functionRollUp + '\'' +
                ", employeeCurrentPrimaryLocation='" + employeeCurrentPrimaryLocation + '\'' +
                ", employeeAnticipatedFutureLocation='" + employeeAnticipatedFutureLocation + '\'' +
                ", eUExit='" + eUExit + '\'' +
                ", isThisRoleAVacancy='" + isThisRoleAVacancy + '\'' +
                ", vacancyType='" + vacancyType + '\'' +
                ", vacancyStage='" + vacancyStage + '\'' +
                ", rechargedRoles='" + rechargedRoles + '\'' +
                ", operationalLineManagerFirstName='" + operationalLineManagerFirstName + '\'' +
                ", operationalLineManagerSurname='" + operationalLineManagerSurname + '\'' +
                ", operationalLineManagerRoleReference='" + operationalLineManagerRoleReference + '\'' +
                ", currentResourceType='" + currentResourceType + '\'' +
                ", targetResourceType='" + targetResourceType + '\'' +
                ", projectedStartDateOfRole='" + projectedStartDateOfRole + '\'' +
                ", projectedEndDateOfTerminatingRole='" + projectedEndDateOfTerminatingRole + '\'' +
                ", fTE='" + fTE + '\'' +
                ", dDaTOrNonDDaTResource='" + dDaTOrNonDDaTResource + '\'' +
                '}';
    }


    public String getRoleRef() {
        return roleRef;
    }

    public void setRoleRef(String roleRef) {
        this.roleRef = roleRef;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    public String getEmployeeFullName() {
        return employeeFullName;
    }

    public void setEmployeeFullName(String employeeFullName) {
        this.employeeFullName = employeeFullName;
    }

    public Integer getEmployeeAdelphiNumber() {
        return employeeAdelphiNumber;
    }

    public void setEmployeeAdelphiNumber(Integer employeeAdelphiNumber) {
        this.employeeAdelphiNumber = employeeAdelphiNumber;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getGradeEquivalent() {
        return gradeEquivalent;
    }

    public void setGradeEquivalent(String gradeEquivalent) {
        this.gradeEquivalent = gradeEquivalent;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getProfessionCluster() {
        return professionCluster;
    }

    public void setProfessionCluster(String professionCluster) {
        this.professionCluster = professionCluster;
    }

    public String getdDaTProfessionRole() {
        return dDaTProfessionRole;
    }

    public void setdDaTProfessionRole(String dDaTProfessionRole) {
        this.dDaTProfessionRole = dDaTProfessionRole;
    }

    public String getAffiliatedDdaTProfessionRole() {
        return affiliatedDdaTProfessionRole;
    }

    public void setAffiliatedDdaTProfessionRole(String affiliatedDdaTProfessionRole) {
        this.affiliatedDdaTProfessionRole = affiliatedDdaTProfessionRole;
    }

    public String getCurrentResourceRollUp() {
        return currentResourceRollUp;
    }

    public void setCurrentResourceRollUp(String currentResourceRollUp) {
        this.currentResourceRollUp = currentResourceRollUp;
    }

    public String getFunctionRollUp() {
        return functionRollUp;
    }

    public void setFunctionRollUp(String functionRollUp) {
        this.functionRollUp = functionRollUp;
    }

    public String getEmployeeCurrentPrimaryLocation() {
        return employeeCurrentPrimaryLocation;
    }

    public void setEmployeeCurrentPrimaryLocation(String employeeCurrentPrimaryLocation) {
        this.employeeCurrentPrimaryLocation = employeeCurrentPrimaryLocation;
    }

    public String getEmployeeAnticipatedFutureLocation() {
        return employeeAnticipatedFutureLocation;
    }

    public void setEmployeeAnticipatedFutureLocation(String employeeAnticipatedFutureLocation) {
        this.employeeAnticipatedFutureLocation = employeeAnticipatedFutureLocation;
    }

    public String geteUExit() {
        return eUExit;
    }

    public void seteUExit(String eUExit) {
        this.eUExit = eUExit;
    }

    public String getIsThisRoleAVacancy() {
        return isThisRoleAVacancy;
    }

    public void setIsThisRoleAVacancy(String isThisRoleAVacancy) {
        this.isThisRoleAVacancy = isThisRoleAVacancy;
    }

    public String getVacancyType() {
        return vacancyType;
    }

    public void setVacancyType(String vacancyType) {
        this.vacancyType = vacancyType;
    }

    public Double getVacancyStage() {
        return vacancyStage;
    }

    public void setVacancyStage(Double vacancyStage) {
        this.vacancyStage = vacancyStage;
    }

    public String getRechargedRoles() {
        return rechargedRoles;
    }

    public void setRechargedRoles(String rechargedRoles) {
        this.rechargedRoles = rechargedRoles;
    }

    public String getOperationalLineManagerFirstName() {
        return operationalLineManagerFirstName;
    }

    public void setOperationalLineManagerFirstName(String operationalLineManagerFirstName) {
        this.operationalLineManagerFirstName = operationalLineManagerFirstName;
    }

    public String getOperationalLineManagerSurname() {
        return operationalLineManagerSurname;
    }

    public void setOperationalLineManagerSurname(String operationalLineManagerSurname) {
        this.operationalLineManagerSurname = operationalLineManagerSurname;
    }

    public String getOperationalLineManagerRoleReference() {
        return operationalLineManagerRoleReference;
    }

    public void setOperationalLineManagerRoleReference(String operationalLineManagerRoleReference) {
        this.operationalLineManagerRoleReference = operationalLineManagerRoleReference;
    }

    public String getCurrentResourceType() {
        return currentResourceType;
    }

    public void setCurrentResourceType(String currentResourceType) {
        this.currentResourceType = currentResourceType;
    }

    public String getTargetResourceType() {
        return targetResourceType;
    }

    public void setTargetResourceType(String targetResourceType) {
        this.targetResourceType = targetResourceType;
    }

    public String getProjectedStartDateOfRole() {
        return projectedStartDateOfRole;
    }

    public void setProjectedStartDateOfRole(String projectedStartDateOfRole) {
        this.projectedStartDateOfRole = projectedStartDateOfRole;
    }

    public String getProjectedEndDateOfTerminatingRole() {
        return projectedEndDateOfTerminatingRole;
    }

    public void setProjectedEndDateOfTerminatingRole(String projectedEndDateOfTerminatingRole) {
        this.projectedEndDateOfTerminatingRole = projectedEndDateOfTerminatingRole;
    }

    public Double getfTE() {
        return fTE;
    }

    public void setfTE(Double fTE) {
        this.fTE = fTE;
    }

    public String getdDaTOrNonDDaTResource() {
        return dDaTOrNonDDaTResource;
    }

    public void setdDaTOrNonDDaTResource(String dDaTOrNonDDaTResource) {
        this.dDaTOrNonDDaTResource = dDaTOrNonDDaTResource;
    }
}
