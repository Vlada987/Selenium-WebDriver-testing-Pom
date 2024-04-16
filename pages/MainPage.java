package pages;
import org.checkerframework.checker.guieffect.qual.UI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilitu.factory;

public class MainPage extends BaseClass{

public MainPage(WebDriver driver) {
        super(driver);
}
 
public MainPage GetMainPage(){
openPage(factory.urlHeroku);
return this;
}

public MainPage OpenDragAndDrop (){
By dnd=By.linkText(factory.dragAndDrop);
openNewPage(dnd);
return this;
}
public MainPage OpenDropDown  (){
By ddown=By.linkText(factory.dropDown);
openNewPage(ddown);
return this;        
}
public MainPage openAlertsPage  (){
By al=By.linkText(factory.alerts);
openNewPage(al);
return this;
}
public MainPage openFormPage  (){
By form=By.linkText(factory.form);
openNewPage(form);
return this;
}
public MainPage opneRedLinkPage  (){
By RedL=By.linkText(factory.redirectLink);
openNewPage(RedL);
return this;
}
public MainPage openUploadPage  (){
By uploadFile=By.linkText(factory.fileUpload);
openNewPage(uploadFile);
return this;
}
public MainPage openJQpage  (){
By jquerie=By.linkText(factory.jQueryMenu);
openNewPage(jquerie);
return this;
}
public MainPage openMultiWindowPage  (){
By mulWin=By.linkText(factory.multiWin);
openNewPage(mulWin);
return this;
}
public MainPage openTablesPage  (){
By table=By.linkText(factory.tables);
openNewPage(table);
return this; 
}
public MainPage openBrowserStack   (){
openPage(factory.browserStackURL);
return this;

}


}
