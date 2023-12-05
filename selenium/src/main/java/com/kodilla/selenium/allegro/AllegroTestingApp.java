package com.kodilla.selenium.allegro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AllegroTestingApp {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/selenium-drivers/chrome32/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.allegro.pl");

        WebElement acceptButton = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div/div[2]/button[1]"));
        acceptButton.click();

        WebElement categoryCombo = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[3]/header/div[1]/div/div/div/form/div[3]/div/select"));
        Select categorySelect = new Select(categoryCombo);
        categorySelect.selectByIndex(3);

        WebElement searchField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[3]/header/div[1]/div/div/div/form/input"));
        searchField.sendKeys("Mavic mini");
        searchField.submit();



    }
}
