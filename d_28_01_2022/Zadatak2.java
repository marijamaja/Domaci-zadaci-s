package d_28_01_2022;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {
//	Zadatak
//	Napisati program koji vrsi dodavanje 5 reda u tabelu. 
//	Maksimizirati prozor
//	Ucitati stranicu 
//	https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php
//	Dodati red podataka - jedan red u jednoj iteraciji 
//	Kliknite na dugme Add New
//	Unesite name,departmant i phone (mogu da budu uvek iste vrednost)
//	Kliknite na zeleno Add dugme
//	Na kraju programa ugasite pretrazivac.

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		int redZaDodavanje = 4;
		
		for(int i = 0; i < 5; i++) {		
		driver.findElement(By.className("add-new")).click();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Unesite ime: ");
		String name = s.next();
		System.out.println("Unesite department: ");
		String department = s.next();
		System.out.println("Unesite telefon: ");
		String phone = s.next();
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("department")).sendKeys(department);
		driver.findElement(By.id("phone")).sendKeys(phone);
		Thread.sleep(2000);
		
		driver.findElement
		(By.xpath("//*[@class='table table-bordered']/tbody/tr[" + redZaDodavanje + "]/td[4]/a")).click();
		redZaDodavanje++;
		}	
		Thread.sleep(2000);;
		driver.close();


	}

}
