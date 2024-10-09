package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TatCaBoLocDialog {
    private final SelenideElement tatCaBoLocDialog = $(By.xpath("//div[@class = 'styles__StyledContentModal" +
            "-sc-1fz54eb-2 kvMVpg']"));
    private final String nhaCungCapOption = "//span[text()='%s']";
    private final SelenideElement minPriceTextbox = $(By.xpath("//input[@placeholder= 'Từ']"));
    private final SelenideElement maxPriceTextbox = $(By.xpath("//input[@placeholder= 'Đến']"));
    private final SelenideElement xemKetQuaBtn = $(By.xpath("//div[text()='Xem kết quả']"));


    @Step("Check if tat ca bo loc dialog displays")
    public void isTatCaBoLocDialogDisplayed() {
        tatCaBoLocDialog.shouldHave(Condition.visible);
    }

    @Step("Check on Nha Cung Cap checkbox")
    public void checkOnNhaCungCapCkb(String option) {
        $x(String.format(nhaCungCapOption, option)).click();
    }

    @Step("Input price range")
    public void inputPriceRange(String min, String max) {
        minPriceTextbox.setValue(min);
        maxPriceTextbox.setValue(max);
    }

    @Step("Click on Xem Ket Qua button")
    public void clickXemKetQuaButton() {
        xemKetQuaBtn.click();
    }


}
