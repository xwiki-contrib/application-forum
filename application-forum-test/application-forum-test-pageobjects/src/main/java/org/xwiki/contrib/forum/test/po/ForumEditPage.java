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
import org.xwiki.test.ui.po.InlinePage;

/**
 * Represents the Forum edit page.
 * 
 * @version $Id$
 * @since 1.9.4
 */
public class ForumEditPage extends InlinePage
{
    @FindBy(id = "forum-title")
    private WebElement title;

    @FindBy(id = "ForumCode.ForumClass_0_description")
    private WebElement description;

    /**
     * @return the forumTitle
     */
    public String getTitle()
    {
        return title.getAttribute("Value");
    }

    /**
     * @param title the forumTitle to set
     */
    public void setTitle(String givenTitle)
    {
        title.clear();
        title.sendKeys(givenTitle);
    }

    /**
     * @return the forumDescription
     */
    public WebElement getDescription()
    {
        return description;
    }

    /**
     * @param description the forumDescription to set
     */
    public void setDescription(String givenDescription)
    {
        description.clear();
        description.sendKeys(givenDescription);
    }

}
