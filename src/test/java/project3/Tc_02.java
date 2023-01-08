package project3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tc_02 extends BaseClass{
	@Test
	public void Test2() throws Exception{
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Thread.sleep(2000);
		WebElement UR= driver.findElement(By.xpath("(//div[text()='-- Select --']//following::div)[1]"));
		Actions act=new Actions(driver);
		act.sendKeys(UR , "A").sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
		Thread.sleep(3000);
		WebElement ST=driver.findElement(By.xpath("(//div[@class='oxd-table-filter-area']//following::i)[2]"));
		Actions act1=new Actions(driver);
		act1.sendKeys(ST, "E").sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform();
		//Assert.assertTrue(act.sendKeys(UR , "A").sendKeys(Keys.ARROW_DOWN,Keys.RETURN).build().perform()).isDisplayed();
		//Assert.assertTrue(driver.findElement(By.xpath("(//div[text()='-- Select --']//following::div)[1]"))).isDisplayed();
	}
	
}

