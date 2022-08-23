package org.example.pages;

import org.example.util.CommonMethodsForList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultPage extends BasePage {

    public List<WebElement> getListOfItems() {
        return driver.findElements(By.xpath("//a[@class='a-link-normal s-no-outline']"));
    }

    public List<String> getListOfItemsNamesText() {
        return CommonMethodsForList.getItemsNamesText(getListOfItems());
    }

    public void clickOnFirstElementInListOfItems() {
        CommonMethodsForList.clickOnFirstElementInListOfItems(getListOfItems());
    }
}
