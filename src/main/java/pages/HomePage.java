package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class HomePage {
    private final SelenideElement searchTextbox = $(By.xpath("//input[@data-view-id='main_search_form_input']"));
    private final SelenideElement searchButton = $(By.xpath("//button[@data-view-id='main_search_form_button']"));
    private final SelenideElement advertisementPopUp = $(By.cssSelector("img[alt='close-icon']"));
    private final SelenideElement leftMenuLink = $(By.xpath("//div[@class='styles__StyledItemV2-sc-oho8ay-1 bHIPhv']//div[text()='%s']"));
    private final SelenideElement breadcrumb = $(By.xpath("//div[@class='breadcrumb']"));

    @Step("Close popup advertisement")
    public void closePopupAdvertisement() {
        advertisementPopUp.shouldBe(Condition.visible);
        if (advertisementPopUp.exists()) {
            advertisementPopUp.click();
        }
    }

    @Step("Check if Search textbox is displayed")
    public void isSearchTextboxDisplayed() {
        searchTextbox.shouldBe(Condition.visible);
    }

    @Step("Check if Search button is displayed")
    public void isSearchButtonDisplayed() {
        searchButton.shouldBe(Condition.visible);
    }

}
