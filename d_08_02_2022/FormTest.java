package d_08_02_2022;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFEvaluationWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import d_08_02_2022.FormPage;

public class FormTest {

	WebDriver driver;
	private FormPage fp;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		fp = new FormPage(driver);
		driver.get("C:\\Users\\38161\\Downloads\\form (1).html");
		driver.manage().window().maximize();
	}

	@Test
	public void test() throws InterruptedException, IOException {
		File file = new File("data/FormData1.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet("form");
		

		for (int i = 1; i < 8; i++) {

			String username = sheet.getRow(i).getCell(0).getStringCellValue();
			fp.getFirstName().sendKeys(username);
			Thread.sleep(1000);
			fp.getGender(sheet.getRow(i).getCell(1).getStringCellValue()).click();
			Thread.sleep(1000);
			String dateOfBirth = sheet.getRow(i).getCell(2).getStringCellValue();
			fp.getDateOfBirth().sendKeys(dateOfBirth);
			Thread.sleep(1000);
			String email = sheet.getRow(i).getCell(3).getStringCellValue();
			fp.getEmail().sendKeys(email);
			Thread.sleep(1000);
			String role = sheet.getRow(i).getCell(4).getStringCellValue();
			fp.getRole(role);
			Thread.sleep(1000);
			fp.getWays(sheet.getRow(i).getCell(5).getStringCellValue());
			Thread.sleep(1000);
			fp.getComment().sendKeys(sheet.getRow(i).getCell(6).getStringCellValue());
			fp.submit().click();
			Assert.assertEquals(fp.infoIsSaved(), true);
		}

	}
}
