package cucumber.test;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/KalendarzOplataMocowa",
        plugin = {"pretty", "json:target/Destination/cucumber.json"})
public class KlasaTestowa {

}