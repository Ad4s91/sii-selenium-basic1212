import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTest extends TestBase {
    private WebElement draggable;
    private WebElement droppable;
    private Actions actions;

    @BeforeMethod
    public void testSetup() {
        getDriver().get("https://seleniumui.moderntester.pl/droppable.php");
        draggable = getDriver().findElement(By.id("draggable"));
        droppable = getDriver().findElement(By.id("droppable"));
        actions = new Actions(getDriver());
    }


    @Test
    public void shouldDragAndDropElement() {
        actions.dragAndDrop(draggable, droppable)
                .perform();

        Assert.assertEquals(droppable.getText(), "Dropped!");
    }

    @Test
    public void shouldClickMoveAndRelease() {
        actions.clickAndHold(draggable)
                .moveToElement(droppable)
                .release()
                .perform();

        Assert.assertEquals(droppable.getText(), "Dropped!");
    }


    @Test
    public void shouldClickAndRelease() {
        actions.clickAndHold(draggable)
                .release(droppable)
                .perform();

        Assert.assertEquals(droppable.getText(), "Dropped!");
    }
}
