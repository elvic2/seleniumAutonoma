package co.uam.automation.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    public By addToCartButton = By.xpath("//a[text()='Add to cart']");
    public By productLink = By.linkText("Samsung galaxy s6");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void selectProduct() {
        click(productLink);
    }

    public void addToCart() {
        click(addToCartButton);
    }
}
