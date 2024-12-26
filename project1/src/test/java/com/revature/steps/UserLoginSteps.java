package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.lu.a;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserLoginSteps {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        TestRunner.loginPage.openLoginPage();
    }

    @When("the user provides a valid username")
    public void the_user_provides_a_valid_username() {
        TestRunner.loginPage.setUsernameInput("Batman");
    }

    @When("the user provides a valid password")
    public void the_user_provides_a_valid_password() {
        TestRunner.loginPage.setPasswordInput("Iamthenight1939");
    }

    @When("the user submits credentials")
    public void the_user_submits_credentials() {
        TestRunner.loginPage.submitCredentials();
    }

    @Then("login is successful")
    public void login_is_successful() {
        // no alert pops up
        boolean alertPops = true;

        try {
            TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        }catch (TimeoutException e){
            System.out.println("No alert pops");
            alertPops = false;
        } finally{
            Assert.assertFalse(alertPops);
        }
    }

    @Then("the user is redirected to the home page")
    public void the_user_is_redirected_to_the_home_page() {
        TestRunner.wait.until(ExpectedConditions.titleIs("Home"));
        Assert.assertEquals("Home", TestRunner.driver.getTitle());
    }

    @When("the user provides username {string}")
    public void the_user_provides_username(String username) {
        TestRunner.loginPage.setUsernameInput(username);
    }

    @When("the user provides password {string}")
    public void the_user_provides_password(String password) {
        TestRunner.loginPage.setPasswordInput(password);
    }

    @Then("the user should stay on the login page")
    public void the_user_should_stay_on_the_login_page() {
        Assert.assertNotEquals("Home", TestRunner.driver.getTitle());
        Assert.assertEquals("Planetarium Login", TestRunner.driver.getTitle());
    }
}
