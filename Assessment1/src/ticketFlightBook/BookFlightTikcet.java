package ticketFlightBook;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BookFlightTikcet {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driver/ChromeDriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://blazedemo.com/index.php");
		driver.manage().window().maximize();
		String actPageSrc= driver.getPageSource();
		String expPageSrc= "Welcome to the Simple Travel Agency!" ;
		if(actPageSrc.contains(expPageSrc))
		{
			System.out.println("Title Displayed");
		}
		else
		{
			System.out.println("Title is not Present");
		}
		driver.findElement(By.xpath("//a[text()='destination of the week! The Beach!']")).click();
		String currentURL=driver.getCurrentUrl();
		System.out.println(currentURL);
		String expURL="vacation"; 
		if(currentURL.contains(expURL))
		{
			System.out.println("String 'Vacation' has been Matched");
		}
		else
		{
			System.out.println("String Not Matched");
		}
		driver.navigate().back();
		WebElement depart= driver.findElement(By.name("fromPort"));
		Select sc=new Select(depart);
		sc.selectByIndex(5);
		WebElement dest=driver.findElement(By.name("toPort"));
		Select ds=new Select(dest);
		ds.selectByIndex(2);
		driver.findElement(By.cssSelector("input[value='Find Flights']")).click();

		driver.findElement(By.xpath("//table[@class='table']//tr[3]//td[1]")).click();

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,500);");
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();

		List <WebElement> allCol=driver.findElements(By.xpath("//table[@class='table']//tr[1]//td[2]"));
		
		for (WebElement ele1 : allCol) {
			
			String value=ele1.getText();
			System.out.println("Ticket id "  +value);
		}

	}

}
