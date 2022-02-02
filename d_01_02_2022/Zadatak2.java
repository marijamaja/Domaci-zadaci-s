package d_01_02_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
//		2.Zadatak
//		Napisti program koji:
//		Ucitava stranicu https://videojs.com/city
//		Pusta video klikom na play dugme
//		Cekamo da se video ucita
//		Tako sto proveravamo da li vise to play dugme nije vidljivo
		
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://videojs.com/city");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.className("vjs-big-play-button")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("vjs-big-play-button")));
		
		System.out.println("Dugme nije vidljivo.");
	}

}
