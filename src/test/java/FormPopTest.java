import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;

import java.io.File;

public class FormPopTest extends TestBase {
    private FormPage formPage;
    private File file;

    public void testSetup() {
        formPage = new FormPage(getDriver());
        file = new File("src\\main\\resources\\file.txt");
        getDriver().get("https://seleniumui.moderntester.pl/form.php");
    }

    @Test
    public void shouldFillFormWIthSuccess() {
        formPage.setFirstName("Jan");
        formPage.setLastName("Kowalski");
        formPage.setEmail("j.k@wp.pl");
        formPage.setAge(40);
        formPage.selectMale();
        formPage.selectRandomProfession();
        formPage.selectRandomExperience();
        formPage.uploadFile(file.getAbsolutePath());
        formPage.selectContinent("south-america");
        formPage.selectSeleniumCommand("switch-commands");
        formPage.sendForm();

        Assert.assertEquals(formPage.getValidatorMessage(), "Form send with success");
    }
}
