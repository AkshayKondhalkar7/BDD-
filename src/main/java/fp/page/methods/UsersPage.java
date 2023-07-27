package fp.page.methods;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import fp.base.WebDriverUtility;
import fp.pages.elements.UsersPageElements;


/**
 * This Class Takes care of all the repetitive methods(Business logic) which we are gonna perform on this page
 * 
 * @author Pavan
 *
 */
public class UsersPage extends WebDriverUtility
{	

	public String verifyclient(String nameofclient) {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		String nameofclientfromtable=null;

		List<WebElement> codes= getDriver().findElements(UsersPageElements.clientTableNames);
		for (int   j = 1;   j < 10;   j++) {
			try {
				for (int i = 0; i < codes.size(); i++)
				{
					nameofclientfromtable =codes.get(i).getText();
					if(nameofclientfromtable.equalsIgnoreCase(nameofclient))
					{
						System.out.println(nameofclientfromtable);	
						System.out.println("Element located successfully");
						//System.exit(0);
						break;
					}
					if(i==24) {
						throw new Exception();
					}
				}
			} catch (Exception e) {
				int k=j+1;
				WebElement element	= getDriver().findElement(By.xpath("//ul[@class='pager']//li[contains(@aria-label,'page')]/a[normalize-space()='"+k+"']"));
				scrollToBottom();
				js.executeScript("arguments[0].click();", element);
			}
		}

		System.out.println("Succesfully verified");
		return nameofclientfromtable;
	}


	public String verifyClientName (String emailofclient,String key) throws Exception 
	{
		enterData(UsersPageElements.searchTextFeild, emailofclient);
		Thread.sleep(2000);
		HashMap<String, String> tabledata1 = readDatafromDashboardTable();

		return tabledata1.get(key);



	}

	public HashMap<String, String> readDatafromDashboardTable()
	{

		HashMap<String, String> tabledata=new HashMap<>();
		List<WebElement> tableheaderkey=getDriver().findElements(By.xpath("//div[contains(@class,'datatable-row-center')]/datatable-header-cell//span[@class='datatable-header-cell-label draggable']"));
		List<WebElement> tablevalue=getDriver().findElements(By.xpath("//div[contains(@class,'datatable-row-center')]/datatable-body-cell"));

		for (int i = 0; i <tableheaderkey.size(); i++) 
		{
			tabledata.put(tableheaderkey.get(i).getText(), tablevalue.get(i).getText());
		}
		System.out.println(tabledata);

		return tabledata;

	}



}
