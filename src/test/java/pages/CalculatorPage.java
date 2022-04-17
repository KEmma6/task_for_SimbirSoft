package pages;

import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CalculatorPage extends BasePage{

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    //locators
    private By inputFieldCalculatorLocator = By.xpath("//span[@id='cwos']");
    private By buttonResultLocator = By.xpath("//div[text()='=']");
    private String calculatorButtonsLocator = "//div[text()='%s']";
    private By memoryStringLocator = By.xpath("//span[@class='vUGUtc']");

    //steps
    public CalculatorPage inputValueToCalculatorField(String value){
        List<String> list = new ArrayList(Arrays.asList(value.split(" ")));
        /* перебираем каждый элемент списка с помощью цикла и затем нажимаем на каждый,
         чтобы не прописывать локаторы для каждого значения отдельно */
        for(String button: list){
            driver.findElement(By.xpath(String.format(calculatorButtonsLocator, button))).click();
        }
        return this;
    }

    public CalculatorPage clickResultButton(){
        driver.findElement(buttonResultLocator).sendKeys(Keys.ENTER);
        return this;
    }

    public CalculatorPage memoryStringCheck(String value){
        assertThat(driver.findElement(memoryStringLocator).getText()).contains(value.replaceAll("−","-"));
        return this;
    }

    public CalculatorPage calculationResultCheck(){
        assertThat(driver.findElement(inputFieldCalculatorLocator).getText()).isEqualToIgnoringCase("0");
        return this;
    }
}
