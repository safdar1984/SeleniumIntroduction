import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String[] vegetables = { "Cucumber", "Carrot", "Beetroot", "Beans" };
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		addItems(driver, vegetables);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
	
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}

	

public static void addItems(WebDriver driver,String[] vegetables ) {
	List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
	int j = 0;
	for(int i=0; i<products.size();i++) {
		String[] name = products.get(i).getText().split("-");
		String formattedName = name[0].trim();
		List veggiesList = Arrays.asList(vegetables);
		if(veggiesList.contains(formattedName)) {
			j++;
			driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			//break;
			if(j==vegetables.length) {break;}
		}
		
}
}
}
