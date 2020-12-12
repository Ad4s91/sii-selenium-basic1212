import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTest extends TestBase {

    @BeforeMethod
    public void testSetup() {
        getDriver().get("https://seleniumui.moderntester.pl/alerts.php");
    }

    @Test
    public void shouldVerifySimpleAlert() {
        getDriver().findElement(By.id("simple-alert")).click();

        getDriver().switchTo().alert().accept();

        WebElement msg = getDriver().findElement(By.id("simple-alert-label"));
        Assert.assertEquals(msg.getText(), "OK button pressed");
    }

    @Test
    public void shouldVerifyPromptAlert() {
        getDriver().findElement(By.id("prompt-alert")).click();

        getDriver().switchTo().alert().sendKeys("Lord Vader");
        getDriver().switchTo().alert().accept();

        Assert.assertEquals(getDriver().findElement(By.id("prompt-label")).getText(),
                "Hello Lord Vader! How are you today?");
    }

    @Test
    public void shouldVerifyConfirmAlert() {
        WebElement msg = getDriver().findElement(By.id("confirm-label"));
        WebElement confirmAlertButton = getDriver().findElement(By.id("confirm-alert"));

        confirmAlertButton.click();
        getDriver().switchTo().alert().accept();

        Assert.assertEquals(msg.getText(), "You pressed OK!");

        confirmAlertButton.click();
        getDriver().switchTo().alert().dismiss();

        Assert.assertEquals(msg.getText(), "You pressed Cancel!");
    }


}
