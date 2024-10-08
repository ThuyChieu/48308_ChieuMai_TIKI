import enums.LeftMenu;
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

        logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to 'TIKI' website");
        homePage.closePopupAdvertisement();

        logStep = TestReporter.logStepInfo(logMethod, "Step #2: Select left menu");
        homePage.selectLeftMenu(LeftMenu.DIEN_GIA_DUNG);

        logStep = TestReporter.logStepInfo(logMethod, "Step #3: Select 'Nhà cung cấp'");
        logStep = TestReporter.logStepInfo(logMethod, "Step #4: Enter price range, then select 'Áp dụng' button");
    }
}
