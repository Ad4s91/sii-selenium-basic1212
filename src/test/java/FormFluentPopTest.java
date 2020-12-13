import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FormFluentPage;

import java.io.File;

public class FormFluentPopTest extends TestBase {
    private FormFluentPage formPage;
    private File file;

    @BeforeMethod
    public void testSetup() {
        formPage = new FormFluentPage(getDriver());
        file = new File("src\\main\\resources\\file.txt");
        getDriver().get("https://seleniumui.moderntester.pl/form.php");
    }

    @Test
    public void shouldFillFormWIthSuccess() {
        formPage.setFirstName("Jan")
                .setLastName("Kowalski")
                .setEmail("j.k@wp.pl")
                .setAge(40)
                .selectMale()
                .selectRandomProfession()
                .selectRandomExperience()
                .uploadFile(file.getAbsolutePath())
                .selectContinent("south-america")
                .selectSeleniumCommand("switch-commands")
                .sendForm();

        Assert.assertEquals(formPage.getValidatorMessage(), "Form send with success");
    }

    @Test
    public void shouldFillFormWIthSuccessAlternative() {
        Assert.assertEquals(
                formPage.setFirstName("Jan")
                        .setLastName("Kowalski")
                        .setEmail("j.k@wp.pl")
                        .setAge(40)
                        .selectMale()
                        .selectRandomProfession()
                        .selectRandomExperience()
                        .uploadFile(file.getAbsolutePath())
                        .selectContinent("south-america")
                        .selectSeleniumCommand("switch-commands")
                        .sendForm()
                        .getValidatorMessage(), "Form send with success");
    }
}
