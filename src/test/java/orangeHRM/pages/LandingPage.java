package orangeHRM.pages;

import org.openqa.selenium.By;

import orangeHRM.test.BaseTest;

public class LandingPage extends BaseTest {

	By lnkAdmin = By.xpath("//div[@id='app']//li[1]/a");

	public LandingPage() {
		super();
	}
	

	public void clickOnAdminLink() {
		
		driver.findElement(lnkAdmin);
	}
	
	public String  getLandingPageTitle() {
		String landingPageTitle = driver.getTitle();
		return landingPageTitle;
		
	}
}
