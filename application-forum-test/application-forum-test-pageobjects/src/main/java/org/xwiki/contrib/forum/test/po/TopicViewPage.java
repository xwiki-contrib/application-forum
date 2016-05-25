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
 * Represents the Topic view page.
 * 
 * @version $Id$
 * @since 2.1
 */
public class TopicViewPage extends ViewPage
{
    @FindBy(css = ".addconversation-activator")
    private WebElement addAnswerActivator;

    @FindBy(css = ".topic-description>p")
    private WebElement description;

    /**
     * @return the topic page
     */
    public static TopicViewPage gotoPage()
    {
        getUtil().gotoPage(getSpace(), getPage());
        return new TopicViewPage();
    }

    /**
     * @return the space name of the topic
     */
    public static String getSpace()
    {
        return "Forums_MyForum";
    }

    /**
     * @return the page name of the topic
     */
    public static String getPage()
    {
        return "Topic";
    }

    /**
     * @return the form to enter new answer
     */
    public AnswerAddElement clickAddAnswerActivator()
    {
        addAnswerActivator.click();
        AnswerAddElement answerAddForm = new AnswerAddElement();
        return answerAddForm;
    }

    /**
     * @return the form to enter new comment
     */
    public CommentAddElement clickAddCommentActivator()
    {
        CommentAddElement commentAddForm = new CommentAddElement();
        return commentAddForm;
    }

    /**
     * @return the topic description
     */
    public String getDescription()
    {
        return description.getText();
    }
}
