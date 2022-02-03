package pages;

import core.Driver;
import maps.RegisterMaps;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    RegisterMaps registerMaps;

    public RegisterPage() {
        registerMaps = new RegisterMaps();
        PageFactory.initElements(Driver.getDriver(),registerMaps);
    }
    public void clickLinkMyAccount(){
        registerMaps.linkMyAccount.click();
    }
    public void setInputEmail(String email) {
        if (email != null) {
            registerMaps.inputEmailAdress.sendKeys(email);
        }

    }
    public void setInputPassword(String password) {
        if (password != null) {
            registerMaps.inputPassword.sendKeys(password);
        }
    }
    public void setInputRegisterButton() {
        registerMaps.inputRegister.click();
    }
    public String GetMessage(String message) {

       return registerMaps.textErrorMessage.getText();
    }
}
