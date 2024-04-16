package pages;

import java.time.Duration;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

public WebDriver driver;    
public WebDriverWait wait;


public BaseClass(WebDriver driver){
    this.driver=driver;
    wait=new WebDriverWait(driver, Duration.ofSeconds(7));
}
public void openPage(String url){
driver.get(url); 
}

public void waiting(By element){
wait.until(ExpectedConditions.visibilityOfElementLocated(element));
}

public void openNewPage(By element){
wait.until(ExpectedConditions.visibilityOfElementLocated(element));
driver.findElement(element).click();

}
public void AsertString(String act, String exp){
Assert.assertEquals(exp, act);
}
public Boolean StringContains(String txtExp,String txtAct){
Boolean a=null;
if(txtExp.contains(txtAct)){
    a=true;
}
else{
    a=false;
}
return a; 
}

public void AssertBoolean(Boolean act,Boolean exp){
Assert.assertEquals(exp, act);
}
public void AssertInt(int act, int exp){
Assert.assertEquals(exp, act);    
}

public void writeTxt(By element,String txt){
waiting(element);
driver.findElement(element).sendKeys(txt);    
}
public void scrollDown(int times) throws AWTException{
Robot r=new Robot();
for(int a=1;a<=times;a++){ 
r.keyPress(KeyEvent.VK_DOWN);
r.keyRelease(KeyEvent.VK_DOWN);
}
}

public int verifyLink(String url) throws IOException{
URL linkUrl=new URL(url);
HttpURLConnection httpc=(HttpURLConnection)linkUrl.openConnection();
httpc.connect();
int responseCode=httpc.getResponseCode();
return responseCode;
}

}



    

