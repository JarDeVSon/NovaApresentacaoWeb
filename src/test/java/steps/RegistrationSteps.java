package steps;

import com.github.javafaker.Faker;
import core.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.HomePage;
import pages.RegisterPage;

import java.io.IOException;
import java.util.Map;
import java.util.Timer;

public class RegistrationSteps {

    RegisterPage registerPage = new RegisterPage();
    Faker faker = new Faker();
    HomePage homePage = new HomePage();




    @Dado("Open the browser and Enter the URL {string}")
    public void openTheBrowserAndEnterTheURL(String url) throws IOException {
        Driver.getDriver().get(url);
        Driver.printScreenshots("Open the browser and Enter the URL {string}");

    }
    @Quando("Click on My Account Menu")
    public void clickOnMyAccountMenu() throws IOException {
        registerPage.clickLinkMyAccount();
        Driver.printScreenshots("Click on My Account Menu");
    }
    @E("Enter registered Email Address in Email-Address textbox")
    public void enterRegisteredEmailAddressInEmailAddressTextbox() throws IOException {
        registerPage.setInputEmail(faker.internet().emailAddress());
        Driver.printScreenshots("Enter registered Email Address in Email-Address textbox");
    }
    @E("Enter your own password in password textbox")
    public void enterYourOwnPasswordInPasswordTextbox() throws IOException {
        registerPage.setInputPassword(faker.internet().password(7,15,true,true));
        Driver.printScreenshots("Enter your own password in password textbox");
    }
    @E("Click on Register button")
    public void clickOnRegisterButton() {
        registerPage.setInputRegisterButton();
    }
    @Entao("User will be registered successfully")
    public void userWillBeRegisteredSuccessfully() throws IOException {
        homePage.getTitleUser();
        Driver.printScreenshots("User will be registered sucessfully");
    }
    @E("will be navigated to the Home page")
    public void willBeNavigatedToTheHomePage() throws IOException {
        String home = homePage.getTitleUser();

        Assert.assertEquals(homePage.getTitleUser(), home);
        Driver.printScreenshots("will be navigated to the Home page");
    }
    @Quando("Enter invalid Email Address in <Email-Address> textbox")
    public void enterInvalidEmailAddressInEmailAddressTextbox(Map<String,String> map) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        String email = map.get("Email Address");
        registerPage.setInputEmail(email);

    }
    @Quando("Enter your own password in 3Hpo31as$ textbox")
    public void enterYourOwnPasswordIn3Hpo31as$Textbox(Map<String, String> map) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        String password = map.get("password");
        registerPage.setInputPassword(password);
    }

    @Entao("Registration must fail with a warning message:")
    public void registrationMustFailWithAWarningMessage(Map<String, String> map) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        Thread.sleep(2000);
       String message = map.get("Message");
       registerPage.GetMessage(message);
       Assert.assertEquals(message, registerPage.GetMessage(message));
    }
}