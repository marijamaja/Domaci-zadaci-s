package d_07_02_2022;
//Zadatak 1
//Skinite form.html stranicu (iz ovog foldera za domaci) na svom racunaru i 
//otvorite je u pretrazivacu, iskopirajte url stranice
//	Od klasa je potrebno:
//FormPage koja ima:
//getere za sve inpute
//geter za radio - //*[@name='gender'][@value='"+ radioValue +"'] - kao parametar prima value
//(male/female/middle) tog radio dugmeta
//geter za checkbox inpute - //*[@type='checkbox'][@value='"+ checkboxValue +"']  -
//kao parametar prima value (read_books, online_courses, opensource, tech_cons, 
//		tech_blogs, via_delivery - jednu od ovde navedenih) tog checkbox inputa
//getter koji hvata dugme treba da ceka da element postane klikabilan pre nego 
//sto vrati element. Koristite waiter za ovaj slucaj.
//metodu koja vraca da li su podaci uspesno sacuvani, tako sto proverava da li element 
//koji nosi poruku za atribut style ima vrednost "visibility: visible"

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

public class FormPage {
	
	private WebDriver driver;
	private WebDriverWait wait;

	public FormPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	public WebElement getFullNameInput() {
		return driver.findElement(By.id("first-name"));
	}
	public WebElement getGenderRadioButton(String radioValue) {
		return driver.findElement(By.xpath("//input[@name= 'gender'][@value= '" + radioValue + "']"));
	}
	public WebElement getDateOfBirth() {
		return driver.findElement(By.id("dob"));
	}
	public WebElement getEmail() {
		return driver.findElement(By.id("email"));
	}
	public void roleSelect(String roleValue) {
		Select dropdownRole = new Select(driver.findElement(By.id("role")));
		dropdownRole.selectByVisibleText(roleValue);
	}
	public WebElement getCheckboxInput(int checkboxNumber) {
		return driver.findElement(
				By.xpath("//div[contains(@class, 'col-sm-10 development-ways')]/div[" + checkboxNumber + "]//input"));
	}
	public WebElement getComment() {
		return driver.findElement(By.id("comment"));
	}
	public WebElement getSubmitButton() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
		return driver.findElement(By.id("submit"));
	}
	public boolean isDataSaved() {
		boolean isDataSaved = false;
		String message = driver.findElement(By.className("poruka")).getAttribute("style");
		if (message.equals("visibility: visible;")) {
			isDataSaved = true;
		}
		return isDataSaved;
	}
	
}
