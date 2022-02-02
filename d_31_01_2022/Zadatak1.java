package d_31_01_2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
//		1.Zad
//		Napisati program koji:
//		Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//		Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon 
//		klika element obrisao sa stranice i ispisuje odgovarajuce poruke 
//		(OVO JE POTREBNO RESITI KORISCENJEM PETLJE)
//		POMOC: Brisite elemente odozdo.
//		(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo

		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://s.bootsnipp.com/iframe/Dq2X");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		int brojElemenata = driver.findElements(By.xpath("//*[contains(@class, 'col-md-12')]//button")).size();
		// ODOZDO NA GORE
		for(int i = 4; i >= 0; i--) {
				driver.findElements(By.xpath("//*[contains(@class, 'col-md-12')]//button")).get(i).click();
			int brojElemenataNakonBrisanja = driver.findElements(By.xpath("//*[contains(@class, 'col-md-12')]//button")).size();
			if (brojElemenata - 1 == brojElemenataNakonBrisanja) {
				brojElemenata--;
				System.out.println("Obrisan element");
			}
			Thread.sleep(2000);
		}
		Thread.sleep(2000);;
		driver.close();

		// ODOZGO NA DOLE
//		for(int i = 0; i < 5; i++) {
//			driver.findElement(By.className("close")).click();
//			int brojElemenataNakonBrisanja = driver.findElements(By.xpath("//*[contains(@class, 'col-md-12')]//button")).size();
//			if (brojElemenata - 1 == brojElemenataNakonBrisanja) {
//				brojElemenata--;
//				System.out.println("Obrisan element");
//			}
//			Thread.sleep(3000);
//		}
	}
}

