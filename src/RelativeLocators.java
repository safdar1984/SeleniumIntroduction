import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameEditBox = driver.findElement(By.xpath("(//input[@name='name'])[1]"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		
		WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.cssSelector("input")).below(dateofBirth)).click();
		WebElement checkBox = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkBox)).click();
		
		WebElement rdoBtn = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdoBtn)).getText());

	}

}
