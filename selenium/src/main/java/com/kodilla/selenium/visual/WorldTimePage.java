package com.kodilla.selenium.visual;

import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.snapshot.Snap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Snap("WorldTime.png")
public class WorldTimePage {
    private static final String pageUrl = "https://www.worldtimeserver.com/current_time_in_AW.aspx";


    private final WebDriver webDriver;


    public WorldTimePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void open() {
        webDriver.get(pageUrl);
    }

    public void close() {
        webDriver.quit();
    }

    public void compare() {
        Ocular.snapshot()
                .from(this)
                .sample().using(webDriver)
                .compare();
    }

    public void acceptButton() {
        WebElement acceptButton = webDriver.findElement(By.xpath("//div[@format='primary']"));
        acceptButton.click();

    }
}