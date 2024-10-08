import org.testng.annotations.Test;
import reports.TestReporter;

import static listeners.TestListener.logMethod;
import static listeners.TestListener.logStep;

public class TestCase002 extends TestBase {
    @Test(description = "Verify user can filter search condition for product")
    public void TC002() {
        logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to 'TIKI' website");
        logStep = TestReporter.logStepInfo(logMethod, "Step #2: Select left menu");
        logStep = TestReporter.logStepInfo(logMethod, "Step #3: Click on 'Login' button");
        logStep = TestReporter.logStepInfo(logMethod, "Step #4: Select 'Nhà cung cấp'");
        logStep = TestReporter.logStepInfo(logMethod, "Step #5: Enter price range, then select 'Áp dụng' button");
    }
}
