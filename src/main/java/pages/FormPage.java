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

    @FindBy(id = "inputEmail3")
    private WebElement emailInput;

    @FindBy(id = "inputAge3")
    private WebElement ageInput;

    @FindBy(id = "gridRadiosMale")
    private WebElement maleRadioButton;

    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> yearsOfExperience;

    @FindBy(name = "gridCheckboxProfession")
    private List<WebElement> professions;

    @FindBy(id = "selectContinents")
    private WebElement continents;

    @FindBy(id = "selectSeleniumCommands")
    private WebElement seleniumCommands;

    @FindBy(id = "chooseFile")
    private WebElement chooseFile;

    @FindBy(className = "btn-primary")
    private WebElement sendFormButton;

    @FindBy(id = "validator-message")
    private WebElement validatorMessage;

    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void setAge(int age) {
        // int: 15 -> string: "15"
        ageInput.sendKeys(String.valueOf(age));
    }

    public void selectMale() {
        maleRadioButton.click();
    }

    public void selectSeleniumCommand(String seleniumCommandValue) {
        Select seleniumCommandSelect = new Select(seleniumCommands);
        seleniumCommandSelect.selectByValue(seleniumCommandValue);
    }

    public void uploadFile(String absolutePath) {
        chooseFile.sendKeys(absolutePath);
    }

    public void sendForm() {
        sendFormButton.click();
    }

    public String getValidatorMessage() {
        return validatorMessage.getText();
    }

    public void setFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void selectRandomExperience() {
        getRandomElement(yearsOfExperience).click();
    }

    public void selectRandomProfession() {
        getRandomElement(professions).click();
    }

    private WebElement getRandomElement(List<WebElement> elements){
        return elements.get(new Random().nextInt(elements.size()));
    }

    public void selectContinent(String continentValue) {
        Select continentSelect = new Select(continents);
        continentSelect.selectByValue(continentValue);
    }
}
