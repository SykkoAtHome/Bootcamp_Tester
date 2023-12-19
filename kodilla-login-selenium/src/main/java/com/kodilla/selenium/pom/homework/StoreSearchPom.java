package com.kodilla.selenium.pom.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StoreSearchPom extends AbstractPom {

    @FindBy(css = "input[name='search']")
    private WebElement searchInput;


    public StoreSearchPom(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void searchKeyword(String keyword) {
        searchInput.sendKeys(keyword);
    }

    public int getResultsCount() {
        WebElement elementsWrapper = driver.findElement(By.id("elements-wrapper"));
        List<WebElement> results = elementsWrapper.findElements(By.cssSelector("div.element"));
        return results.size();
    }
}
