package orangeHRM.pages;

import org.openqa.selenium.By;

import orangeHRM.test.BaseTest;

public class LoginPage extends BaseTest {

	By txtName = By.name("username");
	By txtPassword = By.name("password");
	By btnLogin = By.xpath("//button");
	
	By invalidCredErrorMsg = By.xpath("(//div//p)[1]");
	By requiredErrorMsg= By.xpath("//span");

	public LoginPage() {
		super(); // read config.properties
	}

	public void enterUserName(String userName) {

		driver.findElement(txtName).sendKeys(userName);

	}

	public void enterPassword(String password) {

		driver.findElement(txtPassword).sendKeys(password);

	}

	public void clickOnLoginButton() {

		driver.findElement(btnLogin).click();

	}
	public String getLoginPageTitle(){

		return driver.getTitle();
		
	}
	
	public String verifyInvalidLoginToApplication(String uname, String pass) {
		
		String returnMsg = null;
		
		enterUserName(uname);
		enterPassword(pass);
		clickOnLoginButton();
		
		if (!uname.isBlank() && !pass.isBlank())
			returnMsg = driver.findElement(invalidCredErrorMsg).getText();
		else if (uname.isBlank() ||pass.isBlank())
			returnMsg = driver.findElement(requiredErrorMsg).getText();
		
		return returnMsg;
	}

	public LandingPage loginToApplication(String username, String password) {

		enterUserName(username);
		enterPassword(password);
		clickOnLoginButton();

		return new LandingPage();
	}
	
	

}
