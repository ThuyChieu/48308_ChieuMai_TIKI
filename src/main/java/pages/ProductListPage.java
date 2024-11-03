package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import models.Product;
import helpers.NumberHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductListPage {
    private final List<SelenideElement> listProduct = $$(By.xpath("//a[@data-view-id = 'product_list_item']"));
    private final List<SelenideElement> productNameList = $$(By.xpath("//h3[contains(@class, 'NameStyled')]"));
    private final List<SelenideElement> productPriceList = $$(By.xpath("//div[@class = 'price-discount__price']"));
    private final SelenideElement sortButton = $(By.xpath("//button[@class = 'styles__StyledButton-sc-kqbl3f-0 "
            + "bQYwcw']"));
    private final SelenideElement nhaSachFahasahighlighted = $(By.xpath("//div[contains(text(),'Nhà cung "
            + "cấp')]//following-sibling::div//button[contains(@class,'ksuoUg')]"));
    private final SelenideElement viewItem = $(By.xpath("//h2[@class='BlockTitle__Wrapper-sc-qpz3fo-0 eHltcn']/h3"));

    @Step("Count the number of products")
    public int getProductCount() {
        return listProduct.size();
    }

    @Step("Get a random number")
    public int getRandomProductIndex(int amountProduct) {
        return NumberHelper.getRandomNumber(amountProduct);
    }


    @Step("All product prices are higher than min price and lower than max price")
    public void allProductPriceInSuitableRange(String minPrice, String maxPrice) {
        int reformatMinPrice = NumberHelper.parseCurrencyToInt(minPrice);
        int reformatMaxPrice = NumberHelper.parseCurrencyToInt(maxPrice);
        for (int index = 0; index < getProductCount(); index++) {
            String price = productPriceList.get(index).getText();
            int reformatPrice = NumberHelper.parseCurrencyToInt(price);
            if (reformatPrice < reformatMinPrice || reformatPrice > reformatMaxPrice) {
                System.out.println("Khoảng giá không hợp lệ");
            }
        }
    }

    @Step("Click on item has index: {index}")
    public void clickOnProductItem(int index) {
        listProduct.get(index).click();
    }

    @Step("Click on sort button")
    public void clickOnSortItem() {
        sortButton.click();
    }

    @Step("Check if Nha Sach Fahasa is highlighted")
    public void nhaSachFahasaHighlighted() {
        nhaSachFahasahighlighted.should(Condition.visible);
    }

    @Step("Check if view item is displayed")
    public void isViewItemDisplayed() {
        viewItem.should(Condition.visible);
    }
}
