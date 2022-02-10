package d_07_02_2022;
//FormTest
//Ucitava stranicu
//Popunite formu proizvoljnim podacima
//Submitujte formu 
//Proverite da li su podaci uspesno sacuvani. (imate metodu iz page-a 
//		koja vam vraca da li je uspesno sacuvano, iskorisite je)
//U AfterClass metodi zatvaramo stranicu

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormTest {

	private WebDriver driver;
	private FormPage formPage;
	private WebDriverWait wait;

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.navigate().to("C:\\Users\\38161\\Downloads\\form.html");
		wait = new WebDriverWait(driver, 10);

		formPage = new FormPage(driver, wait);
		
	}

	@Test
	public void formTest() throws InterruptedException {
		
		formPage.getFullNameInput().sendKeys("Marija Nikolic");
		Thread.sleep(2000);
		formPage.getGenderRadioButton("female").click();
		Thread.sleep(2000);
		formPage.getDateOfBirth().sendKeys("07.02.1998.");
		Thread.sleep(2000);
		formPage.getEmail().sendKeys("marijanikolic554@gmail.com");
		Thread.sleep(2000);
		formPage.roleSelect("QA");
		Thread.sleep(2000);
		formPage.getCheckboxInput(2).click();
		Thread.sleep(2000);
		formPage.getComment().sendKeys("Hahaha");
		Thread.sleep(2000);
		formPage.getSubmitButton().click();
		Thread.sleep(4000);
		Assert.assertTrue(formPage.isDataSaved(), "Data is not saved.");
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		driver.quit();
	}

}
