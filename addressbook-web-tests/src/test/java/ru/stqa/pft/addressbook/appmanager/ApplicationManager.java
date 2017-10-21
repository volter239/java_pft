package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    FirefoxDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;

    public void init() {
        // java.lang.IllegalStateException: The path to the driver executable must be set by the webdriver.gecko.driver system property ...
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\ToolsForBrowsers\\geckodriver.exe");

        wd = new FirefoxDriver();
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
