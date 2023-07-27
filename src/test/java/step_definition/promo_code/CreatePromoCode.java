package step_definition.promo_code;

import java.io.IOException;

import fp.base.CreateRandomNumbers;
import fp.base.WebDriverUtility;
import fp.page.methods.LoginPage;
import fp.pages.elements.HomePageElements;
import fp.pages.elements.PromoCodePageElements;
import io.cucumber.java.en.*;

public class CreatePromoCode extends WebDriverUtility
{
	
	  String promocode= "PROMOCODE_"+CreateRandomNumbers.randomNumber();

	@Given("enter username {string} and password {string}")
	public void enter_username_and_password(String username, String password) throws IOException, Exception {
	   LoginPage loginPage= new LoginPage();
	   loginPage.loginToApplication(username, password);
	}

	@Then("click on loginbtn")
	public void click_on_loginbtn() {
	    
	}

	@Then("validate login is successful")
	public void validate_login_is_successful() {
	   String title=getDriver().getTitle();
	   System.out.println(title);
	}

	@Then("click on promocode icon")
	public void click_on_promocode_icon() throws Exception {
	   clickElementJS(HomePageElements.promocodeIcon);
	}

	@Then("validate user is on promocodepage")
	public void validate_user_is_on_promocodepage() throws Exception {
	   String data=getData(PromoCodePageElements.promocodePageTitleText);
	   System.out.println(data);
	}

	@Given("click on create promo code")
	public void click_on_create_promo_code() throws Exception {
	   clickElement(PromoCodePageElements.createPromocodeButton1st);
	}

	@Then("enter promocode name")
	public void enter_promocode_name() throws Exception {
	    enterData(PromoCodePageElements.groupPromocodeTextField, promocode);
	}

	@Then("select type as {string} and enter {string}")
	public void select_type_as_and_enter(String type, String value) throws Exception
	{
		if(type.equalsIgnoreCase("Percentage"))
		{
			clickElement(PromoCodePageElements.typePercentage);
			enterData(PromoCodePageElements.percentageOffTextField, value);
		}
		else if(type.equalsIgnoreCase("Fixed Amount"))
		{
			clickElement(PromoCodePageElements.typeFixedAmount);
			enterData(PromoCodePageElements.amountOffTextField, value);
		}
		else if(type.equalsIgnoreCase("Free Shipping")) 
		{
			clickElement(PromoCodePageElements.typeFixedAmount);
			enterData(PromoCodePageElements.amountOffTextField, value);
		}
		else if(type.equalsIgnoreCase("Organizer Pays")) {
			
		}
		else {
			System.out.println("Invalid type");
		}
	}

	@Then("select limit as {string} and enter {string}")
	public void select_limit_as_and_enter(String limit, String totallimiusage) throws Exception 
	{
	   if(limit.equalsIgnoreCase("1x per person")) {
		   clickElement(PromoCodePageElements.limit1PerPerson);
	   }
	   
	   else if(limit.equalsIgnoreCase("set usage limit")) {
		   
	   }
	}

	@Then("check on allgroup orders")
	public void check_on_allgroup_orders() throws Exception {
	clickElement(PromoCodePageElements.allGroupOrdersCheckbox);
	}

	@Then("enter start date {string} and {string}")
	public void enter_start_date_and(String string, String string2) {
	   
	}

	@Then("entar end date {string} and {string}")
	public void entar_end_date_and(String string, String string2) {
	   
	}

	@Then("click on create group order promocode")
	public void click_on_create_group_order_promocode() {
	   
	}
	
}
