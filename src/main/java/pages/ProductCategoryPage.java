package pages;

import com.codeborne.selenide.SelenideElement;
import enums.DoDungNhaBep;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductCategoryPage {
    private final SelenideElement categoryItemLink = $(By.xpath("//div[@class='styles__TreeSubItem-sc-1uq9a9i-6 divFYE']//a[text()='%s']"));
    private final SelenideElement allFiltersButton = $(By.xpath("//button[@class='styles__StyledButton-sc-kqbl3f-0 bQYwcw']"));

    @Step("Click on All filters button")
    public void clickOnAllFiltersButton() {
        allFiltersButton.click();
    }

    @Step("Select category item name \"{item.value}\"")
    public void selectCategoryItem(DoDungNhaBep item) {
        categoryItemLink.setValue(item.getValue());
        categoryItemLink.click();
    }
}
