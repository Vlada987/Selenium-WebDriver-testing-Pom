package pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.time.Duration;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Point;
import utilitu.factory;

public class subPages extends BaseClass {



public subPages(WebDriver driver) {
    super(driver);     
}

public subPages executeDragAndDrop(){

WebElement a=driver.findElement(By.id("column-a"));
WebElement b=driver.findElement(By.id("column-b")); 
Actions ac=new Actions(driver);
ac.dragAndDrop(b, a);
return this;
}

public subPages dropDownExecute() throws InterruptedException{

WebElement dd=driver.findElement(By.id("dropdown"));
Select s=new Select(dd);
s.selectByIndex(1);
String option1=s.getFirstSelectedOption().getText();
AsertString(option1, "Option 1");
Thread.sleep(1000);
s.selectByIndex(2);
String option2=s.getFirstSelectedOption().getText();
AsertString(option2, "Options 2"); 
return this;
}

public subPages alertHandling() throws InterruptedException{

By alert1=By.xpath(factory.xpAlert1);   
waiting(alert1);
driver.findElement(alert1).click();
Thread.sleep(1000);
Alert a=driver.switchTo().alert();
a.accept();
By alert3=By.xpath(factory.xpAlert3);
waiting(alert3);
driver.findElement(alert3).click();
Alert a2=driver.switchTo().alert();
a2.sendKeys("today is 27.03.2024");
a2.accept();
String alertMessage = driver.findElement(By.id("result")).getText();
Boolean stringContains = StringContains(alertMessage, "today");
AssertBoolean(stringContains, true);
return this;    
}

public subPages loginFormHandling () throws InterruptedException{

By uName=By.id("username");
By pwd=By.id("password");
By logB=By.xpath(factory.loginButtonXp);
writeTxt(uName, factory.uName);
writeTxt(pwd, factory.pwd);
driver.findElement(logB).click();
Thread.sleep(900);
String LoginConfTxtAct=driver.findElement(By.id("flash")).getText();
Boolean loginTxt = StringContains(LoginConfTxtAct, factory.loginConf);   
AssertBoolean(loginTxt, true);
return this;
}

public subPages redirectLinkHandling() throws MalformedURLException, IOException, InterruptedException{

WebElement link = driver.findElement(By.linkText("Elemental Selenium"));
String mainWindow=driver.getWindowHandle();
String url = link.getAttribute("href");
HttpURLConnection huc=(HttpURLConnection)(new URL(url).openConnection());
huc.connect();
int resCode = huc.getResponseCode();
AssertInt(resCode, 301);
driver.findElement(By.linkText("Elemental Selenium")).click();
Set<String> handles = driver.getWindowHandles();
for(String handle:handles){
if(!handle.equals(mainWindow)){
driver.switchTo().window(handle);    
}
}
String title = driver.getTitle();
Boolean titleCheck = StringContains("elenium",title);
AssertBoolean(titleCheck, true);
driver.close();
driver.switchTo().window(mainWindow);
return this;
}

public subPages fileUpload() throws AWTException, InterruptedException{

//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
driver.findElement(By.cssSelector("#file-upload")).click();
//Point p=driver.findElement(By.id("file-upload")).getLocation();
//int y = p.getY();
//int x = p.getX();
Robot robot=new Robot();
//robot.mouseMove(x+10, y+47); //point give incorect cordinates :( 
//Thread.sleep(2000);
//robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
robot.delay(15000);
robot.keyPress(KeyEvent.VK_U);
robot.keyRelease(KeyEvent.VK_U);
Thread.sleep(1000);
robot.keyPress(KeyEvent.VK_DOWN);
robot.keyRelease(KeyEvent.VK_DOWN);
Thread.sleep(1000);
robot.keyPress(KeyEvent.VK_ENTER);
robot.keyRelease(KeyEvent.VK_ENTER);
Thread.sleep(4000);
//driver.findElement(By.id("file-submit")).click();
//String SuccsesUploadAct = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3")).getText();
//AsertString(SuccsesUploadAct, "File Uploaded!");
return this;
}

public subPages jQuerieHandling() throws InterruptedException{

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
WebElement el1 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/ul/li[2]/a"));
Actions actions=new Actions(driver);
Thread.sleep(1500);
actions.moveToElement(el1).build().perform();
Thread.sleep(1500);
WebElement el2 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/ul/li[2]/ul/li[1]/a"));
actions.moveToElement(el2).build().perform();
Thread.sleep(1500);
WebElement el3 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/ul/li[2]/ul/li[1]/ul/li[3]/a"));
el3.click();
return this; 
}

public subPages multiWindowsHandling() throws InterruptedException{

String mainWindow = driver.getWindowHandle();
driver.findElement(By.xpath("/html/body/div[2]/div/div/a")).click();
Set<String> windowHandles = driver.getWindowHandles();
for(String window:windowHandles){
    if(!window.equals(mainWindow)){
    driver.switchTo().window(window);
}
}
Thread.sleep(300);
String titleAct = driver.getTitle();
AsertString(titleAct, "New Window");
driver.close();
Thread.sleep(300);
driver.switchTo().window(mainWindow);
String MaintitleAct = driver.getTitle();
AsertString(MaintitleAct, "The Internet");
return this;    
}

public subPages tableDataCheck(){

int rows = driver.findElements(By.xpath(factory.tRowCountXP)).size();
String [] names=new String[rows];
for(int r=1;r<=rows;r++){
WebElement nameEL = driver.findElement(By.xpath(factory.tdNamesXP+"/tr["+r+"]/td[2]"));
names[r-1]=nameEL.getText();
}  
AsertString(names[0], "John");
AsertString(names[1], "Frank");
AsertString(names[2], "Jason");
AsertString(names[3], "Tim");
return this;
}

public subPages linksTesting() throws IOException{

List<Integer>codes=new ArrayList<>();
List<WebElement> links = driver.findElements(By.tagName("a"));
int numOfLinks=links.size();
for(WebElement link:links){
String linkUrl=link.getAttribute("href");
int code=verifyLink(linkUrl);
codes.add(code);
}
for(int code1:codes){
if(code1<400){
System.out.println("Links are OK");
}
else{
System.out.println("Links are broken");
}
}
System.out.println(codes);
return this;    
}
}