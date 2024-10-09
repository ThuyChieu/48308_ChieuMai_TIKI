
import enums.LeftMenu;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductListPage;
import pages.TatCaBoLocDialog;
import reports.TestReporter;

import static listeners.TestListener.logMethod;
import static listeners.TestListener.logStep;


public class TestCase001 extends TestBase {
    @Test(description = "Verify user can filter search condition for product")
    public void TC001() {
        String nhaCungCap = "Nhà sách Fahasa";
        String minPrice = "60.000";
        String maxPrice = "140.000";
        String expectedBreadcum = "Trang chủ >" + " Nhà Sách Tiki";
        HomePage homePage = new HomePage();
        ProductListPage productListPage = new ProductListPage();
        TatCaBoLocDialog tatCaBoLocDialog = new TatCaBoLocDialog();

        logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to 'TIKI' website");
        homePage.closePopupAdvertisement();

        logStep = TestReporter.logStepInfo(logMethod, "Step #2:  Select left menu ");
        homePage.selectLeftMenu(LeftMenu.NHA_SACH_TIKI);
        Assert.assertEquals(homePage.getBreadcrumbText(), expectedBreadcum);

        logStep = TestReporter.logStepInfo(logMethod, "Step #3: Click on Tất cả button under Tất cả " +
                "sản phẩm section");
        productListPage.clickOnSortItem();
        tatCaBoLocDialog.isTatCaBoLocDialogDisplayed();

        logStep = TestReporter.logStepInfo(logMethod, "Step #4: Check on Nhà cung cấp 'Nhà sách Fahasa' " +
                "checkbox");
        tatCaBoLocDialog.checkOnNhaCungCapCkb(nhaCungCap);

        logStep = TestReporter.logStepInfo(logMethod, "Step #5:  Enter price range, then select Xem Kết " +
                "quả button");
        tatCaBoLocDialog.inputPriceRange(minPrice, maxPrice);
        tatCaBoLocDialog.clickXemKetQuaButton();
        productListPage.nhaSachFahasaHighlighted();
        productListPage.allProductPriceInSuitableRange(minPrice, maxPrice);
    }
}
