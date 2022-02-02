package d_01_02_2022;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
//		1.Zadatak
//		Napisati program koji :
//		Ucitava stranicu https://www.udemy.com/courses/search/?src=ukw&q=slksd
//		Klikce na dugme za jezik i proverava da li se prikazuje dijalog za promenu jezika
//		Stampa u konzoli tekst “Dijalog se prikazao”

		
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.udemy.com/courses/search/?src=ukw&q=slksd");
		driver.manage().window().maximize();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(@class,'language-selector-button--button--1wgoL')]")).click();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[contains(@class, 'language-selector-modal-trigger--modal--3jcoz')]")));
		
		System.out.println("Dijalog se prikazao");
		
		

		
	}

}
