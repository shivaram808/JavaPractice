package Practiceprograms;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Seleniumprograms {
	
	WebDriver driver;

	//@Test
	public void Dynamicwebtable()
	{
		System.setProperty("webdriver.gecko.driver", "./chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		
		String HDFC_rate = driver.findElement(By.xpath("//a[contains(text(),'HDFC Life Insurance')]/parent::*/following-sibling::td[3]")).getText();
		System.out.println("HDFC interest rate is : "+HDFC_rate );
		
		// another way to write pic date june 24************ //td[contains(text(),'june')]/following-sibling::td[contains(text(),'24')] 
	}
	
	@Test
	public void highestprice() throws ParseException
	{
		System.setProperty("webdriver.gecko.driver", "./chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		
		ArrayList<Double> al = new ArrayList();
		
		List<WebElement> cost = driver.findElements(By.xpath("//table[1]/tbody[1]/tr/td[4]"));
		
		NumberFormat numfor = NumberFormat.getNumberInstance();
		
		for(WebElement price : cost)
		{
			System.out.println("price before sorting : "+price.getText());
			Number num = numfor.parse(price.getText());
			
			String pc = num.toString();
			
			Double var = Double.parseDouble(pc);
			al.add(var);
				
		}
		
		System.out.println(al);	
		Collections.sort(al);
		System.out.println("highest value is : "+al.get(0));
	
		driver.close();
	}
}
