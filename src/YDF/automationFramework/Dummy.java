package YDF.automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import Utility.ExcelApiTest;

public class Dummy {
	WebDriver driver = new FirefoxDriver();
	String filepath = "F:\\Satabdi\\YDF\\src\\testData\\Phonenum.xlsx";

	@Test(dataProvider = "userData")
	public void f(String phone) {
		driver.get("https://www.yourdigitalfile.com/");
		driver.findElement(By.xpath("//*[@id=\"menu_login_bt\"]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"id_username\"]")).sendKeys("phone");
		driver.findElement(By.xpath("//*[@id=\"loginButton\"]")).click();

	}

	@DataProvider(name = "userData")
	public String[] testData() throws Exception {

		ExcelApiTest config = new ExcelApiTest(filepath);
		int rows = config.getRowCount(0);
		String[] data = new String[rows];
		try {
			for (int i = 0; i < rows; i++) {
				data[i] = config.getDataNumericAsString(0, i, 0);

			}
			// return data;
		} catch (Exception e) {
			System.out.println("The Exception is : " + e.getMessage());
		}
		return data;

	}
}