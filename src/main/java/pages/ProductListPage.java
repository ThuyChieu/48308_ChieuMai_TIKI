package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import enums.Product;
import helpers.NumberHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductListPage {
    private final List<SelenideElement> listProduct = $$(By.xpath("//a[@data-view-id = 'product_list_item']"));
    private final List<SelenideElement> productNameList = $$(By.xpath("//h3[contains(@class, 'NameStyled')]"));
    private final List<SelenideElement> productPriceList = $$(By.xpath("//div[@class = 'price-discount__price']"));

    @Step("Count the number of products")
    public int getProductCount() {
        return listProduct.size();
    }

    @Step("Get a random number")
    public int getRandomProductIndex() {
        return NumberHelper.getRandomNumber(getProductCount());
    }

    @Step("Get all products information")
    public List<Product> getAllProductInfo() {
        List<Product> productList = new ArrayList<>();
        for (int index = 0; index < getProductCount(); index++) {
            String name = productNameList.get(index).getText();
            String price = productPriceList.get(index).getText();
            Integer reformatPrice = NumberHelper.parseCurrencyToInt(price);
            productList.add(Product.builder()
                    .name(name)
                    .price(reformatPrice)
                    .build());
        }
        return productList;
    }

    @Step("Get \"{index}\" product information")
    public Product getProductInfo(int index){
        return getAllProductInfo().get(index);
    }

    @Step("Click on item has index: {index}")
    public void clickOnProductItem(int index) {
        listProduct.get(index).click();
    }


}
