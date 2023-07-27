package fp.pages.elements;

import org.openqa.selenium.By;


/**
 * This class we are saving all our WebElements w.r.t. Pages
 * Example: All Elements on Home Page will be saved in this class
 * @author Pavan
 *
 */
public interface HomePageElements
{

	By usersIcon= By.xpath("//span[text()='Users']");
	By ordersIcon = By.xpath("//span[text()='Orders']");
	By logoutDropdown=By.xpath("//li[@id='userdropdown-info']//img");
	By logoutButton = By.xpath("//span[text()='Logout']");
	By ordersText=By.xpath("//div[@class='page-title']//span");
	By promocodeIcon=By.xpath("//img[@src='/images/promo-code.png']");
	
	
	
}
