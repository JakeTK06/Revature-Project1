package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ViewSteps {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        TestRunner.loginPage.setupLoggedInUser();
    }

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        // TODO: Look into if you can go to home page with the login cached
//        TestRunner.homePage.tryToAccessHomePAgeDirectly();
        System.out.println("The user is on the home page");

    }

    @Then("the user should see their planets and moons")
    public void the_user_should_see_their_planets_and_moons() {
        // TODO: switch from try/finally to using a Cucumber hook to log out the user
        try{
            TestRunner.wait.until(ExpectedConditions.titleIs("Home"));
            // was having issues with test running faster than test could load all the planets
            TestRunner.wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), 5));
            Assert.assertEquals(4, TestRunner.homePage.getNumberOfCelestialRows());
            Assert.assertEquals(String.format("Expected 'Welcome to the Home Page Batman, but got %s",
                            TestRunner.homePage.getHomePageGreeting()),
                    "Welcome to the Home Page Batman",
                    TestRunner.homePage.getHomePageGreeting());
        } finally {
            TestRunner.homePage.logout();
        }

    }

    @Given("the user is not logged in")
    public void the_user_is_not_logged_in() {
        TestRunner.loginPage.openLoginPage();
    }

    @When("the user tries to directly access the home page")
    public void the_user_tries_to_directly_access_the_home_page() {

        TestRunner.homePage.tryToAccessHomePAgeDirectly();
    }

    @Then("the user should be denied access")
    public void the_user_should_be_denied_access() {
        Assert.assertNotEquals("Home", TestRunner.driver.getTitle());
    }

}
