package com.revature.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    @FindBy(id = "greeting")
    private WebElement greetingHeader;

    @FindBy(id = "logoutButton")
    private WebElement logoutButton;

    @FindBy(tagName = "tr")
    private List<WebElement> tableRows;

    @FindBy(id = "locationSelect")
    private WebElement selectOption;

    @FindBy(id = "planetNameInput")
    private WebElement planetNameInput;

    @FindBy(id = "planetImageInput")
    private WebElement planetImageInput;

    @FindBy(id = "moonNameInput")
    private WebElement moonNameInput;

    @FindBy(id = "orbitedPlanetInput")
    private WebElement orbitedPlanetInput;

    @FindBy(id = "moonImageInput")
    private WebElement moonImageInput;

    @FindBy(className = "submit-button")
    private WebElement submitButton;

    @FindBy(id = "deleteInput")
    private WebElement deleteInput;

    @FindBy(id = "deleteButton")
    private WebElement deleteButton;

    @FindBy(xpath = "//tr/td[text()='planet']")
    private List<WebElement> planets;

    @FindBy(xpath = "//tr/td[text()='moon']")
    private List<WebElement> moons;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHomePageGreeting(){
        return greetingHeader.getText();
    }

    public int getNumberOfCelestialRows(){
        return tableRows.size() - 1;
    }

    public void tryToAccessHomePAgeDirectly(){
        driver.get("http://localhost:8080/planetarium");
    }

    public void logout(){
        logoutButton.click();
    }

    public void setCelestialToDelete(String name){
        deleteInput.sendKeys(name);
    }

    public void submitDeletion() {
        deleteButton.click();
    }

    public void switchToPlanet(){
        selectOption.sendKeys("Planet");
    }

    public void switchToMoon(){
        selectOption.sendKeys("Moon");
    }

    public int getNumberOfPlanets(){
        System.out.println("PLANETS: " + planets.size());
        return planets.size();
    }

    public int getNumberOfMoons(){
        return moons.size();
    }

    public boolean planetExists(String name){
        for(int i = 1; i < tableRows.size(); i++){
            WebElement row = tableRows.get(i);
            List<WebElement> cols = row.findElements(By.tagName("td"));
            // Check if celestial is planet and planet name matches
            if (cols.get(0).getText().equals("planet") && cols.get(2).getText().equals(name)){
                return true;
            }
        }

        return false;
    }

    public boolean moonExists(String name){
        for(int i = 1; i < tableRows.size(); i++){
            WebElement row = tableRows.get(i);
            List<WebElement> cols = row.findElements(By.tagName("td"));
            // Check if celestial is planet and planet name matches
            if (cols.get(0).getText().equals("moon") && cols.get(2).getText().equals(name)){
                return true;
            }
        }

        return false;
    }

    /*
        check to see if a moon exits with owner num
     */
    public boolean moonOwnedByNumExists(String num){
        for(int i = 1; i < tableRows.size(); i++){
            WebElement row = tableRows.get(i);
            List<WebElement> cols = row.findElements(By.tagName("td"));
            // Check if celestial is planet and planet name matches
            if (cols.get(0).getText().equals("moon") && cols.get(3).getText().equals(num)){
                return true;
            }
        }

        return false;
    }

    public void setPlanetNameInput(String name){
        planetNameInput.sendKeys(name);
    }

    public void submitCreationData(){
        submitButton.click();
    }

    public void setPlanetImageInput(String filePath){
        planetImageInput.sendKeys(filePath);
    }

    public void setMoonNameInput(String name){
        moonNameInput.sendKeys(name);
    }

    public void setOrbitedPlanetInput(String num){
        orbitedPlanetInput.sendKeys(num);
    }

    public void setMoonImageInput(String filePath){
        moonImageInput.sendKeys(filePath);
    }

}
