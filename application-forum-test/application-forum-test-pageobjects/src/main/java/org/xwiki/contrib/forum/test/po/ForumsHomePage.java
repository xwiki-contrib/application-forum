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
}
