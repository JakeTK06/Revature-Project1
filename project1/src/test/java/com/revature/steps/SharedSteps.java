package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SharedSteps {

    // User Registration
    // User Login
    // Delete
    // Add
    @Then("the user should get a browser alert saying {string}")
    public void the_user_should_get_a_browser_alert_saying(String alert) {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert a = TestRunner.driver.switchTo().alert();
        try {
            Assert.assertEquals(alert, a.getText());
        } finally {
            a.accept();
        }


    }
}
