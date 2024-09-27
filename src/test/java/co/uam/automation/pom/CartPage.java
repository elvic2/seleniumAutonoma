package co.uam.automation.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage extends BasePage {

    public By cartLink = By.id("cartur");
    public By placeOrderButton = By.xpath("//button[text()='Place Order']");
    public By nameField = By.id("name");
    public By countryField = By.id("country");
    public By cityField = By.id("city");
    public By cardField = By.id("card");
    public By monthField = By.id("month");
    public By yearField = By.id("year");
    public By purchaseButton = By.xpath("//button[text()='Purchase']");
    public By confirmationMessage = By.xpath("//h2[contains(text(),'Thank you for your purchase!')]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void goToCart() {
        click(cartLink);
    }

    public void placeOrder() {
        click(placeOrderButton);
    }

    public void fillPurchaseForm(String name, String country, String city, String card, String month, String year) {
        type(name, nameField);
        type(country, countryField);
        type(city, cityField);
        type(card, cardField);
        type(month, monthField);
        type(year, yearField);
    }

    public void confirmPurchase() {
        click(purchaseButton);
    }

    /*public String getConfirmationMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage));
        return getText(confirmationMessage);
    }*/
}
