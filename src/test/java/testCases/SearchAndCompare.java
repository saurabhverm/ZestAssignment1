package testCases;

import org.testng.annotations.Test;

public class SearchAndCompare extends TestBase {
    @Test
    public void searchCompare()
    {
        navigateTo("https://www.amazon.in/");
        amazonHomePage.enterSearchItem();
        int amazonPrice = amazonHomePage.selectAndGetPrice();
        navigateTo("https://www.flipkart.com/");
        flipkartHomePage.enterSearchItem();
        int flipKartPrice = flipkartHomePage.selectAndGetPrice();
        if(amazonPrice<flipKartPrice)
        {
            System.out.println("Amazon is having less price for Iphone XR");
        }
        else if(flipKartPrice<amazonPrice)
        {
            System.out.println("Flipkart is having less price for Iphone XR");
        }
        else
            System.out.println("Both are having same price for Iphone XR");
    }
}
