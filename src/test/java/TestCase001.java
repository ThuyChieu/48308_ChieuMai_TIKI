
import org.testng.annotations.Test;
import pages.HomePage;
import reports.TestReporter;

import static listeners.TestListener.logMethod;
import static listeners.TestListener.logStep;


public class TestCase001 extends TestBase {
    @Test(description = "Verify the product information loaded correctly")
    public void TC001() {
        String keyword = "Điện thoại";
        HomePage homePage = new HomePage();

        logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to " +
                "'TIKI' website");
        homePage.closePopupAdvertisement();

        logStep = TestReporter.logStepInfo(logMethod, "Step #2: On home page, enter value in 'Bạn tìm gì hôm "
                + "nay textbox ");


        logStep = TestReporter.logStepInfo(logMethod, "Step #3: Click 'Tìm kiếm' button");
        logStep = TestReporter.logStepInfo(logMethod, "Step #4: Select any item from result grid");
    }
}
