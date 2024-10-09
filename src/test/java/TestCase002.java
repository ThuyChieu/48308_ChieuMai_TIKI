import enums.LeftMenu;
import models.Product;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductListPage;
import reports.TestReporter;

import static listeners.TestListener.logMethod;
import static listeners.TestListener.logStep;

public class TestCase002 extends TestBase {
    @Test(description = "Verify user can filter search condition for product")
    public void TC002() {
        HomePage homePage = new HomePage();
        ProductListPage productListPage = new ProductListPage();
        int maxNumberOfProduct = 20;

        logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to 'TIKI' website");
        homePage.closePopupAdvertisement();

        logStep = TestReporter.logStepInfo(logMethod, "Step #2: Select left menu");
        homePage.selectLeftMenu(LeftMenu.THE_THAO_DA_NGOAI);

        logStep = TestReporter.logStepInfo(logMethod, "Step #3: Click on an item to view the details");
        int index = productListPage.getRandomProductIndex(maxNumberOfProduct);
        productListPage.clickOnProductItem(index);

        logStep = TestReporter.logStepInfo(logMethod, "Step #4: Go back to home page then select any item in \n" +
                "the left menu");
        homePage.goToHomePage();
        homePage.selectLeftMenu(LeftMenu.DIEN_GIA_DUNG);
        productListPage.isViewItemDisplayed();
    }
}
