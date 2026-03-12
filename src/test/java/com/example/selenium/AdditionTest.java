package com.example.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdditionTest {

    @Test
    public void testAddition() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("file:///M:/hello-world/src/main/webapp/index.html");

        WebElement num1 = driver.findElement(By.id("num1"));
        WebElement num2 = driver.findElement(By.id("num2"));

        num1.sendKeys("5");
        num2.sendKeys("7");

        driver.findElement(By.tagName("button")).click();

        Thread.sleep(7000);

        String result = driver.findElement(By.id("result")).getText();

        if (result.contains("12")) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        driver.quit();
    }
}