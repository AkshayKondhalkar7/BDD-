package fp.pages.elements;

import org.openqa.selenium.By;

public interface PromoCodePageElements {

	
	By promocodePageTitleText=By.xpath("//label[@class='main__title center-inner-div']");
	By createPromocodeButton1st=By.xpath("//button[@class='btn round create ng-star-inserted']");
	
	By groupPromocodeTextField=By.xpath("//input[@id='null']");
	By typePercentage=By.xpath("//span[@xpath='1']/parent::div");  
	By percentageOffTextField=By.id("percentage-input");
	By typeFixedAmount=By.xpath("//span[text()='Participants will get this amount off on the total amount of their order.']/parent::div");
	By limit1PerPerson= By.xpath("//span[text()='Can be used one time per participant.']/parent::div");
	By appliesToTextField=By.xpath("//div[text()='Select Group Order']/parent::div//input");
	By appliesToDropDownSuggestion=By.xpath("//div[@class='ng-option ng-option-marked ng-star-inserted']");
	By allGroupOrdersCheckbox=By.xpath("//span[text()='All Group Orders']");
	By startDateText = By.xpath("//app-datepicker[@formcontrolname='startDate']//input");
	By startTimeDropDown = By.xpath("//app-select[@formcontrolname='startTime']//ng-select");
	
	By endDateText =By.xpath("//app-datepicker[@formcontrolname='endDate']//input");
	By endTimeDropdown = By.xpath("//app-select[@formcontrolname='endTime']//ng-select");
	By createGroupCodeButton=By.xpath("//span[text()='Create Group Order Promo Code']");
	By amountOffTextField = By.id("amount-input");
	
	
	
	
	
	
	
	
	
}
