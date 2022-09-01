package org.example.util;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CommonMethodsForList {

    public static List<String> getItemsNamesText(List<WebElement> list) {
        return list.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public static void clickOnFirstElementInListOfItems(List<WebElement> list) {
        list.stream().findAny().ifPresent(WebElement::click);
    }

    public static List<String> getFirstFewItemsFormPage(List<WebElement> list, int itemQuantity) {
        int n = itemQuantity;
        List<String> newList = new ArrayList<>();
        List<String> listOfText = getItemsNamesText(list);
        for (String s : listOfText) {
            do {
                newList.add(s);
                n++;
            } while (n < itemQuantity);
        }
        return newList;
    }

    public static int getRandomIndexInList(List<WebElement> list) {
        Random rnd = new Random();
        return rnd.nextInt(list.size());
    }

    public static boolean isListContainsString(List<String> list, String str) {
        for (String s : list) {
            return s.contains(str);
        }
        return false;
    }
}
