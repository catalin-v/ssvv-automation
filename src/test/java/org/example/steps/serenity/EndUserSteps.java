package org.example.steps.serenity;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.example.pages.EmagPage;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EndUserSteps {

    EmagPage dictionaryPage;

    @Step
    public void enters(String keyword) {
        dictionaryPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        dictionaryPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(dictionaryPage.getProduct(), containsString(definition));
    }

    @Step
    public void should_add_items(String definition) {
        assertThat(dictionaryPage.getProduct(), containsString(definition));
    }


    @Step
    public void should_have_items(String qty) {
        assertThat(dictionaryPage.getItemsQty(), containsString(qty));
    }

    @Step
    public void is_the_home_page() {
        dictionaryPage.open();
        dictionaryPage.acceptCookie();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }

    @Step
    public void add_items(int number) {
        for (int i = 0; i < number; i++) {
            dictionaryPage.addFirstProductToCart();
        }
    }
}