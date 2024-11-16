import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.lang3.RandomStringUtils;
public class SEL {
	public static void main(String[] args) throws InterruptedException, IOException{

		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		 ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        
      WebDriver  driver = new ChromeDriver(options);
      String randomUsername=RandomStringUtils.randomAlphabetic(4);
      String rndlastname=RandomStringUtils.randomAlphabetic(6);
      String randemail=randomUsername + "@gmail.com";
      String randpass=RandomStringUtils.randomAlphanumeric(8) + "@123";
      driver.get("https://magento.softwaretestingboard.com/");
      driver.manage().window().maximize();
      driver.findElement(By.xpath("//a[text()='Create an Account']")).click();
      driver.findElement(By.id("firstname")).sendKeys(randomUsername);
      driver.findElement(By.id("lastname")).sendKeys(rndlastname);
      driver.findElement(By.id("email_address")).sendKeys(randemail);
      driver.findElement(By.id("password")).sendKeys(randpass);
      driver.findElement(By.id("password-confirmation")).sendKeys(randpass);
      Thread.sleep(2000);
      driver.findElement(By.xpath("//button[@class='action submit primary']")).click();
     String msg= driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
     System.out.println(msg);
     Assert.assertEquals(msg, "Thank you for registering with Main Website Store.");
    
     driver.findElement(By.xpath("//button[@class='action switch']")).click();
     driver.findElement(By.xpath("//a[contains(text(), 'Sign Out')]")).click();
     driver.findElement(By.xpath("//a[contains(text(), 'Sign In')]")).click();
    
     driver.findElement(By.id("email")).sendKeys(randemail);
     driver.findElement(By.id("pass")).sendKeys(randpass);
     driver.findElement(By.xpath("//button[@class='action login primary']")).click();   
      Thread.sleep(3000);
      driver.close();
        
        
	}

}