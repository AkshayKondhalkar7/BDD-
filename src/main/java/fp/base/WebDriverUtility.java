package fp.base;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.google.common.util.concurrent.Uninterruptibles;

import fp.property.file.utility.PropertyFileUtility;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
/**
 *	This Class Have our all the webdriver methods(click,sendkeys,findelement and etc)
 *This Class is Inherited by all classes
 * @author Pavan
 *
 */
public class WebDriverUtility
{
	
	private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>() ;

	public static WebDriver getDriver() {
		return driverThread.get();
	}

	protected static void setDriver(WebDriver driverReference) {
		if(Objects.nonNull(driverReference)) {
			driverThread.set(driverReference);
		}
	}

	static void unloadDriver() {
		driverThread.remove();
	}


	private static ThreadLocal<PropertyFileUtility> propertyThread = new ThreadLocal<>() ;

	public static PropertyFileUtility getPropertyFileUtils() {
		return propertyThread.get();
	}

	protected static void setPropertyFile(PropertyFileUtility propFile) {
		if(Objects.nonNull(propFile)) {
			propertyThread.set(propFile);
		}
	}

	static void unloadPropertyFile() {
		propertyThread.remove();
	}


	public void waitForElement(By elementLocator) 
	{
		WebDriverWait webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
	}
	

	public void enterData(By elementLocator, String data) throws Exception {
		try {
			
			waitForElement(elementLocator);
			clearData(elementLocator);
			getDriver().findElement(elementLocator).sendKeys(data);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to Enter Data in: " + elementLocator + ". " + e.getMessage());
		}
	}

	public void clearData(By elementLocator) throws Exception {
		try {
			waitForElement(elementLocator);
			getDriver().findElement(elementLocator).clear();

			getDriver().findElement(elementLocator).sendKeys("");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to Clear Data in the locator" + elementLocator + ". " + e.getMessage());
		}
	}

	public String getData(By elementLocator) throws Exception {
		String data = null;
		try {
			waitForElement(elementLocator);
			data = getDriver().findElement(elementLocator).getText();
			System.out.println(data);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to Get Data from the Locator: " + elementLocator + ". " + e.getMessage());
		}
		return data;
	}

	public Boolean clickElement(By elementLocator) throws Exception {
		Boolean flag = null;
		flag = getDriver().findElement(elementLocator).isDisplayed();

		try {
			waitForElement(elementLocator);
			getDriver().findElement(elementLocator).click();


		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to click: " + elementLocator + ". " + e.getMessage());
		}
		return flag;
	}

	public void clickTab(By elementLocator) throws Exception {
		try {
			waitForElement(elementLocator);
			getDriver().findElement(elementLocator).sendKeys(Keys.TAB);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to click Tab on: " + elementLocator + ". " + e.getMessage());
		}
	}

	public void clickHomeKey(By elementLocator) throws Exception {
		try {
			waitForElement(elementLocator);
			getDriver().findElement(elementLocator).sendKeys(Keys.HOME);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to click Home Key. " + e.getMessage());
		}
	}

	public boolean findElementPresence(By elementLocator) throws Exception {
		int size = 0;
		try {
			size = getDriver().findElements(elementLocator).size();

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to Find Element with Locator: " + elementLocator + ". " + e.getMessage());
		}
		return size > 0 ? true : false;
	}



	public void sleepFor(long milliseconds) {
		Uninterruptibles.sleepUninterruptibly(milliseconds, TimeUnit.MILLISECONDS);
	}

	public void hoverOver(By elementLocator) {
		try {
			waitForElement(elementLocator);
			Actions action = new Actions(getDriver());
			action.moveToElement(getDriver().findElement(elementLocator)).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void hoverOverWithEnteringData(By elementLocator) {
		try {
			
			Actions action = new Actions(getDriver());
			action.moveToElement(getDriver().findElement(elementLocator));
			action.click().build().perform();
			action.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			action.sendKeys(Keys.DELETE);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scrollToElement(By locator) {
		WebElement element = getDriver().findElement(locator);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public Boolean clickElementJS(By locator) throws Exception {
		Boolean flag = true;
		try {

			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].click()", getDriver().findElement(locator));
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
			throw new Exception("Unable to Click " + locator.toString());
		}
		return flag;
	}



	public void scrollToTop() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	}

	public void scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public void executeJS(String command, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript(command, element);
	}

	public void executeJS(String command) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript(command);
	}

	public void enterDataJs(By locator, String data) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].value=" + data + ";", getDriver().findElement(locator));
	}

	public String readDataUsingJavascriptExecutor(String jsLocator) {
		String elementText = "";
		try {
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			elementText = (String) js.executeScript("return document.querySelector('" + jsLocator + "').value");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(jsLocator + " is not a valid JS Locator");
		}

		return elementText;
	}

	public String readDataUsingJavascriptExecutorFromCSSLocator(String jsLocator) throws Exception {
		String elementText = "";
		try {
			scrollToElement(By.cssSelector(jsLocator));
			JavascriptExecutor js = (JavascriptExecutor) getDriver();

			elementText = (String) js.executeScript("return document.querySelector(\"" + jsLocator + "\").value");

			if (Objects.isNull(elementText) || elementText == "" || elementText.equalsIgnoreCase("")) {
				throw new Exception("No Data Found in the element with Locator: " + jsLocator);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return elementText;
	}

	public void setDataUsingJavascriptExecutor(String jsLocator, String data) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) getDriver();

			js.executeScript("document.querySelector('" + jsLocator + "').click;");
			js.executeScript("document.querySelector('" + jsLocator + "').value=" + data + ";");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getAttributeValue(By locator, String attribute) {
		return getDriver().findElement(locator).getAttribute(attribute);
	}

	public void switchToFrame(String frameName) throws Exception {
		try {
			if (frameName.equalsIgnoreCase("parent")) {
				getDriver().switchTo().parentFrame();
			} else {
				getDriver().switchTo().frame(frameName);
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void openYopMail() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
		getDriver().switchTo().window(tabs.get(1));
		getDriver().get("https://yopmail.com/en/");
	}

	public void chooseAndUploadFile(String location) throws Exception {
		Robot rb = new Robot();
		StringSelection str = new StringSelection(location);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			rb.keyPress(KeyEvent.VK_META);
			rb.keyPress(KeyEvent.VK_V);

			rb.keyRelease(KeyEvent.VK_META);
			rb.keyRelease(KeyEvent.VK_V);

			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		} else {
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);

			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);

			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		}	
	}
	public void waitForElementToBeClickable(By locator)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public SoftAssert softAssert() {
		SoftAssert softAssert = new SoftAssert();
		return softAssert;
	}

	public boolean isElementExists(By locator){
		return getDriver().findElements(locator).size() > 0;
	}


	public boolean waitForElement(int timeInSeconds, By locator){
		try{
			for(int i=0;i<timeInSeconds;i++){
				if(isElementExists(locator))
					return true;
				Thread.sleep(1000);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	public byte[] takeScreenshot()
	{
		TakesScreenshot scrShot =((TakesScreenshot)getDriver());
		return scrShot.getScreenshotAs(OutputType.BYTES);

	}

	public void takeFullPageScreenshot() throws IOException {
		Screenshot screenshot = new AShot().takeScreenshot(getDriver());
		ImageIO.write(screenshot.getImage(),"PNG",new File("<< file path>>"));
	}

}
