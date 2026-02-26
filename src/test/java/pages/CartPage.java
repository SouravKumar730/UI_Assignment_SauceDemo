package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BaseTest {

    WebDriver driver;

    By cartItems = By.xpath("//div[@class='one columns quantity tr']//input[@value='1']");
    By productName = By.xpath("//a[text()='Grey jacket - Grey jacket']");
    By removeButton = By.xpath("//a[text()='Remove']");
    By emptyCartMessage = By.xpath("//*[contains(text(),'Your cart is empty')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getCartItemCount() {
        isElementVisible(cartItems);
        return driver.findElements(cartItems).size();
    }

    public String getProductName() {
        isElementVisible(productName);
        return driver.findElement(productName).getText();
    }

    public void removeItem() {
        isElementVisible(removeButton);
        driver.findElement(removeButton).click();
    }

    public boolean isCartEmpty() {
        return !driver.findElements(emptyCartMessage).isEmpty();
    }
}
