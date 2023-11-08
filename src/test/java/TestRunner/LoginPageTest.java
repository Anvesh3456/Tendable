package TestRunner;

import org.testng.annotations.Test;

import Pages.Tendable_LoginPage;

public class LoginPageTest {

	@Test (priority = 1)
	public void login() {
		try {
			String Fname = "abc";
			String orgName = "abc pvt ltd";
			String phoneNumber = "123456789";
			String emailNum = "abc@gmail.com";
			String ErrorMessage = "Sorry, there was an error submitting the form. Please try again.";
	Tendable_LoginPage lp = new Tendable_LoginPage();
	lp.launch();

	lp.checkTopLevelAccessbility("Our Story");
	
	lp.checkOurSolutionsLink("Our Solution");
	lp.checkWhyTendableLinkPresence("Why Tendable?");
	lp.navigateToMarketingPage();
	lp.FormCompletion(Fname ,orgName ,phoneNumber ,emailNum ,ErrorMessage);
		}catch(Exception e) {
	System.out.println("Exception e "+e.getMessage());
		}		
	}
}
