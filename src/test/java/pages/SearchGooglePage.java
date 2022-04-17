package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchGooglePage extends BasePage{

    //locators
    private By inputSearchLocator = By.xpath("//input[@title='Поиск']");
    private By searchButtonLocator = By.xpath("//div[@class='aajZCb']//input[@aria-label='Поиск в Google']");


    //steps
    public SearchGooglePage(WebDriver driver) {
        super(driver);
    }

    public SearchGooglePage openPage(){
         driver.get("https://www.google.com/");
         return this;
    }

    public SearchGooglePage inputValueToSearchField(){
        driver.findElement(inputSearchLocator).sendKeys("Калькулятор");
        return this;
    }

    public SearchGooglePage clickSearchButton(){
        driver.findElement(searchButtonLocator).click();
        return this;
    }
}
