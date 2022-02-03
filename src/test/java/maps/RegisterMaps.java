package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterMaps {

    @FindBy(linkText = "My Account")
    public WebElement linkMyAccount;
    @FindBy(css = "#reg_email")
    public WebElement inputEmailAdress;
    @FindBy(css = "#reg_password")
    public WebElement inputPassword;
    @FindBy(name = "register")
    public WebElement inputRegister;
    @FindBy(css = ".woocommerce-error li")
    public WebElement textErrorMessage;


}
