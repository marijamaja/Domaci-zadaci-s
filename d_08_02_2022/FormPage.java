package d_08_02_2022;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public FormPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFirstName() {
		return driver.findElement(By.id("first-name"));
	}

	public WebElement getGender(String radioValue) {
		return driver.findElement(By.xpath("//*[@name='gender'][@value='" + radioValue + "']"));

	}

	public WebElement getDateOfBirth() {
		return driver.findElement(By.id("dob"));
	}

	public WebElement getEmail() {
		return driver.findElement(By.id("email"));
	}

	public void getRole(String role) {
		Select dropdown = new Select(driver.findElement(By.id("role")));
		dropdown.selectByValue(role);

	}

	public WebElement getWays(String checkboxValue) {
		return driver.findElement(By.xpath("//*[@type='checkbox'][@value='" + checkboxValue + "']"));
	}

	public WebElement getComment() {
		return driver.findElement(By.id("comment"));
	}

	public boolean infoIsSaved() {
		try {
			wait.until(ExpectedConditions.attributeContains(By.id("submit"), "style", "visibility: visible"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public WebElement submit() {
		return driver.findElement(By.className("btn-primary"));
	}

}
