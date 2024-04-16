package tests;

import java.time.Duration;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testVezba {

WebDriver driver;

@Test
public void testing() throws InterruptedException{

System.setProperty("webdriver.gecko.driver", "C:\\Users\\zikaz\\OneDrive\\Desktop\\SimpleTests\\SimpleTest\\lib\\geckodriver.exe");
driver = new FirefoxDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
driver.get("https://www.youtube.com/watch?v=jr0K2wjgh2E");
String commentXp="//yt-attributed-string[@id='content-text']";
List<WebElement> elements = driver.findElements(By.xpath(commentXp));
for(WebElement e:elements){
String text = e.getText();
if(text.contains("indikat")){
    System.out.println(text);
}
else{
    System.out.println("Nema");
}
}

Thread.sleep(5000);
driver.quit();

}
    
}
