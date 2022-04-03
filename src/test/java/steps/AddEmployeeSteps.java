package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AddEmployeePage;
import pages.DashboardPage;
import utils.CommonMethods;
import utils.Constants;
import utils.ExelReading;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        DashboardPage dash=new DashboardPage();
        click(dash.pimOption);
    }
    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
      DashboardPage dash=new DashboardPage();
      click(dash.addEmployeeButton);
    }
    @When("user enters firstname middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        AddEmployeePage addEmployeePage=new AddEmployeePage();
        sendText(addEmployeePage.firstName, "Matvey76");
        sendText(addEmployeePage.middleName, "grigo23");
        sendText(addEmployeePage.lastName, "petrovskiy93");
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
       AddEmployeePage addEmployeePage=new AddEmployeePage();
       click(addEmployeePage.saveBtn);
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added successfully");
    }

    @When("user deletes employee id")
    public void user_deletes_employee_id() {
        AddEmployeePage addEmployeePage=new AddEmployeePage();
        addEmployeePage.employeeID.clear();
    }

    @When("user selects checkbox")
    public void user_selects_checkbox() {
        AddEmployeePage addEmployeePage=new AddEmployeePage();
        click(addEmployeePage.createLoginCheckBox);
    }
    @When("user enters username password and confirm password")
    public void user_enters_username_password_and_confirm_password() {
      AddEmployeePage addEmployeePage=new AddEmployeePage();
      sendText(addEmployeePage.createUsername, "starinthesky");
      sendText(addEmployeePage.createPassword, "Syntax!!!123");
      sendText(addEmployeePage.rePassword,"Syntax!!!123");
    }

    @When("user enters {string} {string} and {string}")
    public void user_enters_and(String firstName, String middleName, String lastName) {
        AddEmployeePage addEmployeePage=new AddEmployeePage();
        sendText(addEmployeePage.firstName, firstName);
        sendText(addEmployeePage.middleName, middleName);
        sendText(addEmployeePage.lastName, lastName);

    }
    @When("user enters {string} {string} and {string} an the employee")
    public void user_enters_and_an_the_employee(String firstName, String middleName, String lastName) {
        AddEmployeePage addEmployeePage=new AddEmployeePage();
        sendText(addEmployeePage.firstName, firstName);
        sendText(addEmployeePage.middleName, middleName);
        sendText(addEmployeePage.lastName, lastName);
    }


    @When("I add multiple employee and verify them that user has been added successfully")
    public void i_add_multiple_employee_and_verify_them_that_user_has_been_added_successfully(DataTable employees) throws InterruptedException {

        List<Map<String, String>> employeeNames = employees.asMaps();

        for (Map<String,String> employeeName:employeeNames){
            String valueFirstName=employeeName.get("firstName");
            String valueMiddleName=employeeName.get("middleName");
            String valueLastName=employeeName.get("lastName");

            AddEmployeePage addEmployeePage=new AddEmployeePage();
            sendText(addEmployeePage.firstName, valueFirstName);
            sendText(addEmployeePage.middleName, valueMiddleName);
            sendText(addEmployeePage.lastName, valueLastName);
            click(addEmployeePage.saveBtn);

            //assertion
            //verify the employee has been added
            DashboardPage dash=new DashboardPage();
            click(dash.addEmployeeButton);
            Thread.sleep(3000);


        }
    }
    @When("user adds multiple employees from exel file using {string} sheet and verify the added employee")
    public void user_adds_multiple_employees_from_exel_file_using_sheet_and_verify_the_added_employee (String sheetName) {

        List<Map<String,String>> newEmployees= ExelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH, sheetName);
        DashboardPage dash=new DashboardPage();
        AddEmployeePage add=new AddEmployeePage();

        Iterator<Map<String,String>> it= newEmployees.iterator();
        while(it.hasNext()){
            Map<String,String> mapNewEmp=it.next();
            sendText(add.firstName, mapNewEmp.get("FirstName"));
            sendText(add.middleName, mapNewEmp.get("MiddleName"));
            sendText(add.lastName, mapNewEmp.get("LastName"));
            click(add.saveBtn);
            click(dash.addEmployeeButton);
            //assertion

            click(dash.addEmployeeButton);

    }
}}
