package utils;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import services.TranslationService;

public class BackRules implements BeforeEachCallback, AfterEachCallback {
    /**
     * Выполнение после каждого теста.
     *
     * @param context
     * @throws Exception
     */
    @Override
    public void afterEach(final ExtensionContext context) throws Exception {
        TranslationService.closeFiS();
    }

    /**
     * Выполнение перед каждым тестом.
     *
     * @param context
     * @throws Exception
     */
    @Override
    public void beforeEach(final ExtensionContext context) throws Exception {
        TranslationService.setUpFiS();
    }
}
