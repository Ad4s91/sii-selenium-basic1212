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

    //  Zadanie:
    //  kliknij prompt allert
    //  w alercie wpisz imie i kliknij ok
    //  sprawdz wyświetlony msg czy zawiera odpowiednia wiadomość


    // Zadanie:
    // kliknij confirm allert
    // w alercie kliknij OK
    // sprawdz wyświetlony msg
    //
    // kliknij confirm allert
    // w alercie kliknij Cancel
    // sprawdz wyświetlony msg
}
