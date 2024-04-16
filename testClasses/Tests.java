package testClasses;
import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;

import pages.DataPicker;
import pages.MainPage;
import pages.subPages;

public class Tests extends MainTest {

public MainPage bc;  
public subPages sp;
public DataPicker dp;


public void test1() throws InterruptedException{

bc=new MainPage(driver);
sp=new subPages(driver);
bc.GetMainPage();
Thread.sleep(1000);
bc.OpenDragAndDrop();
sp.executeDragAndDrop();
Thread.sleep(3000);
}
 


public void test2() throws InterruptedException{

bc=new MainPage(driver);
sp=new subPages(driver);
bc.GetMainPage();
Thread.sleep(1000);
bc.OpenDropDown();
sp.dropDownExecute();
Thread.sleep(1000);   
}


public void test3() throws InterruptedException{

bc=new MainPage(driver);    
sp=new subPages(driver);
bc.GetMainPage();
Thread.sleep(1000);
bc.openAlertsPage();
sp.alertHandling();
} 

public void test4() throws InterruptedException{

bc=new MainPage(driver);    
sp=new subPages(driver); 
bc.GetMainPage();
Thread.sleep(1000);
bc.openFormPage();
sp.loginFormHandling();
  
}

public void test5() throws InterruptedException, MalformedURLException, IOException{

bc=new MainPage(driver);    
sp=new subPages(driver); 
bc.GetMainPage();
Thread.sleep(1000); 
bc.opneRedLinkPage();
sp.redirectLinkHandling(); 
}

public void test6_datePicker() throws InterruptedException, AWTException{

bc=new MainPage(driver);    
dp=new DataPicker(driver); 
bc.GetMainPage();
dp.datePickerHandling();
Thread.sleep(1000);     
}


public void test7() throws InterruptedException, AWTException{

bc=new MainPage(driver);    
sp=new subPages(driver); 
bc.GetMainPage();
Thread.sleep(1000);
bc.openUploadPage();
sp.fileUpload();
Thread.sleep(1000);
}

public void test8() throws InterruptedException{

bc=new MainPage(driver);    
sp=new subPages(driver); 
bc.GetMainPage();
Thread.sleep(1000); 
bc.openJQpage();
sp.jQuerieHandling(); 
}


public void test9() throws InterruptedException{

bc=new MainPage(driver);    
sp=new subPages(driver); 
bc.GetMainPage();
Thread.sleep(1000);
bc.openMultiWindowPage();
sp.multiWindowsHandling();
}

public void test10() throws InterruptedException{

bc=new MainPage(driver);    
sp=new subPages(driver); 
bc.GetMainPage();
Thread.sleep(1000);
bc.openTablesPage();
sp.tableDataCheck();

}
@Test
public void test11BrokenLinks() throws IOException{

bc=new MainPage(driver);    
sp=new subPages(driver);
bc.openBrowserStack();
sp.linksTesting();
}
}
