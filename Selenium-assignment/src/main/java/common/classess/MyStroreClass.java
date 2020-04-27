package common.classess;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyStroreClass {

	private WebDriver driver;
	public String ExpectedCost;
	private WebDriverWait wait;
	public String expTotalCost = null;

	public MyStroreClass(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 15);
	}

	public void login(String Uname,String Pwd) {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("email")).sendKeys(Uname);
		driver.findElement(By.id("passwd")).sendKeys(Pwd, Keys.ENTER);
	}

	public void CreateAccount(String Emailid, String customer_firstname, String customer_lastname, String passwd,
			String company, String address, String city, String state, String postcode, String phone_mobile) {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("email_create")).sendKeys(Emailid);
		driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys(customer_firstname);
		driver.findElement(By.id("customer_lastname")).sendKeys(customer_lastname);
		driver.findElement(By.id("passwd")).sendKeys(passwd);
		driver.findElement(By.id("company")).sendKeys(company);
		driver.findElement(By.id("address1")).sendKeys(address);
		driver.findElement(By.id("city")).sendKeys(city);
		driver.findElement(By.id("id_state")).sendKeys(state);
		driver.findElement(By.id("postcode")).sendKeys(postcode);
		driver.findElement(By.id("phone_mobile")).sendKeys(phone_mobile,Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='logout']")).click();

	}

	public void addToCart() throws InterruptedException {
		driver.findElement(By.linkText("Women")).click();
		WebElement product = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")));
		product.click();
		driver.switchTo().frame(0);
		driver.findElement(By.id("quantity_wanted")).clear();
		driver.findElement(By.id("quantity_wanted")).sendKeys("2", Keys.ENTER);
		driver.switchTo().defaultContent();
		// expected cost
		WebElement Testlocatecost = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[3]/span")));
		expTotalCost = Testlocatecost.getText();
		// ExpectedCost =
		// driver.findElement(By.xpath("//span[@class='ajax_block_cart_total']")).getText();
		System.out.println(" Expected Cost into is = " + expTotalCost);
		driver.findElement(By.partialLinkText("Proceed to checkout")).click();

	}

	public void verifyCostAndCompleteSummaryTab() {
		WebElement SummaryTab = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"total_price_container\"]")));
		String SummaryTabCost = SummaryTab.getText();
		assertEquals(expTotalCost, SummaryTabCost);
		System.out.println("verified expected cost on Summary Tab = " + SummaryTabCost);
		driver.findElement(By.partialLinkText("Proceed to checkout")).click();
		driver.findElement(By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]"))
				.click();
		driver.findElement(By.id("cgv")).click();
		driver.findElement(By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]"))
				.click();

	}

	public void verifyCostAndCompletePaymentTab() {
		WebElement PaymentTab = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"total_price_container\"]")));
		String PaymentTabCost = PaymentTab.getText();
		assertEquals(expTotalCost, PaymentTabCost);
		System.out.println("verified expected cost on Payment Tab = " + PaymentTabCost);
		driver.findElement(By.partialLinkText("Pay by bank wire")).click();
		driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]")).click();
	}

	public void verifyCostOrderHistory() {
		driver.findElement(By.xpath("//a[@class='account']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Order history and details')]")).click();
		WebElement verifyOrderHistory = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='history_price']")));
		String verifyOrderHistoryCost = verifyOrderHistory.getText();
		assertEquals(expTotalCost, verifyOrderHistoryCost);
		System.out.println("verified expected cost on  OrderHistoryPage Under Profile = " + verifyOrderHistoryCost);

	}
}
