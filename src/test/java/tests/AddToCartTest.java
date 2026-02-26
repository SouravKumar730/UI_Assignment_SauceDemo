package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class AddToCartTest extends BaseTest {

    @Test
    public void verifyUserCanAddProductToCart() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        String selectedProductName = homePage.getFirstProductName();
        homePage.clickFirstProduct();
        productPage.addProductToCart();

        productPage.goToCheckout();

        Thread.sleep(10);

        Assert.assertEquals(cartPage.getCartItemCount(), 1,
                "Cart item count is incorrect");

        Assert.assertTrue(cartPage.getProductName().contains(selectedProductName),
                "Product name does not match in cart");
    }

    @Test
    public void verifyUserCanRemoveProductFromCart() {

        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.clickFirstProduct();
        productPage.addProductToCart();
        productPage.goToCheckout();

        cartPage.removeItem();

        Assert.assertTrue(cartPage.isCartEmpty(),
                "Cart is not empty after removing product");
    }
}
