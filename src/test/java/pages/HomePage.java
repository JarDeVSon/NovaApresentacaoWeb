package pages;

import core.Driver;
import maps.HomeMaps;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    HomeMaps homeMaps;

    public HomePage(){
        homeMaps = new HomeMaps();
        PageFactory.initElements(Driver.getDriver(),homeMaps);
    }
    public String getTitleUser() {
        Driver.visibilityOf(homeMaps.body);
        return homeMaps.body.getText();
    }
}
