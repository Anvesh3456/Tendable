package Pages;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tendable_LoginPage {
	public static WebDriver driver;
	public static final String storyXpath = "//a[contains(text(),'Our Story')]";
	public static final String solutionXpath = "//a[contains(text(),'Our Solution')]";
	public static final String tendableXpath = "//a[contains(text(),'Why Tendable?')]";
	public static final String homeXpath = "//a[contains(text(),'Home')]";
	public static final String requestDemoXpath = "(//a[contains(text(),'Request a Demo')])[2]";
	public static final String contactUsXpath = "//a[contains(text(),'Contact Us')]";
	public static final String marketingContactBtnXpath = "(//button[contains(text(),'Contact')])[1]";
	public static final String FirstNameXpath = "(//*[@id='form-input-fullName'])[1]";
	public static final String organizationXpath = "(//*[@id='form-input-organisationName'])[1]";
	public static final String phoneNumberXpath = "(//*[@id='form-input-cellPhone'])[1]";
	public static final String EmailXpath = "(//*[@id='form-input-email'])[1]";
	public static final String iagreeXpath = "(//*[@id='form-input-consentAgreed-0'])[1]";
	public static final String submitButton = "(//button[contains(text(),'Submit')])[1]";
    public static final String errorMsgXpath = "//*[@id=\"contactMarketingPipedrive-163701\"]/div[1]/p";
	
	public static void launch() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");

		System.out.println("-----------Inside Launch Browser Test Method-----------");
		String userdir = System.getProperty("user.dir");
		System.out.println(" userdir = "+userdir);
		String path = userdir+"\\src\\main\\resources\\browserSpecificDriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
	    System.out.println("system set property");
		 driver = new ChromeDriver(options);
		System.out.println("driver instance ="+driver);
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    System.out.println("maximize window");
	    driver.get("https://www.tendable.com/");
	    System.out.println("launch url");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	    driver.getTitle();
	}
	
	public static void checkTopLevelAccessbility(String story) {
		System.out.println("-----------Inside Our Story link Test Method-----------");
		boolean isLinkPresent = false;
		
		WebElement link = driver.findElement(By.xpath(storyXpath));
		isLinkPresent =  link.isDisplayed();
		System.out.println("link status"+isLinkPresent);
		if(isLinkPresent) {
			String storyText = link.getText();
			if(storyText.equalsIgnoreCase(story)) {
				System.out.println("Our Story Element Present ");
			}
			System.out.println("storyText = "+storyText);
		}else {
			System.out.println("Story Element not available");
		}

	}
	
	public static void checkOurSolutionsLink(String ourSolutionsText) {
		System.out.println("-----------Inside Our Solution link Test Method-----------");
		
		boolean isLinkPresent = false;
		WebElement link = driver.findElement(By.xpath(solutionXpath));
		isLinkPresent =  link.isDisplayed();
		System.out.println("link status"+isLinkPresent);
		if(isLinkPresent) {
			String storyText = link.getText();
			if(storyText.equalsIgnoreCase(ourSolutionsText)) {
				System.out.println("Our Solutions Element Present ");
			}
			System.out.println("Our Solutions Element Text ="+storyText);
		}else {
			System.out.println("Our Solutions Element not available");
		}

	}
	
	public static void checkHomePageLink() {
		boolean isLinkPresent = false;
		String storyText = "";
		WebElement link = driver.findElement(By.xpath(homeXpath));
		isLinkPresent =  link.isDisplayed();
		System.out.println("link status"+isLinkPresent);
		if(isLinkPresent) {
		 storyText = link.getText();
		System.out.println("storyText = "+storyText);
		}else {
			System.out.println("home Page Link Not present");
		}
	}
	
	public static void checkWhyTendableLinkPresence(String TendableActual) {
		System.out.println("-----------Inside Tendable link Test Method-----------");
		boolean isLinkPresent = false;
		String tendableText = "";
		WebElement link = driver.findElement(By.xpath(tendableXpath));
		isLinkPresent =  link.isDisplayed();
		System.out.println("link status"+isLinkPresent);
		if(isLinkPresent) {
			tendableText = link.getText();
			if(tendableText.equalsIgnoreCase(TendableActual)) {
				System.out.println("Tendable Link Element Present ");
			}
		System.out.println("Tendable Link  = "+tendableText);
		}else {
			System.out.println("Tendable Link Not present");
		}
	}
	
	public static void VerifyRequestDemoLink(String DemoText) {
		System.out.println("-----------Inside Request a Demo link Test Method-----------");
		boolean isLinkPresent = false;
		String DemoActualText = "";
		WebElement link = driver.findElement(By.xpath(requestDemoXpath));
		isLinkPresent =  link.isDisplayed();
		System.out.println("link status"+isLinkPresent);
		if(isLinkPresent) {
			DemoActualText = link.getText();
			if(DemoActualText.equalsIgnoreCase(DemoText)) {
				System.out.println("Demo Link Element Present ");
			}
		System.out.println("Demo Link  = "+DemoActualText);
		}else {
			System.out.println("Demo Link Not present");
		}
	}
	
	public static void navigateToMarketingPage() {
		System.out.println("-----------Inside Navigate to Markeeting Page Test Method-----------");	
		WebElement contactBtn = driver.findElement(By.xpath(contactUsXpath));
		boolean b1 =contactBtn.isDisplayed();
		System.out.println("contact button status ="+b1);
		if(b1 == true) {
			contactBtn.click();
			System.out.println("clicked on Contact US Button");
		}
		
		WebElement marketingBtn = driver.findElement(By.xpath(marketingContactBtnXpath));
		boolean b2 =marketingBtn.isDisplayed();
		System.out.println("Marketing contact button status ="+b1);
		if(b2 == true) {
			marketingBtn.click();
			System.out.println("clicked on Marketing Contact US Button");
		}	
	}
	
	public static void FormCompletion(String fullname , String orgName , String phone, String email , String ErrorText) {
		
		try {
			driver.findElement(By.xpath(FirstNameXpath)).clear();
		driver.findElement(By.xpath(FirstNameXpath)).sendKeys(fullname);
		driver.findElement(By.xpath(organizationXpath)).clear();
		driver.findElement(By.xpath(organizationXpath)).sendKeys(orgName);
		driver.findElement(By.xpath(phoneNumberXpath)).clear();
		driver.findElement(By.xpath(phoneNumberXpath)).sendKeys(phone);
		driver.findElement(By.xpath(EmailXpath)).clear();
		driver.findElement(By.xpath(EmailXpath)).sendKeys(email);	
		driver.findElement(By.xpath(iagreeXpath)).click();	
		Thread.sleep(4000);

		WebElement submitBtn = driver.findElement(By.xpath(submitButton));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
		Thread.sleep(4000);
		submitBtn.click();
		System.out.println("Moved to submit button");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(errorMsgXpath)));
		
		String text = element.getText();
				if(text.equalsIgnoreCase(ErrorText)) {
					System.out.println("error Message ="+text);
				}else {
					System.out.println("Unable to Get Text");
				}
		}catch(Exception e) {
			System.out.println("error = "+e.getMessage());
		}
	}
	
	
	
	

}
