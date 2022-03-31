package com.zhialex.tests.appium_selenide_tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.MobileBy.*;
import static io.qameta.allure.Allure.step;

public class AndroidSelenideTest extends TestBase {

    @Test
    void firstAndroidSelenideTest() {

        step("skip start page", () -> back());
        step("set search value", () -> {
            $(AccessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).setValue("BrowserStack");
        });
        step("check if there are more than 0 entries",
                () -> $$(className("android.widget.TextView")).shouldHave(sizeGreaterThan(0)));
    }
}
