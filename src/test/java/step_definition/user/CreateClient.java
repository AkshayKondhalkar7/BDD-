package step_definition.user;

import java.io.IOException;

import org.testng.Assert;

import fp.base.CreateRandomNumbers;
import fp.base.FakeData;
import fp.base.WebDriverUtility;
import fp.page.methods.LoginPage;
import fp.page.methods.UsersPage;
import fp.pages.elements.HomePageElements;
import fp.pages.elements.UsersPageElements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


/**
 * This class is having step definition (methods) 
 * Whatever lines we have written in feature file for that each line we will have a seprate method here 
 *
 * @author Pavan
 *
 */
public class CreateClient extends WebDriverUtility
{
	UsersPage usersPage = new UsersPage();
	String emailOfClient=null;
	String nameOfClient=null;

	@Given("login into application")
	public void login_into_application() throws IOException, Exception 
	{
		LoginPage loginPage= new LoginPage();
		loginPage.loginToApplication();	
	}

	@Then("v3 order title is shown as expected")
	public void verify_v3_order_title() {
		String urlExpected ="https://v3-staging-as.freshprints.com/dashboard/orders";
		String urlActual=super.getDriver().getCurrentUrl();
		System.out.println("Url is-->"+urlActual);
		super.softAssert().assertEquals(urlActual, urlExpected,"URL does not match");
	}

	@Then("Navigate user page")
	public void navigate_user_page() throws Exception 
	{

		super.clickElementJS(HomePageElements.usersIcon);
		String data=super.getData(UsersPageElements.usersTitle);
		System.out.println(data);
		super.softAssert().assertEquals(data, "Users","Page Title not matching");
	}

	@Then("click on create user")
	public void click_on_create_user() throws Exception {
		super.clickElementJS(UsersPageElements.createUserButton);

	}

	@Then("click on client")
	public void click_on_client() throws Exception {
		super.clickElementJS(UsersPageElements.selectClient);
	}

	@Then("enter all details required for client")
	public void enter_all_details_required_for_client() throws Exception
	{
		nameOfClient	=FakeData.getFullName();
		super.enterData(UsersPageElements.clientNameTextField,nameOfClient );
		String phoneNumber= CreateRandomNumbers.randomizePhoneNo();
		super.enterData(UsersPageElements.clientPhoneTextField, phoneNumber);
		super.clickElement(UsersPageElements.clientSetEmailAndpasswordTextFeild);

		// Remove White space from string;
		String emailPrefix =nameOfClient.replaceAll("\\s", "");

		String email=emailPrefix+CreateRandomNumbers.randomNumber()+"@gmail.com";
		emailOfClient=email;
		super.enterData(UsersPageElements.clientEmailTextField, email);
		super.enterData(UsersPageElements.clientPasswordTextField, "123");
		super.enterData(UsersPageElements.clientConfirmPasswordTextField, "123");
		clickElement(UsersPageElements.clientAddInfoButton);

		super.enterData(UsersPageElements.clientSchoolTextField, "Albion College");

		super.clickElement(UsersPageElements.clientSchoolSelectDropdown);


		super.	clickElementJS(UsersPageElements.clientOrganizationTextField);

		super.	enterData(UsersPageElements.clientOrganizationTextField, "2023 Class Council");

		super.clickElement(UsersPageElements.clientSchoolSelectDropdown);

		super.enterData(UsersPageElements.clientPositionTextField, "NA");
		super.scrollToBottom();
		super.	clickElement(UsersPageElements.clientGradYearButton);

	}

	@Then("submit the info")
	public void submit_the_info() throws Exception {
		super.clickElement(UsersPageElements.clientCreateAccountButton);
	}

	@Then("Navigate to dashboard")
	public void navigate_to_dashboard() throws Exception {
		super.scrollToBottom();
		super.clickElement(UsersPageElements.clientBacktoworkButton);
	}

	@Then("verify client is created")
	public void verify_client_is_created() throws Exception
	{
		String	actualnameofclient=usersPage.verifyClientName(emailOfClient, "Full name");
		Assert.assertEquals(actualnameofclient, nameOfClient);

	}



	@Then("enter all {string} {string} {string} {string} {string} {string} {string} details reqd for client")
	public void enter_all_details_reqd_for_client(String name, String phone, String email, String pwd, String school, String organization, String position) throws Exception {
		nameOfClient=name;
		super.enterData(UsersPageElements.clientNameTextField, name);
		super.enterData(UsersPageElements.clientPhoneTextField, phone);
		super.clickElement(UsersPageElements.clientSetEmailAndpasswordTextFeild);

		String newemail=email+CreateRandomNumbers.randomNumber()+"@gmail.com";
		emailOfClient=newemail;
		super.enterData(UsersPageElements.clientEmailTextField, newemail);
		super.enterData(UsersPageElements.clientPasswordTextField, pwd);
		super.enterData(UsersPageElements.clientConfirmPasswordTextField, pwd);
		clickElement(UsersPageElements.clientAddInfoButton);

		super.enterData(UsersPageElements.clientSchoolTextField, school);

		super.clickElement(UsersPageElements.clientSchoolSelectDropdown);


		super.clickElementJS(UsersPageElements.clientOrganizationTextField);

		super.enterData(UsersPageElements.clientOrganizationTextField, organization);

		super.clickElement(UsersPageElements.clientSchoolSelectDropdown);

		super.enterData(UsersPageElements.clientPositionTextField, position);
		super.scrollToBottom();
		super.clickElement(UsersPageElements.clientGradYearButton);
		
	}
}