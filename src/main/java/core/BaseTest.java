package core;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    static {
        WebDriverManager.chromedriver().setup();

        Configuration.timeout = 25000;
        Configuration.browserSize = "1366x768";
    }

}
