package fp.pages.elements;

import org.openqa.selenium.By;


/**
 * This class we are saving all our webelements w.r.t. Pages
 * Example: All Elements on Home Page will be saved in this class
 * @author Pavan
 *
 */
public interface UsersPageElements {

	By usersTitle=By.xpath("//div[@id='sticky-search-filter']//label[text()='Users' and @class='main__title center-inner-div']");
	By createUserButton=By.xpath("//button[@class='btn round ng-star-inserted']");
	By searchTextFeild=By.xpath("//label[@class='search ng-star-inserted']/input[@placeholder='Search by name, email, or phone number']");
	By selectClient=By.xpath("//div[text()='Client']");
	
	By clientNameTextField=By.xpath("//div[contains(text(),'Enter Client') and contains(text(),'Contact Info')]/parent::div//input[@placeholder='e.g. Abram Pattrick']");
	By clientPhoneTextField=By.xpath("//div[contains(text(),'Enter Client') and contains(text(),'Contact Info')]/parent::div//input[@placeholder='e.g. +1(917)720-7465']");
	
	By clientSetEmailAndpasswordTextFeild=By.xpath("//span[text()='Set Email & Password']");
	By clientEmailTextField=By.xpath("//div[contains(text(),'Set Email and Password')]/parent::div//input[@placeholder='e.g. abram@gmail.com']");
	By clientPasswordTextField=By.xpath("//div[contains(text(),'Set Email and Password')]/parent::div//input[@placeholder='Enter password']");
	
	By clientConfirmPasswordTextField=By.xpath("//div[contains(text(),'Set Email and Password')]/parent::div//input[@placeholder='Confirm password']");
	By clientAddInfoButton=By.xpath("//span[text()='Add Info']");
	
	By clientSchoolTextField=By.xpath("//div[contains(text(),'Enter Client') and contains(text(),'School Info')]/parent::div//input");
	By clientSchoolSelectDropdown=By.xpath("//ng-dropdown-panel//span");
	
	By clientPositionTextField=By.xpath("//div[text()='Position']/parent::div//input");
	//By clientorganizationText=By.xpath("//div[contains(text(),'Enter Client') and contains(text(),'School Info')]/parent::div//input/parent::div/parent::div/div[text()='e.g. Alpha Phi']");
	By clientOrganizationTextField=By.xpath("//div[contains(text(),'Organization') and contains(@class,'label')]//following::input[@role='combobox'][1]");
	By clientGradYearButton=By.xpath("//div[normalize-space()='2026']");
	By clientCreateAccountButton=By.xpath("//div[contains(text(),'Enter Client') and contains(text(),'School Info')]/parent::div//span[text()='Create Account']");
	
	By clientAccountCreatedTextField=By.xpath("//div[text()='Account Created!']");
	By clientBacktoworkButton=By.xpath("//span[text()='Back to Work']");
	
	By clientTableNames= By.xpath("//datatable-scroller//datatable-row-wrapper//div[@class='datatable-body-cell-label']//a");
	
	
			
	
	
}
