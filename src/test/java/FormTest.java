import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormTest extends TestBase {

    @Test
    public void shouldFillFormWIthSuccess() {
        getDriver().get("https://seleniumui.moderntester.pl/form.php");

        WebElement firstName = getDriver().findElement(By.id("inputFirstName3"));
        firstName.sendKeys("Jan");

        getDriver().findElement(By.id("inputLastName3")).sendKeys("Kowalski");

        getDriver().findElement(By.id("inputEmail3")).sendKeys("j.k@wp.pl");

        getDriver().findElement(By.id("inputAge3")).sendKeys("13");







        getDriver().findElement(By.className("btn-primary")).click();

        WebElement msg = getDriver().findElement(By.id("validator-message"));
        Assert.assertEquals(msg.getText(), "Form send with success");
    }
}
