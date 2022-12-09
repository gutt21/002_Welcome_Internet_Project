
package Run_Test_Model;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common_Package.Action_Class;
import Common_Package.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class all_test_one_class extends BaseClass{
	
	
	Action_Class test=new Action_Class();

	@Test
	public void add_remove() {
		System.out.println("hello");
		test.waitforelementvisible("Add");
	    test.element("Add").click();
	    test.click("AddandDeletElement", "Add Element");
	    test.click("AddandDeletElement", "Delete");
	    driver.navigate().back();
	}

	
	
	
	
	
}
