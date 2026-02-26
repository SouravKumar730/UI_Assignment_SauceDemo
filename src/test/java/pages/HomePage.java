package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseTest {

    WebDriver driver;

    String productName = "Grey jacket";

    By firstProduct = By.xpath(
            "//section[contains(@class,'product-grid')]//a//h3[normalize-space()='"
                    + productName + "']"
    );

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstProductName() {
        isElementVisible(firstProduct);
        return driver.findElement(firstProduct).getText();
    }

    public void clickFirstProduct() {
        driver.findElement(firstProduct).click();
    }
}
