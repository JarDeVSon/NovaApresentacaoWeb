package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        monochrome = true,
        publish = true,
        plugin = {"pretty", "json:target/report/cucumber.json"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@signin"

)
public class RunnerTest {
    @AfterClass
    public static void reports() throws IOException {
        if (System.getProperty("os.name").equals("Windows 10")) {
            Runtime.getRuntime().exec("cmd.exe /c mvn cluecumber-report:reporting");
        } else {
            Runtime.getRuntime().exec("sh -c mvn cluecumber-report:reporting");

        }
    }
}
