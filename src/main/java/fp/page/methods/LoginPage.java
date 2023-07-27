package fp.page.methods;

import fp.base.WebDriverUtility;
import fp.pages.elements.LoginPageElements;

/**
 * This Class Takes care of all the repetitive methods(Business logic) which we are gonna perform on this page
 * 
 * @author Pavan
 *
 */
public class LoginPage extends WebDriverUtility implements LoginPageElements
{

	public  void loginToApplication() throws Exception 
	{	
	
		this.loginToApplication(getPropertyFileUtils().getData("username"), getPropertyFileUtils().getData("password"));		
	}
	
	public  void loginToApplication(String username,String password) throws Exception  
	{
		enterData(emailTextField, username);
		enterData(passwordTextField,password);
		clickElement(signInButton);		
	}
	
}
