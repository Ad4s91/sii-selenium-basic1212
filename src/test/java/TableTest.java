import org.testng.annotations.Test;

public class TableTest extends TestBase {

    @Test
    public void shouldPrintAllMountains(){
        getDriver().get("https://seleniumui.moderntester.pl/table.php");
    }
}
