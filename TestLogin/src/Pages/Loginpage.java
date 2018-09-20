package Pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class Loginpage {
    WebDriver driver;
   
    
    public Loginpage(WebDriver driver) {
    	this.driver = driver;
    }
    
	public void userlogin (String userName, String password) {
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.className("btn-primary")).click();
	}
	public void userregister (String first, String last, String usrname, String Passwrd) {
	    driver.findElement(By.name("firstName")).sendKeys(first);       
	    driver.findElement(By.name("lastName")).sendKeys(last);
	    driver.findElement(By.name("username")).sendKeys(usrname);
	    driver.findElement(By.name("password")).sendKeys(Passwrd);
	    driver.findElement(By.className("btn-primary")).click();
	    
		}
	
    public void VerifyregistrationSuccess() {
    	String msg ="";
    	
        WebDriverWait mywait = new WebDriverWait(driver, 30);
        mywait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("alert-success")));
        
    	msg = driver.findElement(By.className("alert-success")).getText();

 	    Assert.assertTrue("TEST FAIL - Expect user registration Successful", msg.contains("successful"));
   	   

    }

    

    public void verifycorrectUserLogin(String firstname, String lastname) {	
    	String msg ="";
    	String pagesrc ="";
    	String name = firstname + " " + lastname;
    	String Hiuser = "Hi " + firstname;
    	boolean isTheTextPresent = false;
 
      	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
        WebDriverWait mywait = new WebDriverWait(driver, 30);
        mywait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[1]/div/div/div/div/div/h3")));     
        isTheTextPresent = driver.getPageSource().contains(Hiuser);
        Assert.assertTrue("TEST FAIL - Expect to see Hi first name not found" ,isTheTextPresent);
        
        msg = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/ul/li")).getText();

 	    Assert.assertTrue("TEST FAIL - Expected first name and last name not found!", msg.contains(name));
     
 	    
    }    
    public void verifyIncorrectUserLogin() {	
    	String msg ="";
    	
        WebDriverWait mywait = new WebDriverWait(driver, 30);
        mywait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("alert-danger")));
        
    	msg = driver.findElement(By.className("alert-danger")).getText();

 	    Assert.assertTrue("TEST FAIL - Expect User login incorrect !", msg.contains("incorrect"));
   	 
    }

	
	public void clickregister(){
		driver.findElement(By.className("btn-link")).click();
        WebDriverWait mywait = new WebDriverWait(driver, 30);
        mywait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("firstName")));
        
        
	}
	public void clickcancel(){

        driver.findElement(By.className("btn-link")).click();
        WebDriverWait mywait = new WebDriverWait(driver, 30);
        mywait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("username")));
        

	}
	public void clickLogout(){

        WebDriverWait mywait = new WebDriverWait(driver, 30);
        mywait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Logout")));
        
		driver.findElement(By.linkText("Logout")).click();
	}
}
