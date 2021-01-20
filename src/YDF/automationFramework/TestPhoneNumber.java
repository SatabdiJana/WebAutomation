package YDF.automationFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.YDFnewRegistration;
import Utility.ExcelApiTest;
import Utility.Screenshots;

public class TestPhoneNumber {
	
	String filepath= "C:\\Test\\Phonenum.xlsx";
	
//  @Test
  public void testEmptySpecialcharPh() throws Exception {
	  
	 WebDriver driver = new FirefoxDriver ();
	 driver.get("https://www.test.yourdigitalfile.net/register/");
	 
	 
	
	 YDFnewRegistration.getPersonalPlan(driver).click();
	 
	
	 YDFnewRegistration.getFreePlan(driver).click();
	 
	 Thread.sleep(1000);
	 
	 YDFnewRegistration.getEmailverification(driver).sendKeys("satabdi.jana12@yourdigitalfile.com.au");
	
	 YDFnewRegistration.sendToken(driver).click();
	 Thread.sleep(5000);
	 
	
	 YDFnewRegistration.setEmailToken(driver).sendKeys("1234");
	 
	 YDFnewRegistration.getNextButton(driver).click();
	 
	 Thread.sleep(5000);
	 driver.navigate().refresh();
	 
	 // get options number 
	 Select mobile = new Select(YDFnewRegistration.getMobileRegion(driver));
	 
	  List<WebElement> listOptionDropdown = mobile.getOptions();
	       
        // Count the item dropdown list and assign into integer variable
        int dropdownCount = listOptionDropdown.size();
	   // System.out.println(dropdownCount);
	 
	 for(int i =1; i<=dropdownCount;i++) {
		 try {

	 mobile.selectByIndex(i);
	 String specialCharactersInSolr[] ={"+", "-", "&&", "||", "!", "(", ")", "{", "}", "[", "]", "^",
	            "~", "*", "?", ":","\"","\\" ," "};
	int size = specialCharactersInSolr.length;
	
	for (int j= 0;j<size; j++) {
		driver.findElement(By.xpath("//*[@id=\"id_mobile_number\"]")).sendKeys(specialCharactersInSolr[j]);
		YDFnewRegistration.getFormNext(driver).click();	
		 Thread.sleep(5000);
		 System.out.print(YDFnewRegistration.getErrormsg(driver).getText());
		 driver.findElement(By.xpath("//*[@id=\"id_mobile_number\"]")).clear();
	}
	 
	  driver.navigate().refresh();
		 }catch (Exception ex) {
			 
		 Screenshots.takeSnapShot(driver);
		 driver.navigate().refresh();
		 continue;
		 }
		 
	 }
	 
	
  }
  
  @Test (dataProvider="userData")
	 public void testPhone(Double Phone) throws Exception {
	  
		 WebDriver driver = new FirefoxDriver ();
		 driver.get("https://www.test.yourdigitalfile.net/register/");
		 
		 
		
		 YDFnewRegistration.getPersonalPlan(driver).click();
		 
		
		 YDFnewRegistration.getFreePlan(driver).click();
		 
		 Thread.sleep(1000);
		 
		 YDFnewRegistration.getEmailverification(driver).sendKeys("satabdi.jana12@yourdigitalfile.com.au");
		
		 YDFnewRegistration.sendToken(driver).click();
		 Thread.sleep(5000);
		 
		
		 YDFnewRegistration.setEmailToken(driver).sendKeys("1234");
		 
		 YDFnewRegistration.getNextButton(driver).click();
		 
		 Thread.sleep(5000);
		 driver.navigate().refresh();
		 
		 // get options number 
		 Select mobile = new Select(YDFnewRegistration.getMobileRegion(driver));
		 
		  List<WebElement> listOptionDropdown = mobile.getOptions();
		       
	        // Count the item dropdown list and assign into integer variable
	        int dropdownCount = listOptionDropdown.size();
		   // System.out.println(dropdownCount);
		 
		 for(int i =1; i<=dropdownCount;i++) {
			 try {
				  mobile.selectByIndex(i);
				  driver.findElement(By.xpath("//*[@id=\"id_mobile_number\"]")).sendKeys(String.valueOf(Phone));
				  YDFnewRegistration.getFormNext(driver).click();	
				  Thread.sleep(5000);
				  System.out.print(YDFnewRegistration.getErrormsg(driver).getText());
				  driver.findElement(By.xpath("//*[@id=\"id_mobile_number\"]")).clear();
				  driver.navigate().refresh();
			 }catch (Exception ex) {			 
				 Screenshots.takeSnapShot(driver);
				 driver.navigate().refresh();
				 continue;
			 }
			 
		 }
		 
		
	  }
	  
  
  
  @DataProvider(name="userData")

  public Object[][] testData() throws Exception
  {
	  
  	ExcelApiTest config = new ExcelApiTest(filepath);
  	int rows = config.getRowCount(0);
  	Object[][]data=new Object[rows][2];
  	try {
  	for (int i=0;i<rows;i++) {
  	data[i][0]=config.getNumericData(0, i, 0);
  	
  	}
  	//return data;
	  }catch(Exception e)
	  {
		  
	  }
	return data;
     
  } 

}
