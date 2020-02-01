package pages;

import drivers.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AmazonHomePage extends BasePage {

    @FindBy(css = "#twotabsearchtextbox")
    private WebElement searchField;

    @FindBy(xpath = "//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")
    private  WebElement searchButton;

    @FindBy(xpath = "//span[contains(text(),'Apple iPhone XR (64GB) - Yellow')]")
    private WebElement selectItem;

    @FindBy(xpath = "//span[contains(text(),'Apple iPhone XR (64GB) - Yellow')]/ancestor::div[@class='sg-col-inner'][2]//span[@class='a-price-whole']")
    private WebElement itemPrice;

    public AmazonHomePage(){
        driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void enterSearchItem(){
        searchField.sendKeys("iPhone XR (64GB) - Yellow");
        searchButton.click();

    }
    public int selectAndGetPrice()
    {
        int retVal = 0;
        retVal = Integer.parseInt(itemPrice.getText().replace(",",""));
        return  retVal;
    }
}
