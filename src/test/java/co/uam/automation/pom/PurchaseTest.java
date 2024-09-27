package co.uam.automation.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class PurchaseTest {

    private WebDriver driver;
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;

    @BeforeMethod
    public void setUp() throws Exception {
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        driver = loginPage.chromeDriverConnection();
        loginPage.visit("https://www.demoblaze.com/");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void purchaseProduct() throws InterruptedException {
        // Iniciar sesión
        loginPage.login("username", "password");
        Thread.sleep(2000);
        assertEquals(loginPage.loginSuccessfulText(), "Welcome username");

        // Seleccionar producto
        productPage.selectProduct();
        Thread.sleep(2000);
        productPage.addToCart();
        Thread.sleep(2000);

        // Manejar la alerta
        Alert alert = driver.switchTo().alert();
        alert.accept();

        // Proceder al carrito y realizar la compra
        cartPage.goToCart();
        Thread.sleep(2000);
        cartPage.placeOrder();
        Thread.sleep(2000);

        // Llenar el formulario de compra y confirmar
        cartPage.fillPurchaseForm("John Doe", "USA", "New York", "1234567890123456", "12", "2025");
        cartPage.confirmPurchase();
        Thread.sleep(2000);

        // Verificar el mensaje de confirmación
       // assertEquals(cartPage.getConfirmationMessage(), "Thank you for your purchase!");
    }
}
