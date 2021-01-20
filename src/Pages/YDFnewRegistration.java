package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YDFnewRegistration {

	public static WebElement element = null;

	public static WebElement getPersonalPlan(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#regPersonal")));
		return element;

	}

	public static WebElement getFreePlan(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div[1]/form/div/div[6]/table[1]/tbody/tr/td[2]")));
		return element;
	}

	public static WebElement getEmailverification(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_email\"]")));
		return element;
	}

	public static WebElement sendToken(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sendTokenBt\"]")));
		return element;
	}

	public static WebElement setEmailToken(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_entered_mail_code\"]")));
		return element;
	}

	public static WebElement getNextButton(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nextButton\"]")));
		return element;
	}

	public static WebElement getErrormsg(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div[1]/form/div/ul/li[14]/ul")));
		return element;
	}

	public static WebElement getFormNext(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nextButton\"]")));
		return element;
	}

	public static WebElement getMobileRegion(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_mobile_region\"]")));
		return element;
	}
}