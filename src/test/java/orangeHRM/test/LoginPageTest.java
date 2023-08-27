package orangeHRM.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import orangeHRM.pages.LandingPage;
import orangeHRM.pages.LoginPage;


public class LoginPageTest extends BaseTest{

	LoginPage loginpage=null;
	
	LandingPage landingPage=null;
	@BeforeMethod
	public void setUp() {
		
		 loginpage = new LoginPage();   //read the config.properties
	
		 inti();
	
	}
	
	
	@AfterMethod
	public void tearUp() {
		driver.quit();
	}
	
	@Test
	public void loginTest() {
		
		landingPage = loginpage.loginToApplication(prop.getProperty("username"),prop.getProperty("password"));

		Assert.assertEquals(landingPage.getLandingPageTitle(), "OrangeHRM","Landing Page title is not Matching !!! ");
	}
	
	@Test
	public void verifyLoginPageTitle() {
	
		Assert.assertEquals(loginpage.getLoginPageTitle(),"OrangeHRM", "Longin page Title is not  Matching !!!" );
	}

  @Test(dataProvider = "vikas",dataProviderClass = LoginPageTest.class)
//	@Test(dataProvider = "getData")
	public void verifyInvalidLogInCredential(String userName, String pass) {
		
		String  msg = loginpage.verifyInvalidLoginToApplication(userName, pass);
		
		if (!userName.isBlank() && !pass.isBlank())
			Assert.assertEquals(msg, "Invalid credentials");
		else if (userName.isBlank() || pass.isBlank())
			Assert.assertEquals(msg, "Required");
		
	}



	@DataProvider(name="vikas")
	public Object[][] getData() {
		
		Object[][] data= new Object[3][2];
	
		data[0][0]=  "abc";
		data[0][1]=  "abc";
		
		data[1][0]=  "   ";
		data[1][1]=  "abc";
		
		data[2][0]=  "abc";
		data[2][1]=  "   ";
		
		return data;
	}








}

