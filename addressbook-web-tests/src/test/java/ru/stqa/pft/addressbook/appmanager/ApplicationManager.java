package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser == BrowserType.FIREFOX)
        {
            // java.lang.IllegalStateException: The path to the driver executable must be set by the webdriver.gecko.driver system property ...
            System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\ToolsForBrowsers\\geckodriver.exe");

            wd = new FirefoxDriver();
        }
        else if (browser == BrowserType.CHROME)
        {
            // java.lang.IllegalStateException: The path to the driver executable must be set by the webdriver.chrome.driver system property ...
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ToolsForBrowsers\\chromedriver.exe");

            wd = new ChromeDriver();
        }
        else if (browser == BrowserType.IE)
        {
            // java.lang.IllegalStateException: The path to the driver executable must be set by the webdriver.ie.driver system property ...
            System.setProperty("webdriver.ie.driver", "C:\\Program Files\\ToolsForBrowsers\\IEDriverServer.exe");

            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        wd.get("http://localhost:8080/addressbook/group.php");

        groupHelper = new GroupHelper(wd);

        contactHelper = new ContactHelper(wd);

        navigationHelper = new NavigationHelper(wd);

        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
