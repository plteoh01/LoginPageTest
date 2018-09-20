package TestPackage;

//import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.Loginpage;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class Test1 {
	
	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver","./BrowserDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
   
          
          driver.get("http://react-redux-registration-login-example.stackblitz.io/login");

          WebDriverWait mywait = new WebDriverWait(driver, 30);
          mywait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("username")));
          
          driver.manage().window().maximize() ;
      	
          Loginpage login;
          
	        login = new Loginpage(driver);

	        
	        //non registered user login, verify login should fail
	        login.userlogin("usrname3","Passwrd3");
	        login.verifyIncorrectUserLogin();
	        
	        login.clickregister();
	        // user registration, verify registration should success
	        login.userregister("first0", "last0", "usrname0", "Passwrd0");
	        //verify success
	        login.VerifyregistrationSuccess();
	        
	        
	        login.clickregister();
	        // user registration verify registration should success - multiple registration is ok
	        login.userregister("first2", "last2", "usrname2", "Passwrd2");
	        login.VerifyregistrationSuccess();
	        
	        
	        driver.get("http://react-redux-registration-login-example.stackblitz.io/login");

		    driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	        
	        //registered user login, verify login should success, 
		    // Hi firstname is displayed, first name and last last in the registered list
	        login.userlogin("usrname0","Passwrd0");     
	        login.verifycorrectUserLogin("first0", "last0");
	        
	        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	        login.clickLogout(); 
   
	        
	        driver.close();
	}

}
