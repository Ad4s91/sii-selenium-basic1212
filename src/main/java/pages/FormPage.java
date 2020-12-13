package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class FormPage {
    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "inputFirstName3")
    private WebElement firstNameInput;

    @FindBy(id = "inputLastName3")
    private WebElement lastName;

    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> yearsOfExperience;

    @FindBy(id = "selectContinents")
    private WebElement continents;

    public void setFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void selectRandomExperience() {
        Random rnd = new Random();
        int randomIndex = rnd.nextInt(yearsOfExperience.size());
        WebElement randYearElement = yearsOfExperience.get(randomIndex);
        randYearElement.click();
    }

    public void selectContinent(String continentValue) {
        Select continentSelect = new Select(continents);
        continentSelect.selectByValue(continentValue);
    }
}
