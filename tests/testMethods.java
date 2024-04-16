package tests;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// Multiple simple automation tests methods- main method is on 
// the bottom.
// For execute any of tests first run the setup(); method than
// desired test method.

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.print.DocFlavor.STRING;
import javax.swing.Action;
import javax.swing.text.html.Option;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert; 
//import dev.failsafe.internal.util.Assert;


public class testMethods {

   public static WebDriver driver;
   public static WebDriverWait wt;
  
  //Method for oppening the browser
  public static void setup(){
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\zikaz\\OneDrive\\Desktop\\SimpleTests\\SimpleTest\\lib\\geckodriver.exe");
    driver = new FirefoxDriver();
    wt = new WebDriverWait(driver, Duration.ofSeconds(11));
    driver.manage().window().maximize();

  }
 
  //Function to pick up the element drag, and drop on other spot
  public static void dragAndDrop(){
    driver.get("https://the-internet.herokuapp.com/drag_and_drop");
    WebElement a = driver.findElement(By.xpath("//div[@id='column-a']"));
    WebElement b = driver.findElement(By.xpath("//div[@id='column-b']"));
    Actions ac = new Actions(driver);
    ac.dragAndDrop(a, b).build().perform();
   }

   //Function for selecting radio buttons
  public static void radioButton(){
    driver.get("https://qa-automation-practice.netlify.app/radiobuttons.html");
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//button[@id='sidebarCollapse']")).click();
    List <WebElement> buttons = driver.findElements(By.xpath("//label[@class='form-check-label']"));
    for(WebElement button: buttons){
      if(button.getText().equalsIgnoreCase("Radio button 2")){
        button.click();
     }
    }
   }

   //Function to select a date in a calendar
   public static void datePickerSelect(){
    driver.get("https://jqueryui.com/datepicker/");
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//input[@id='datepicker']")).click();
    String month = "April";
    String year = "2025";
    String day = "23";
    while(!(driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().equals(month)) 
    && driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().equals(year)){
    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
      }
    List <WebElement> days = driver.findElements(By.xpath("//a[@class='ui-state-default']"));
    for(WebElement d:days){
      if(d.getText().equals(day)){
        d.click();
      }
    }
  }

   //DropDown selection in a different frame whitin a webpage
   public static void frameSelect(){
    WebElement frame1 = driver.findElement(By.cssSelector("#frm1"));
    driver.switchTo().frame(frame1);
    WebElement dropDownMenu = driver.findElement(By.cssSelector("#selectnav2"));
    Select s1 = new Select(dropDownMenu);
    s1.selectByIndex(2);
  }

   //Search and play a video on YouTube
   public static void playAsongOnYouT(){
    driver.get("https://www.youtube.com/");
    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    By search = By.xpath("//input[@id='search']");
    driver.findElement(search).sendKeys("despacito");
    driver.findElement(search).submit();
    By songDespacito = By.xpath("//a[@title='Luis Fonsi - Despacito ft. Daddy Yankee']");
    driver.findElement(songDespacito).click();
 }
       
  //Function for selecting a checkbox
  public static void checkbox(){
    driver.get("https://the-internet.herokuapp.com/checkboxes");
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    List <WebElement> bb = driver.findElements(By.xpath("//input[@type='checkbox']"));
    for(WebElement b: bb){
        if(b.getText().equalsIgnoreCase("checkbox 1")){
            b.click();
   }
  }     
 }

  //Funcion for selection a dropdown menu
  public static void dropDown(){
    driver.get("https://the-internet.herokuapp.com/dropdown");
    WebElement dDown = driver.findElement(By.id("dropdown"));
    Select s = new Select(dDown);
    s.selectByIndex(2);
 }


  //Function for handling jsAlerts on a webpage
  public static void jsAlerts(){    
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    By jsAlert1 = By.xpath("//button[@onclick='jsAlert()']");
    driver.findElement(jsAlert1).click();
    Alert a = driver.switchTo().alert();
    a.accept();
  
    }

  //Function to scroll down Web Page
  public static void scroll(){
    driver.get("http://omayo.blogspot.com/");
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    JavascriptExecutor jz = (JavascriptExecutor) driver;
    jz.executeScript("window.scrollBy(0,450)");
  }  

  //Function to confirm presence of elements on a web page.
  public static void display(){
    driver.get("http://omayo.blogspot.com/");
    Boolean act = driver.findElement(By.xpath("//input[@class='gsc-search-button']")).isDisplayed();
    Boolean exp = true;
    Assert.assertEquals(exp, act);

  }

  //Fuction to open a new tab and and navigate to other URL.
  public static void windowHandle(){
    driver.get("http://omayo.blogspot.com/");
    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

    String mainH = driver.getWindowHandle();
    driver.findElement(By.id("selenium143")).click();
    Set<String> Hs = driver.getWindowHandles();
    java.util.Iterator<String> it = Hs.iterator();
    for(String h:Hs){
      String ha = it.next();
      driver.switchTo().window(ha);
      if(!driver.getWindowHandle().equals(mainH)){
        driver.switchTo().window(ha);
      }
    }
    driver.findElement(By.linkText("What is Selenium?")).click();

    }
    public static void multi(){
      driver.get("http://omayo.blogspot.com/");
      WebElement e = driver.findElement(By.id("multiselect1"));
      Select s = new Select(e);
      List<WebElement> options = s.getOptions();
      for(WebElement o:options){
        if(o.getText().equals("Audi")){
          o.click();
        }
      }


    }
  //Getting a screenShot of element and saving as a new file
  public static void takePhotoOfElement() throws IOException{
    driver.get("http://omayo.blogspot.com/");
    WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
    w.until(ExpectedConditions.visibilityOfElementLocated(By.id("multiselect1")));
    File photo = driver.findElement(By.id("multiselect1")).getScreenshotAs(OutputType.FILE);
    FileHandler.copy(photo, new File(System.getProperty("user.dir")+"\\scr1.png"));

}
  //Performing the right click action
  public static void rightClick(){
    driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    WebElement RCbutton = driver.findElement(By.xpath("/html/body/div/section/div/div/div/p/span"));
    Actions act = new Actions(driver);
    act.contextClick(RCbutton).perform();
    driver.findElement(By.xpath("/html/body/ul/li[1]/span")).click();
    try {
      Thread.sleep(2);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Alert al = driver.switchTo().alert();
    al.accept();

  }
  //Getting location of element and click using Robot class
  public static void rbtClick() throws AWTException{
    driver.get("http://omayo.blogspot.com/");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
    String mainWindow = driver.getWindowHandle();
    WebElement linkButton = driver.findElement(By.id("selenium143"));
    Point pt = linkButton.getLocation();
    int y = pt.getY(); //320
    int x = pt.getX(); //185
    Robot rbt = new Robot();
    rbt.mouseMove(185,320);
    rbt.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    rbt.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    Set<String> windowHandles = driver.getWindowHandles();
    for(String handle:windowHandles){
      if(!handle.equals(mainWindow)){
        driver.switchTo().window(handle);
        
      }
    }
    driver.close();
    driver.switchTo().window(mainWindow);
  }

  //Handling the window elements using Robot class (upload a file)
  public static void uploadFile() throws AWTException{
    driver.get("https://the-internet.herokuapp.com/upload");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    Robot rbt = new Robot();
    Point loc = driver.findElement(By.id("file-upload")).getLocation();
    int y = loc.getY();
    int x = loc.getX();
    rbt.mouseMove(x+8, y+88); //point give incorect cordinates :( 
    rbt.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    rbt.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    rbt.delay(2500);
    rbt.keyPress(KeyEvent.VK_K);
    rbt.keyRelease(KeyEvent.VK_K);
    rbt.keyPress(KeyEvent.VK_E);
    rbt.keyRelease(KeyEvent.VK_E);
    rbt.keyPress(KeyEvent.VK_C);
    rbt.keyRelease(KeyEvent.VK_C);
    rbt.keyPress(KeyEvent.VK_ENTER);
    rbt.keyRelease(KeyEvent.VK_ENTER);
  }
  //Handling alert pop-up typing hello and submit using robot class
  public static void alert2Robot() throws AWTException{
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[3]/button")).click();
    Robot rbt = new Robot();
    rbt.keyPress(KeyEvent.VK_H);
    rbt.keyRelease(KeyEvent.VK_H);
    rbt.keyPress(KeyEvent.VK_E);
    rbt.keyRelease(KeyEvent.VK_E);
    rbt.keyPress(KeyEvent.VK_L);
    rbt.keyRelease(KeyEvent.VK_L);
    rbt.keyPress(KeyEvent.VK_L);
    rbt.keyRelease(KeyEvent.VK_L);
    rbt.keyPress(KeyEvent.VK_O);
    rbt.keyRelease(KeyEvent.VK_O);
    rbt.delay(2024);
    rbt.keyPress(KeyEvent.VK_ENTER);
    rbt.keyRelease(KeyEvent.VK_ENTER);

    }
  //Testing links on a page and reading responce code
  public static void linksValidation() throws MalformedURLException, IOException {
    driver.get("https://tutorialsninja.com/demo/");
    List<WebElement> links = driver.findElements(By.tagName("a"));
    for(WebElement link:links){
      String linkTxt = link.getAttribute("href");
      if(linkTxt.equals(null)||linkTxt.isEmpty()){
        System.out.println("broken link present");
        continue;
      }
      HttpURLConnection huk = (HttpURLConnection)(new URL(linkTxt).openConnection());
      huk.connect();
      int responseCode = huk.getResponseCode();
      System.out.println(responseCode);

    }
     
  } 
  //Testing a link on a Web page and getting the responce code
  public static void checkLink() throws IOException{
    driver.get("http://omayo.blogspot.com/");
    WebElement linkElement = driver.findElement(By.id("selenium143"));
    String link = linkElement.getAttribute("href");
    HttpURLConnection hconn = (HttpURLConnection) (new URL(link).openConnection());
    hconn.connect();
    int responseCode = hconn.getResponseCode();
    System.out.println(responseCode);
  }

  //Getting a collor from WebElement
  public static void colorTest(){
    driver.get("http://omayo.blogspot.com/");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    WebElement menuBar = driver.findElement(By.xpath("//div[@id='cssmenu']/ul"));
    String colorString = menuBar.getCssValue("background-color");
    System.out.println(colorString);
    Color color = Color.fromString(colorString);
    String colorHex = color.asHex();
    System.out.println(colorHex);
  }

public static void vezba() throws InterruptedException {

driver.get("https://the-internet.herokuapp.com/upload");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
driver.findElement(By.id("file-upload")).click();
Thread.sleep(1000);


}
  



  
  

    public static void main(String[] args) throws InterruptedException {
    driver.quit();
    
      
  }


     
}

