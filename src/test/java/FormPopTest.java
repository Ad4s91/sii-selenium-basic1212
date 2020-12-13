import org.testng.annotations.Test;
import pages.FormPage;

public class FormPopTest extends TestBase {
    @Test
    public void shouldFillFormWIthSuccess() {
        FormPage formPage = new FormPage(getDriver());
        getDriver().get("https://seleniumui.moderntester.pl/form.php");

        formPage.setFirstName("Jan");
        formPage.setLastName("Kowalski");
        formPage.selectRandomExperience();
        formPage.selectContinent("south-america");
    }
}
