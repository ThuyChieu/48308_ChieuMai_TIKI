package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import enums.LeftMenu;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    private final SelenideElement tikiHeader = $(By.xpath("//img[@alt = 'tiki-logo']"));
    private final SelenideElement advertisementPopUp = $(By.cssSelector("img[alt='close-icon']"));
    private final String leftMenuLink = "//div[@class='styles__StyledItemV2-sc-oho8ay-1 bHIPhv']//div[text()='%s']";
    private final SelenideElement breadcrumb = $(By.xpath("//div[@class='breadcrumb']"));

    @Step("Close popup advertisement")
    public void closePopupAdvertisement() {
        advertisementPopUp.shouldBe(Condition.visible);
        if (advertisementPopUp.exists()) {
            advertisementPopUp.click();
        }
    }

    @Step("Get current breadcrumb text")
    public String getBreadcrumbText() {
        String breadcrumbText = breadcrumb.getText();
        return breadcrumbText.replaceAll("\n", " > ");
    }

    @Step("Select left menu: \"{menu.value}\"")
    public void selectLeftMenu(LeftMenu menu) {
        $x(String.format(leftMenuLink, menu.getValue())).click();
    }

    @Step("Go to homepage")
    public void goToHomePage() {
        tikiHeader.click();
    }
}
