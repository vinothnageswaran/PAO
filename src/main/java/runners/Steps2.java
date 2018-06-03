package runners;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.ProductListingPage;

public class Steps2 {
	
	WebDriver driver;
	
	
	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() {
		ProductListingPage productListingPage = new ProductListingPage(driver);
		productListingPage.select_Product(0);
		productListingPage.clickOn_AddToCart();		
	}
	
	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page(){
		System.setProperty("webdriver.ie.driver","C://Users//Vinoth//temp//chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","C://Users//Vinoth//temp//IEdriver//IEDriverServer.exe");
		//driver = new InternetExplorerDriver();
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");
		
		driver.get("http://shop.demoqa.com/?s=dress&post_type=product");
	}

}
