package fp.pages.elements;

import org.openqa.selenium.By;


/**
 * This class we are saving all our webelements w.r.t. Pages
 * Example: All Elements on Home Page will be saved in this class
 * @author Pavan
 *
 */
public interface LoginPageElements 
{
	By emailTextField= By.id("form-email");
	By passwordTextField= By.id("form-password");
	By signInButton=By.xpath("//button[text()='Sign in']");





}
