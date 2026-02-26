package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BaseTest {

    WebDriver driver;

    By addToCartButton = By.xpath("//input[@value='Add to Cart']");
    By checkoutLink = By.xpath("//a[text()='Check Out']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart() {
        isElementVisible(addToCartButton);
        driver.findElement(addToCartButton).click();
    }

    public void goToCheckout() {
        isElementVisible(checkoutLink);
        driver.findElement(checkoutLink).click();
    }
}
