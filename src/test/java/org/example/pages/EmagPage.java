package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import net.serenitybdd.core.pages.WebElementFacade;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

//@RunWith(SerenityParameterizedRunner.class)
//@UseTestDataFrom("src/test/resources/EmagTestData.csv")
@DefaultUrl("https://www.emag.ro/")
public class EmagPage extends PageObject {

    @FindBy(name="query")
    private WebElementFacade searchTerms;

    @FindBy(className = "searchbox-submit-button")
    private WebElementFacade lookupButton;


//    public String name;
//    public String definition;

    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
//        withTimeoutOf(Duration.ofSeconds(30))
//                .find(By.className("searchbox-submit-button"))
//                .click();
        lookupButton.click();
    }

    public String getProduct() {
        WebElementFacade product = findFirst(By.cssSelector(".card-v2-title-wrapper")).orElse(null);

        return product != null ? product.getText() : null;
    }

    public String getItemsQty() {
        WebElementFacade cartIcon = findFirst(By.cssSelector("#my_cart > .jewel")).orElse(null);

        return cartIcon != null ? cartIcon.getText() : null;
    }

    public void acceptCookie() {
        WebElementFacade acceptCookieButton = findFirst(By.cssSelector(".cookie-banner-buttons > .btn-primary")).orElse(null);
        acceptCookieButton.click();
    }

    public void addFirstProductToCart() {
        WebElementFacade addToCartButton = findFirst(By.cssSelector(".yeahIWantThisProduct")).orElse(null);
        addToCartButton.click();

        try {
            Thread.sleep(5000);
        } catch (Exception exc) {
            return;
        }

        WebElementFacade closePromoButton = findFirst(By.cssSelector("button.close")).orElse(null);
        closePromoButton.click();
    }


}