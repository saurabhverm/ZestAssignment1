package pages;

import drivers.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartHomePage extends BasePage {
    @FindBy(xpath = "//input[@placeholder='Search for products, brands and more']")
    private WebElement searchField;

    @FindBy(xpath = "//body/div[@id='container']/div/div[@class='_3ybBIU']/div[@class='_1tz-RS']/div[@class='_3pNZKl']/div[@class='Y5-ZPI']/form[@class='_1WMLwI header-form-search']/div[@class='col-12-12 _2tVp4j']/button[@class='vh79eN']/*[1]")
    private WebElement searchButton;

    @FindBy(xpath = "/html/body/div[2]/div/div/button")
    private WebElement cancelButton;

    @FindBy(xpath = "//div[text()='Apple iPhone XR (Yellow, 64 GB)']/../following-sibling::div//div[@class='_1vC4OE _2rQ-NK']")
    private WebElement itemPrice;

    public FlipkartHomePage(){
        driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }
    public void enterSearchItem(){
        cancelButton.click();
        searchField.sendKeys("iPhone XR (64GB) - Yellow");
        searchButton.click();

    }
    public int selectAndGetPrice()
    {
        int retVal = 0;
        retVal = Integer.parseInt(itemPrice.getText().substring(1).replace(",",""));
        return  retVal;
    }

}
