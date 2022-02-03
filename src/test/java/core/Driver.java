package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class Driver {
    /*
    O pacote core é responsável por todas as configurações do Navegador
     */
    private static WebDriver driver; //get
    private static WebDriverWait wait;
    private static String nameScenario;//get e setter
    private static File directory;//get
    private static int numPrint;

    public Driver(Browser browser) {
        switch (browser) {
            case CHROME:
                startChrome();
                break;
            case FIREFOX:
                startFirefox();
                break;
            case EDGE:
                startEdge();
        }
        wait = new WebDriverWait(driver,20);
        driver.manage().window().maximize();
    }

    private void startChrome() {
        System.setProperty("webdriver.chrome.driver", "core/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        boolean headless = Boolean.parseBoolean(System.getProperty("headless"));
        chromeOptions.setHeadless(headless);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().setSize(new Dimension(1280, 720));
    }
    private void startFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }


    public static void makeDirectory() {
        String path = "src/test/resources/evidencias/";
        directory = new File(path + "/" + nameScenario);
        directory.mkdir();
        numPrint = 0;
    }

    public static void printScreenshots(String step) throws IOException {
        numPrint++;
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = directory.getPath() + "/" + numPrint + " - " + step + ".png";
        FileUtils.copyFile(file, new File(path));
    }
    public static void visibilityOf(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    private void startEdge() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }


    public static String getNameScenario() {
        return nameScenario;
    }

    public static File getDirectory() {
        return directory;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setNameScenario(String nameScenario) {
        Driver.nameScenario = nameScenario;
    }
}
