import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class InceptionTest extends TestBase {

    @Test
    public void shouldSelectRadioBtn() {
        /*
        Zadanie:
        - znajdz elementy ktorych klasa jest rowna form-check
        - sprawdz czy wewnąrz elementu label jest cyfra 1
        - jeżeli tak to kliknij w element input

         */
        getDriver().get("https://seleniumui.moderntester.pl/form.php");
        List<WebElement> allDivs = getDriver().findElements(By.className("form-check"));

        for (WebElement div : allDivs) {
            String elementText = div.findElement(By.cssSelector("label")).getText();

            if (elementText.equals("1")) {
                div.findElement(By.cssSelector("input")).click();
            }
        }
    }
}
