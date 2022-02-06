package d_03_02_2022;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
//		2.Zadatak
//		Napisati program koji:
//		Ucitava stanicu https://www.wikipedia.org/
//		Sa stranice sakuplja sve linkove (jezike) i svaki link
//		otvara u novom prozoru pretrazivaca
//		Svaki link potrebno je otvoriti u novom tabu.
//		Skripta: window.open(arguments[0]);

		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.navigate().to("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		List<WebElement> jezici = driver.findElements(By.xpath
				("//div[contains(@class, 'central-featured')]//a"));

		for (int i = 0; i < jezici.size(); i++) {
			js.executeScript("window.open(arguments[0]);", jezici.get(i));
		}

	}

}
