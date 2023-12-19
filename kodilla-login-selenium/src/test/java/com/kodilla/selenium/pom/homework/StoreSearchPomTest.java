package com.kodilla.selenium.pom.homework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

class StoreSearchPomTest {
    StoreSearchPom storeSearchPom;
    WebDriver driver;

    @BeforeEach
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.setBrowserVersion("120");
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://kodilla.com/pl/test/store");
        storeSearchPom = new StoreSearchPom(driver);
    }

    @ParameterizedTest
    @CsvSource({
            "NoteBook,2",
            "School,1",
            "Brand, 1",
            "Business, 0",
            "Gaming, 1",
            "Powerful, 0"
    })
    public void testResultsForSearch(String keyword, int expectedCount) {
        storeSearchPom.searchKeyword(keyword);
        int resultsCount = storeSearchPom.getResultsCount();
        assertEquals(expectedCount, resultsCount);
    }

    @ParameterizedTest
    @CsvSource({
            "NoteBook,2",
            "School,1",
            "Brand, 1",
            "Business, 0",
            "Gaming, 1",
            "Powerful, 0"
    })
    public void testResultsForSearchUpperCase(String keyword, int expectedCount) {
        keyword = keyword.toUpperCase();
        storeSearchPom.searchKeyword(keyword);
        int resultsCount = storeSearchPom.getResultsCount();
        assertEquals(expectedCount, resultsCount);
    }


    @AfterEach
    public void testDown() {
//        driver.close(); // WFT? -> org.openqa.selenium.remote.http.WebSocket$Listener onError
        driver.quit();
    }
}