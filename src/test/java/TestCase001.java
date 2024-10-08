
import enums.Product;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductListPage;
import reports.TestReporter;

import java.util.List;

import static listeners.TestListener.logMethod;
import static listeners.TestListener.logStep;


public class TestCase001 extends TestBase {
    @Test(description = "Verify the product information loaded correctly")
    public void TC001() {
        String keyword = "Điện thoại";
        String expectedBreadcum = "Trang chủ >" + " Kết quả tìm kiếm \"Điện thoại\"";
        HomePage homePage = new HomePage();
        ProductListPage productListPage = new ProductListPage();
        ProductDetailPage productDetailPage = new ProductDetailPage();

        logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to " +
                "'TIKI' website");
        homePage.closePopupAdvertisement();
        homePage.isSearchTextboxDisplayed();
        homePage.isSearchButtonDisplayed();

        logStep = TestReporter.logStepInfo(logMethod, "Step #2: On home page, enter value in 'Bạn tìm gì hôm "
                + "nay' textbox ");
        homePage.enterValueInSearchTextBox(keyword);

        logStep = TestReporter.logStepInfo(logMethod, "Step #3: Click 'Tìm kiếm' button");
        homePage.clickOnSearchButton();
        Assert.assertEquals(homePage.getBreadcrumbText(), expectedBreadcum);

        logStep = TestReporter.logStepInfo(logMethod, "Step #4: Select any item from result grid");

        int index = productListPage.getRandomProductIndex();
        Product productInfo = productListPage.getProductInfo(index);
        productListPage.clickOnProductItem(index);

        Assert.assertEquals(productDetailPage.getProductDetailInfo(), productInfo);
    }
}
