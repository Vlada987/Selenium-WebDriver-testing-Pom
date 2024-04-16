package pages;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DataPicker extends BaseClass{

public DataPicker(WebDriver driver) {
    super(driver);
}

String dpfxp="//iframe[@class='demo-frame']";
String dpoxp="//input[@id='datepicker']";
String dpfcss=".demo-frame";
String monthXp="/html/body/div/div/div/span[1]";
String yearXp="/html/body/div/div/div/span[2]";
String nextXp="/html/body/div/div/a[2]/span";
String daysXp="/html/body/div/table/tbody/tr/td/a";
String month="June";
String year="2025";
String WantedDay="15";

public DataPicker datePickerHandling  () throws AWTException{

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));    
scrollDown(5);
WebElement frame1 = driver.findElement(By.cssSelector(dpfcss));    
driver.switchTo().frame(frame1);
driver.findElement(By.xpath(dpoxp)).click();
while(1==1){
driver.findElement(By.xpath(nextXp)).click();
String m=driver.findElement(By.xpath(monthXp)).getText();
String y=driver.findElement(By.xpath(yearXp)).getText();
if(m.equals(month)&&y.equals(year)){
break;
}
}
List<WebElement> days = driver.findElements(By.xpath(daysXp));
for(WebElement day:days){
    if(day.getText().equals(WantedDay)){
    day.click();
    }
}
return this;

}


}
