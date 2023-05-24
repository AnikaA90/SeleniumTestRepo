package com.moneycontrol.SeleniumTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMoneyControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.moneycontrol.com/stocks/marketstats/nsemact1/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List numberOfColumns = driver.findElements(By.xpath("/html/body/section/section/section/div[1]/div[2]/div/div/div[2]/table/thead/tr/th"));
		System.out.println(numberOfColumns.size());
		
		List numberOfRows = driver.findElements(By.xpath("/html/body/section/section/section/div[1]/div[2]/div/div/div[2]/table/tbody/tr"));
		System.out.println(numberOfRows.size());
		
		for (int i=1; i<=numberOfRows.size(); i++) {
			for (int j=1; j<=numberOfColumns.size(); j++) {
				String data = driver.findElement(By.xpath("/html/body/section/section/section/div[1]/div[2]/div/div/div[2]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.println(data);
			}
			
		}
		
		driver.close();
		driver.quit();

	}

}
