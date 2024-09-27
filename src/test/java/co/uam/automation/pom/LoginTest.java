/*package co.uam.automation.pom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class LoginTest {

    private WebDriver driver;
    LoginPage loginPage;
    @BeforeMethod
    public void setUp() throws Exception{
        loginPage = new LoginPage(driver);
        driver = loginPage.chromeDriverConnection();
        loginPage.visit("https://www.demoblaze.com/");
    }
    @AfterMethod
    public void tearDown() throws Exception{
        driver.quit();
    }
    @Test
    public void loginUser() throws InterruptedException {
        loginPage.login("username", "password");
        Thread.sleep(2000);
        assertEquals(loginPage.loginSuccessfulText(),
                "Welcome username");
    }

}
 */
package co.uam.automation.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class LoginTest {

    private WebDriver driver;
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;

    @BeforeMethod
    public void setUp() throws Exception {
       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Asegúrate de que el path sea correcto
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        loginPage.visit("https://www.demoblaze.com/");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void loginUserAndPurchaseProduct() throws InterruptedException {
        // Iniciar sesión
        loginPage.login("username", "password");
        Thread.sleep(2000);
       // assertEquals(loginPage.loginSuccessfulText(), "Welcome username");

      /*  // Seleccionar producto
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
        // Verificar el mensaje de confirmación
        assertEquals(loginPage.checkPurchaseMessage(),"Thank you for your purchase!");
*/
    }

    @Test
    public void purchaseProduct() throws InterruptedException{
        loginPage.login("username", "password");
        Thread.sleep(2000);
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
        // Verificar el mensaje de confirmación
        assertEquals(loginPage.checkPurchaseMessage(),"Thank you for your purchase!");
    }
}
