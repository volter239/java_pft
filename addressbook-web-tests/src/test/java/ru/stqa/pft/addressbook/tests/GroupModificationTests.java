package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();

        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", "test1_create", null));
        }

        int before = app.getGroupHelper().getGroupCount();

        app.getGroupHelper().selectGroup(before-1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("test21", "test21_update", "test21_update"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after,before);
    }

}
