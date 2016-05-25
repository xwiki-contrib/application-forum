/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.contrib.forum.test.po;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.xwiki.test.ui.po.ViewPage;

/**
 * Represents actions that can be done on the Forum.WebHome page.
 *
 * @version $Id$
 * @since 1.9.4
 */
public class ForumsHomePage extends ViewPage
{
    @FindBy(id = "addForum")
    private WebElement addForumButton;

    @FindBy(xpath = "//div[@id = 'entryNamePopup']//input[@type = 'text']")
    private WebElement addForumEntryInput;

    @FindBy(xpath = "//div[@id = 'entryNamePopup']//input[@type = 'image']")
    private WebElement addForumEntryButton;

    // Forums homepage tour steps
    @FindBy(css = "#step-0 [data-role = 'next']")
    private WebElement step_0;

    @FindBy(css = "#step-1 [data-role = 'next']")
    private WebElement step_1;

    @FindBy(css = "#step-2 [data-role = 'next']")
    private WebElement step_2;

    @FindBy(css = "#step-3 [data-role = 'end']")
    private WebElement step_3;

    @FindBy(xpath = "//tbody[@id='forums-display']//tr")
    private List<WebElement> forums;

    @FindBy(className = "xnotification-done")
    private WebElement notification;

    /**
     * Opens the home page.
     */
    public static ForumsHomePage gotoPage()
    {
        getUtil().gotoPage(getSpace(), getPage());
        return new ForumsHomePage();
    }

    /**
     * Space name of the home page.
     */
    public static String getSpace()
    {
        return "Forums";
    }

    /**
     * Page name of the home page.
     */
    public static String getPage()
    {
        return "WebHome";
    }

    /**
     * Title of the application displayed in the AppBar
     */
    public static String getAppTitle()
    {
        return "Forums";
    }

    /**
     * @return the modal to enter new Forum entry name
     */
    public void clickAddForumButton()
    {
        addForumButton.click();
    }

    /**
     * @param forumName the name of the new Forum entry
     */
    public void setAddForumEntryInput(String forumName)
    {
        this.addForumEntryInput.clear();
        this.addForumEntryInput.sendKeys(forumName);
    }

    /**
     * @return the new Forum entry page
     */
    public ForumEditPage clickAddForumEntryButton()
    {
        this.addForumEntryButton.click();
        return new ForumEditPage();
    }

    /**
     * Navigates through the Forums homepage tour
     */
    public void viewTour()
    {
        step_0.click();
        step_1.click();
        step_2.click();
        step_3.click();
    }

    public void deleteForumPage(String forumName)
    {
        for (WebElement row : forums) {
            WebElement name = row.findElement(By.xpath("//td[contains(@class, 'doc_title')]/a"));
            if (forumName.equals(name.getText())) {
                row.findElement(By.xpath("//a[contains(@class, 'deleteforum') and contains(@space, 'Forums.MyForum')]"))
                    .click();
                getDriver().findElement(By.cssSelector(".xdialog-box-confirmation [value = 'Yes']")).click();
            }
        }
    }

    /**
     * @return the value of the notification
     */
    public String getNotification()
    {
        return notification.getText();
    }
}
