import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;

import java.io.File;

public class FormPopTest extends TestBase {
    @Test
    public void shouldFillFormWIthSuccess() {
        FormPage formPage = new FormPage(getDriver());
        File file = new File("src\\main\\resources\\file.txt");
        getDriver().get("https://seleniumui.moderntester.pl/form.php");

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
