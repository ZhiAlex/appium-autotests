package com.zhialex.tests.appium_selenide_tests;

import com.codeborne.selenide.Configuration;
import com.zhialex.tests.drivers.BrowserstackMobileDriver;
import com.zhialex.tests.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.zhialex.tests.helpers.Attach.getSessionId;

public class TestBase {

    @BeforeAll
    public static void setUp() {
        Configuration.browser = BrowserstackMobileDriver.class.getName();
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    void addAttachment() {
        String sessionId = getSessionId();

        Attach.screenshotAs();
        Attach.pageSource();

        closeWebDriver();
        Attach.addVideo(sessionId);
    }
}
