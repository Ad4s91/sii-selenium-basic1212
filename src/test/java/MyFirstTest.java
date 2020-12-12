import org.testng.Assert;
import org.testng.annotations.*;

public class MyFirstTest {

    @Test
    public void thisTestShouldPass() {
        System.out.println("This is my first test");
        Assert.assertEquals(5, 5);
    }

    @Test
    public void thisTestShouldPassToo() {
        System.out.println("This is my second test");
    }

    @Test
    public void thisTestShouldFail() {
        System.out.println("This is my third test");
        Assert.assertEquals(5, 10);
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Uruchomilem sie przed kazdym testem!");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Uruchomilem sie po kazdym tescie!");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Uruchomilem sie RAZ przed ");
    }

    @AfterClass
    public void afterClass() throws Exception {
        System.out.println("Uruchomilem sie RAZ po");
    }
}