package utils;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class FrontRules implements BeforeEachCallback, AfterEachCallback {

    /**
     * .
     *
     * @param context
     * @throws Exception
     */
    public void afterEach(final ExtensionContext context) throws Exception {
        Driver.closeDriver();
        System.out.println("Тест закончился");
    }

    /**
     * .
     *
     * @param context
     * @throws Exception
     */
    public void beforeEach(final ExtensionContext context) throws Exception {
        Driver.getDriver().manage().window().maximize();
        System.out.println("Тест начался");
    }
}
