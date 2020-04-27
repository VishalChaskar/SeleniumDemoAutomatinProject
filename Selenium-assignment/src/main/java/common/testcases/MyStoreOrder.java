package common.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.classess.BrowserSession;
import common.classess.MyStroreClass;
import common.classess.PropertyFile;

public class MyStoreOrder {

	BrowserSession object_browseSession;
	MyStroreClass object_MyStore;
	WebDriver driver;
	PropertyFile data;

	@BeforeClass
	public void initBrowser() throws Exception {
		data = new PropertyFile();
		object_browseSession = new BrowserSession();
		driver = object_browseSession.initiateBrowserSession(PropertyFile.getUrl(), "Chrome");
		object_MyStore = new MyStroreClass(driver);
	}

	 @Test(priority =0)
	public void createAndLoginAccount() {
		String gettitle = driver.getTitle();
		System.out.println(gettitle);
		String Emailid = data.emailId();
		String customer_firstname = data.firstName();
		String customer_lastname = data.lastName();
		String passwd = data.passWord();
		String company = data.company();
		String address = data.address();
		String city = data.city();
		String state = data.state();
		String postcode = data.zipCode();
		String phone_mobile = data.mobilePhone();
		object_MyStore.CreateAccount(Emailid, customer_firstname, customer_lastname, passwd, company, address, city,
				state, postcode, phone_mobile);

	}

	@Test(priority = 1)
	public void login() throws InterruptedException {
		object_MyStore.login(data.emailId(), data.passWord());

	}

	@Test(priority = 2)
	public void performAddToCart() throws InterruptedException {
		object_MyStore.addToCart();

	}

	@Test(priority = 3)
	public void verifySummaryTabCost() throws InterruptedException {
		object_MyStore.verifyCostAndCompleteSummaryTab();

	}

	@Test(priority = 4)
	public void verifyPaymentTabC0st() throws InterruptedException {

		object_MyStore.verifyCostAndCompletePaymentTab();

	}

	@Test(priority = 5)
	public void verifyOrderHistoryCost() throws InterruptedException {

		object_MyStore.verifyCostOrderHistory();

	}

	@AfterClass
	public void CloseBrowser() {
		// driver.close();
	}

}
