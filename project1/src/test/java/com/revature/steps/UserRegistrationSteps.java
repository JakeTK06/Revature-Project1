package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserRegistrationSteps {

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        TestRunner.loginPage.openLoginPage();
    }

    @Given("The user clicks the register link")
    public void the_user_clicks_the_register_link() {
        TestRunner.loginPage.clickRegistrationLink();
        System.out.println("Registration link clicked");
    }

    @When("The user provides a valid username")
    public void the_user_provides_a_valid_username() {
        TestRunner.registrationPage.setUsername("Super_man-2001");
    }

    @When("The user provides a valid password")
    public void the_user_provides_a_valid_password() {
        TestRunner.registrationPage.setPassword("Krypton-was_2000");
    }

    @When("The user submits credentials")
    public void the_user_submits_credentials() {
        TestRunner.registrationPage.submitCredentials();
    }

    @Then("The user should get a browser alert saying {string}")
    public void the_user_should_get_a_browser_alert_saying(String alertMessage) {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("Alert Message is incorrect", alertMessage, TestRunner.registrationPage.getAlertText());
    }

    @Then("The user should be redirected to the login page")
    public void the_user_should_be_redirected_to_the_login_page() {
        TestRunner.wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Account Creation")));
        Assert.assertEquals("Planetarium Login", TestRunner.driver.getTitle());
    }

    @When("The user provides username {string}")
    public void the_user_provides_username(String username) {
        TestRunner.registrationPage.setUsername(username);
    }

    @When("The user provides password {string}")
    public void the_user_provides_password(String password) {
        TestRunner.registrationPage.setPassword(password);
    }

    @Then("The user should stay on the registration page")
    public void the_user_should_stay_on_the_registration_page() {
        Assert.assertEquals("Account Creation", TestRunner.driver.getTitle());
    }
}
