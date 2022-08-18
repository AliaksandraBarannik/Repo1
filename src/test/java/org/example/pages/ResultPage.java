package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ResultPage extends InitDriver {

    @FindBy(xpath = "//div[@data-component-type='s-search-result']//a[@class='a-link-normal s-no-outline']")
    private List<WebElement> listOfItems;

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getItemsNamesText() {
        return listOfItems.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void clickOnFirstElementInListOfItems() {
        listOfItems.stream().findAny().ifPresent(WebElement::click);
    }
}
