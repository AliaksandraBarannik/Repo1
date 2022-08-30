package org.example.util;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class CommonMethodsForList {

    public static List<String> getItemsNamesText(List<WebElement> list) {
        return list.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public static void clickOnFirstElementInListOfItems(List<WebElement> list) {
        list.stream().findAny().ifPresent(WebElement::click);
    }
}
