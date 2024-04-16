package testClasses;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilitu.factory;

public class MainTest {

public WebDriver driver;  

@Before
public void setup(){
System.setProperty("webdriver.gecko.driver",factory.gecko);
driver=new FirefoxDriver();
driver.manage().window().maximize();
}
@After
public void end(){
driver.quit();     
}

    
}
