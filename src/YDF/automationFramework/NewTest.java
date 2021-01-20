package YDF.automationFramework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() throws AWTException, Exception {
	  WebDriver driver = new FirefoxDriver();
	  driver.get("https://github.com/appium/appium-desktop/releases/tag/v1.5.0");
	  WebElement we = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div[1]/div[2]/div/div[2]/div[2]/ul/li[2]/a/strong"));
	  we.click();
	  
	  Robot robo =new Robot();
	  robo.keyPress(KeyEvent.VK_UP);
	  Thread.sleep(5000);
	  robo.keyRelease(KeyEvent.VK_UP);
	  Thread.sleep(5000);
	  robo.keyPress(KeyEvent.VK_ENTER);
	  robo.mouseMove(we.getLocation().getX(), we.getLocation().getY());
	  System.out.println("X : " + we.getLocation().getX() + "Y: " + we.getLocation().getY());
  }
}
