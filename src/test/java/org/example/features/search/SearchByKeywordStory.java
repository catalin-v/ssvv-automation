package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.example.steps.serenity.EndUserSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/EmagTestData.csv")
public class SearchByKeywordStory {

    public String name;
    public String definition;
    public String addQuantity;

    public String getExpectedQuantity() {
        return expectedQuantity;
    }

    public void setExpectedQuantity(String expectedQuantity) {
        this.expectedQuantity = expectedQuantity;
    }

    public String expectedQuantity;

    public String getAddQuantity() {
        return addQuantity;
    }

    public void setAddQuantity(String addQuantity) {
        this.addQuantity = addQuantity;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Qualifier
    public String getQualifier()
    {return name;}

    @Steps
    public EndUserSteps anna;

    @Issue("#WIKI-1")
    @Test
    public void searchBec() {
        anna.is_the_home_page();
        anna.looks_for(name);
        anna.should_see_definition(definition);
    }

    @Issue("#WIKI-1")
    @Test
    public void addToCart() {
        anna.is_the_home_page();
        anna.looks_for(name);
        JavascriptExecutor js = (JavascriptExecutor) webdriver;
        js.executeScript("window.scrollBy(0,350)", "");
        anna.add_items(Integer.parseInt(addQuantity));
        anna.should_have_items(expectedQuantity);
    }
} 