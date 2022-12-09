package Common_Package;

import java.time.Duration;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Action_Class extends BaseClass{



	//click by using common selenium

	protected By getLocaters(String locatertype,String locatervalue ) {
		switch(Locators.valueOf(locatertype)) {
		case id:
			return By.id(locatervalue);
		case xpath:
			return By.xpath(locatervalue);
		case name:
			return By.name(locatervalue);
		case classname:
			return By.className(locatervalue);
		case css:
			return By.cssSelector(locatervalue);
		case linktext:
			return By.linkText(locatervalue);
		default:
			return By.id(locatervalue);
		}	 



	}
	
	protected By getlocator(String elementname) {
		String [] locator= page.text_read_test(elementname);
		return getLocaters(locator[1].trim(),locator[2].trim());
	}

	protected By getlocator(String elementname,String replacement) {
		String [] locator= page.text_read_test(elementname);
		locator[2]=locator[2].replaceAll("\\$\\{.+?\\}", replacement);
		return getLocaters(locator[1].trim(),locator[2].trim());
	}

	protected By getlocator(String elementname,String replacement1,String replacement2) {
		String [] locator= page.text_read_test(elementname);
		locator[2]=locator[2].replaceFirst("\\$\\{.+?\\}", replacement1);
		locator[2]=locator[2].replaceFirst("\\$\\{.+?\\}", replacement2);
		return getLocaters(locator[1].trim(),locator[2].trim());
	}


	protected By getlocator(String elementname,String replacement1,String replacement2,String replacement3) {
		String [] locator= page.text_read_test(elementname);
		locator[2]=locator[2].replaceFirst("\\$\\{.+?\\}", replacement1);
		locator[2]=locator[2].replaceFirst("\\$\\{.+?\\}", replacement2);
		locator[2]=locator[2].replaceFirst("\\$\\{.+?\\}", replacement3);
		return getLocaters(locator[1].trim(),locator[2].trim());
	}



	private  WebElement elements(String elementlocater,String replacement1,String replacement2,String replacement3) {
		if(replacement1.isEmpty()&& replacement2.isEmpty()) {
			return driver.findElement(getlocator(elementlocater));
		}else if(replacement2.isEmpty()&& !replacement1.isEmpty()) {
			return driver.findElement(getlocator(elementlocater,replacement1));
		}else if(!replacement1.isEmpty()&& !replacement2.isEmpty()) {
			return driver.findElement(getlocator(elementlocater,replacement1,replacement2));
		}if(!replacement1.isEmpty()&& !replacement2.isEmpty() && !replacement3.isEmpty()) {
			return driver.findElement(getlocator(elementlocater,replacement1,replacement2,replacement3));
		}			

		return driver.findElement(getlocator(elementlocater));
	}

	
	
	public WebElement element(String elementname) {
		return elements(elementname, "", "", "");
	}

	public WebElement element(String elementname,String replacement1) {
		return elements(elementname, replacement1, "", "");
	}

	public WebElement element(String elementname,String replacement1,String replacement2) {
		return elements(elementname, replacement1, replacement2, "");
	}

	public WebElement element(String elementname,String replacement1,String replacement2,String replacement3) {
		return elements(elementname, replacement1, replacement2, replacement3);
	}


	
	
	
	public void waitforelementvisible(String elementlocater ) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(getlocator(elementlocater)));
		logger.info("element is visible");
	}


	public void click(String locatorname) {
		element(locatorname).click();
		
	}
	
	public void click(String locatorname,String replacement1) {
		element(locatorname,replacement1).click();
		
	}
	
	public void click(String locatorname,String replacement1,String replacement2) {
		element(locatorname,replacement1,replacement2).click();
		
	}













}
