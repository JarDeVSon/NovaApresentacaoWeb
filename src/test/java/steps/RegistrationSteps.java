package steps;

import com.github.javafaker.Faker;
import core.Driver;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.HomePage;
import pages.RegisterPage;

import java.io.IOException;
import java.util.Map;

public class RegistrationSteps {

    RegisterPage registerPage = new RegisterPage();
    Faker faker = new Faker();
    HomePage homePage = new HomePage();

    @Dado("Open the browser and Enter the URL {string}")
    public void openTheBrowserAndEnterTheURL(String url) throws Exception {
        try {
            Driver.getDriver().get(url);
            Driver.printScreenshots("Open the browser and Enter the URL {string}");
        } catch (Exception e){
            throw new Exception("Not open the browser and Enter the URL");
        }


    }
    @Quando("Click on My Account Menu")
    public void clickOnMyAccountMenu() throws Exception {
        try {
            registerPage.clickLinkMyAccount();
            Driver.printScreenshots("Click on My Account Menu");
        } catch (Exception e){
            throw new Exception("Not click on My Account Menu");
        }

    }
    @E("Enter registered Email Address in Email-Address textbox")
    public void enterRegisteredEmailAddressInEmailAddressTextbox() throws Exception {
        try {
            registerPage.setInputEmail(faker.internet().emailAddress());
            Driver.printScreenshots("Enter registered Email Address in Email-Address textbox");
        } catch (Exception e){
            throw new Exception("Not enter registered Email Address in Email-Address textbox ");
        }

    }
    @E("Enter your own password in password textbox")
    public void enterYourOwnPasswordInPasswordTextbox() throws Exception {
       try {
           registerPage.setInputPassword(faker.internet().password(7, 15, true, true));
           Driver.printScreenshots("Enter your own password in password textbox");
       } catch (Exception e){
           throw new Exception("Not enter your own password in password textbox");
       }
    }
    @E("Click on Register button")
    public void clickOnRegisterButton() {
        registerPage.setInputRegisterButton();
    }
    @Entao("User will be registered successfully")
    public void userWillBeRegisteredSuccessfully() throws Exception {
        try {
            homePage.getTitleUser();
            Driver.printScreenshots("User will be registered sucessfully");
        } catch (Exception e){
            throw new Exception("User not registered");
        }


    }
    @E("Will be navigated to the Home page")
    public void willBeNavigatedToTheHomePage() throws Exception {
        try {
            String home = homePage.getTitleUser();
            Assert.assertEquals(homePage.getTitleUser(), home);
            Driver.printScreenshots("will be navigated to the Home page");
        } catch (Exception e){
            throw new Exception("will not be navigated to the HomePage");
        }

    }
    @Quando("Enter invalid Email Address in <Email-Address> textbox")
    public void enterInvalidEmailAddressInEmailAddressTextbox(Map<String,String> map) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        try {
            String email = map.get("Email Address");
            registerPage.setInputEmail(email);
        } catch (Exception e){
            throw new Exception("Not enter invalid Email Address in textbox");
        }


    }
    @Quando("Enter your own password in 3Hpo31as$ textbox")
    public void enterYourOwnPasswordIn3Hpo31as$Textbox(Map<String, String> map) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        try {
            String password = map.get("password");
            registerPage.setInputPassword(password);
        } catch (Exception e) {
            throw new Exception("Not enter your own password in textbox");
        }

    }

    @Entao("Registration must fail with a warning message:")
    public void registrationMustFailWithAWarningMessage(Map<String, String> map) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        try {
            String message = map.get("Message");
            registerPage.GetMessage(message);
            Assert.assertEquals(message, registerPage.GetMessage(message));
        } catch (Exception e){
            throw new Exception("Message");
        }
    }
}