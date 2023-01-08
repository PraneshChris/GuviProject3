package project3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_01 {
	WebDriver driver;
	@Test
	public void testcase1() throws IOException, InterruptedException {
		XSSFWorkbook obj=new XSSFWorkbook("C:\\Users\\prane\\eclipse-workspace\\Guvi_Project3\\Excel\\TestCase01.xlsx");
		XSSFSheet sheet=obj.getSheetAt(0);
		obj.close();
		 int rows = sheet.getPhysicalNumberOfRows();
		 System.out.println(rows);
		 
		 String search;
			int k=1;
			for(int i=0;i<=rows;i++) {
				search=sheet.getRow(i).getCell(0).getStringCellValue();
				for(int j=1;j<=k;j++) {
				
				WebDriverManager.chromedriver().setup();
				  driver= new ChromeDriver();
				  driver.manage().window().maximize();
				  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
				  driver.findElement(By.name("username")).sendKeys("Admin");
				  driver.findElement(By.name("password")).sendKeys("admin123");
				  driver.findElement(By.xpath("//*[@name='password']//following::button")).click();
				  WebElement keywords=driver.findElement(By.xpath("//input[@placeholder='Search']"));
	              keywords.sendKeys(search + "\n");
	              Thread.sleep(3000);
	              driver.close();
				}
			}
		
	}

}
