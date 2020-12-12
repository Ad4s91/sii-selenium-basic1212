import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TableTest extends TestBase {

    @Test
    public void shouldPrintAllMountainsHigherThan4000() {
        getDriver().get("https://seleniumui.moderntester.pl/table.php");

        List<WebElement> allMountains = getDriver().findElements(By.cssSelector("tbody tr"));

        for (WebElement mountain : allMountains) {
            List<WebElement> columns = mountain.findElements(By.cssSelector("td"));

            // string: "4807" -> int: 4807
            if (Integer.parseInt(columns.get(3).getText()) > 4000) {
                System.out.println(mountain.getText());
            }
        }
    }
}
