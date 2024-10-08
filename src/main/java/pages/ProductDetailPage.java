package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.Product;
import helpers.NumberHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class ProductDetailPage {
    private final SelenideElement productTitleLabel = $(By.xpath("//h1[@class='Title__TitledStyled-sc-c64ni5-0 iXccQY']"));
    private final SelenideElement productPriceLabel = $(By.xpath("//div[@class = 'product-price__current-price']"));

    @Step("Get the current product title")
    public String getProductTitle() {
        return productTitleLabel.getText();
    }

    @Step("Get the current product price")
    public int getProductPrice() {
        Selenide.sleep(5000);
        String price = productPriceLabel.getText();
        return NumberHelper.parseCurrencyToInt(price);
    }

    @Step("Get product information")
    public Product getProductDetailInfo() {
        return Product.builder()
                .name(getProductTitle())
                .price(getProductPrice())
                .build();
    }
}
