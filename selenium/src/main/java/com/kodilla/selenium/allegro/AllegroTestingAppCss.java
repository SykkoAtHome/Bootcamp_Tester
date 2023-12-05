package com.kodilla.selenium.allegro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class AllegroTestingAppCss {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/selenium-drivers/chrome32/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.allegro.pl");

        WebElement acceptButton = driver.findElement(By.cssSelector("button[data-testid='accept_home_view_action']"));
        acceptButton.click();

        WebElement categoryCombo = driver.findElement(By.cssSelector("select[aria-label^='Kategoria']"));
        Select categorySelect = new Select(categoryCombo);
        categorySelect.selectByIndex(3);

        WebElement searchField = driver.findElement(By.cssSelector("input[aria-autocomplete='both']"));
        searchField.sendKeys("Mavic mini");
        searchField.submit();
    }
}