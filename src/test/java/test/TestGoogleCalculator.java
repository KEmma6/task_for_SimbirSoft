package test;

import org.junit.jupiter.api.Test;
import pages.CalculatorPage;
import pages.SearchGooglePage;

public class TestGoogleCalculator extends TestBase{

    SearchGooglePage searchGooglePage = new SearchGooglePage(driver);
    CalculatorPage calculatorPage = new CalculatorPage(driver);
    String accountValue = "1 × 2 − 3 + 1";

    @Test
    public void testCalculator(){

        searchGooglePage
                .openPage()
                .inputValueToSearchField()
                .clickSearchButton();

        calculatorPage
                .inputValueToCalculatorField(accountValue)
                .clickResultButton()
                .memoryStringCheck(accountValue)
                .calculationResultCheck();
    }
}
