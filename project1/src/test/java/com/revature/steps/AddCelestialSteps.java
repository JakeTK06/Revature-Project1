package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class AddCelestialSteps {
    @When("the user inputs valid planet creation data")
    public void the_user_inputs_valid_planet_creation_data() {
        // Set valid data
        // Venus -55_
        // No image
        TestRunner.homePage.switchToPlanet();
        TestRunner.homePage.setPlanetNameInput("Venus -55_");
    }

    @When("the user submits planet creation data")
    public void the_user_submits_planet_creation_data() {
        // Click create button
        TestRunner.homePage.submitCreationData();
    }

    @Then("the planet should be created")
    public void the_planet_should_be_created() {
        // wait for number of celestials to increase
        // check that planet of name is in table
        TestRunner.wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), 6));
        Assert.assertTrue(TestRunner.homePage.planetExists("Venus -55_"));
    }

    @Then("the table should refresh with an extra planet")
    public void the_table_should_refresh_with_an_extra_planet() {
        // Make sure correct amount of celestials is being shown
        // check correct number of celestials
        Assert.assertEquals(5, TestRunner.homePage.getNumberOfCelestialRows());
        // Check correct number of planets
        Assert.assertEquals(3, TestRunner.homePage.getNumberOfPlanets());
    }

    @When("the user inputs planet {string}")
    public void the_user_inputs_planet(String name) {
        // Switch to planet option
        TestRunner.homePage.switchToPlanet();
        // Set planet name to name
        TestRunner.homePage.setPlanetNameInput(name);
    }

    @When("the user adds an image of file type {string}")
    public void the_user_adds_an_image_of_file_type(String fileType) {
        // if empty don't set anything, if GIF set to the GIF
        if (fileType.equals("GIF")){
            // set to GIF
            TestRunner.wait.until( d-> {
                TestRunner.homePage.setPlanetImageInput("C:\\Users\\jacob\\Desktop\\Revature-Project1\\project1\\src\\test\\resources\\Celestial-Images\\planetGIF.gif");
                return true;
            });

        }
    }

    @When("the user inputs valid moon creation data")
    public void the_user_inputs_valid_moon_creation_data() {
        // Set moon creation data
        // quasi-moon 1 Zoozve_
        // 1
        // No image input
        TestRunner.homePage.switchToMoon();
        TestRunner.homePage.setMoonNameInput("quasi-moon 1 Zoozve_");
        TestRunner.homePage.setOrbitedPlanetInput("1");
    }

    @When("the user submits moon creation data")
    public void the_user_submits_moon_creation_data() {
        // click submit
        TestRunner.homePage.submitCreationData();
    }

    @Then("the moon should be created")
    public void the_moon_should_be_created() {
        // wait for table to update
        // check for moon of correct name
        TestRunner.wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"),6));
        Assert.assertTrue(TestRunner.homePage.moonExists("quasi-moon 1 Zoozve_"));
    }

    @Then("the table should be refresh with an extra moon")
    public void the_table_should_be_refresh_with_an_extra_moon() {
        // Check to make sure the correct amount of celestials are there

        // check correct number of celestials
        Assert.assertEquals(5, TestRunner.homePage.getNumberOfCelestialRows());
        // Check correct number of planets
        Assert.assertEquals(3, TestRunner.homePage.getNumberOfMoons());
    }

    @When("the user inputs moon name {string}")
    public void the_user_inputs_moon_name(String name) {
        // enter moon name
        TestRunner.homePage.setMoonNameInput(name);
    }

    @When("the user inputs planet that own the moon {string}")
    public void the_user_inputs_planet_that_own_the_moon(String ownerNum) {
        // enter owner
        TestRunner.homePage.setOrbitedPlanetInput(ownerNum);
    }

    @When("the user adds and image of file type {string}")
    public void the_user_adds_and_image_of_file_type(String fileType) {
        // if none dont add anything
        // if GIF add the gif
        if(fileType.equals("GIF")){
            TestRunner.wait.until( d-> {
                TestRunner.homePage.setMoonImageInput("C:\\Users\\jacob\\Desktop\\Revature-Project1\\project1\\src\\test\\resources\\Celestial-Images\\planetGIF.gif");
                return true;
            });

        }


    }


}
