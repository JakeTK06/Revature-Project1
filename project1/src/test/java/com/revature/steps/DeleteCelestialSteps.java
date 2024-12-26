package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeleteCelestialSteps {

    @When("the user inputs valid planet deletion data")
    public void the_user_inputs_valid_planet_deletion_data() {
        TestRunner.homePage.switchToPlanet();
        TestRunner.wait.until(ExpectedConditions.attributeToBe(By.id("locationSelect"),"value", "planet"));
        TestRunner.homePage.setCelestialToDelete("Earth");
    }

    @When("the user submits planet deletion data")
    public void the_user_submits_planet_deletion_data() {
        TestRunner.homePage.submitDeletion();

    }

    @Then("the planet should be deleted")
    public void the_planet_should_be_deleted() {
        // Look for the name of the planet deleted

        // wait for table to appear
        TestRunner.wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), 3));
        // check for name of planet
        Assert.assertFalse(TestRunner.homePage.planetExists("Earth"));

    }

    @Then("all of the planets moons should be deleted")
    public void all_of_the_planets_moons_should_be_deleted() {
        // no moons should be owned by the planet that was deleted

        // check to make sure moon no longer exists
        Assert.assertFalse(TestRunner.homePage.moonExists("Luna"));
        // Check to make sure no moon is owned by the planet deleted
        Assert.assertFalse(TestRunner.homePage.moonOwnedByNumExists("1"));
    }

    @Then("the table should refresh with less celestials")
    public void the_table_should_refresh_with_less_celestials() {
        // Make sure there are the correct number of celestials

        Assert.assertEquals(2, TestRunner.homePage.getNumberOfCelestialRows());
        Assert.assertEquals(1, TestRunner.homePage.getNumberOfPlanets());
        Assert.assertEquals(1, TestRunner.homePage.getNumberOfMoons());
    }

    @When("the user inputs planet deletion data")
    public void the_user_inputs_planet_deletion_data() {
        // set planet name to venus
        TestRunner.homePage.switchToPlanet();
        TestRunner.homePage.setCelestialToDelete("Venus");
    }

    @When("the user inputs valid moon deletion data")
    public void the_user_inputs_valid_moon_deletion_data() {
        TestRunner.homePage.switchToMoon();
        TestRunner.homePage.setCelestialToDelete("Titan");
    }

    @When("the user submits moon deletion data")
    public void the_user_submits_moon_deletion_data() {
        TestRunner.homePage.submitDeletion();
    }

    @Then("the moon should be deleted")
    public void the_moon_should_be_deleted() {
        TestRunner.wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), 4));
        Assert.assertFalse(TestRunner.homePage.moonExists("Titan"));
    }

    @When("the user inputs moon deletion data")
    public void the_user_inputs_moon_deletion_data() {
        // For invalid data
        TestRunner.homePage.setCelestialToDelete("Moon");
    }

    @Then("the table should refresh with less moons")
    public void the_table_should_refresh_with_less_moons() {
        Assert.assertEquals(3, TestRunner.homePage.getNumberOfCelestialRows());
        Assert.assertEquals(1, TestRunner.homePage.getNumberOfMoons());
    }
}
