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
package org.xwiki.contrib.forum.test.ui;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.xwiki.contrib.forum.test.po.ForumEditPage;
import org.xwiki.contrib.forum.test.po.ForumViewPage;
import org.xwiki.contrib.forum.test.po.ForumsHomePage;
import org.xwiki.panels.test.po.ApplicationsPanel;
import org.xwiki.test.ui.AbstractTest;
import org.xwiki.test.ui.SuperAdminAuthenticationRule;
import org.xwiki.test.ui.po.ViewPage;

/**
 * UI tests for the Forum application.
 *
 * @version $Id$
 * @since 1.9.4
 */
public class ForumsTest extends AbstractTest
{
    @Rule
    public SuperAdminAuthenticationRule authenticationRule = new SuperAdminAuthenticationRule(getUtil(), getDriver());

    private static final String FORUM_NAME = "Forum 01";

    private static final String FORUM_DESCRIPTION = "Forum 01 Description";

    @Test
    public void testApplicationPanelLinksToForumsHomePage()
    {
        ApplicationsPanel applicationPanel = ApplicationsPanel.gotoPage();
        ViewPage vp = applicationPanel.clickApplication(ForumsHomePage.getAppTitle());

        Assert.assertEquals(ForumsHomePage.getSpace(), vp.getMetaDataValue("space"));
        Assert.assertEquals(ForumsHomePage.getPage(), vp.getMetaDataValue("page"));
    }

    @Test
    public void testCreateForumEntities()
    {
        // Create new forum
        ForumsHomePage forumsHomePage = ForumsHomePage.gotoPage();
        forumsHomePage.clickAddForumButton();
        forumsHomePage.setAddForumEntryInput(FORUM_NAME);

        ForumEditPage forumEditPage = forumsHomePage.clickAddForumEntryButton();
        Assert.assertEquals(FORUM_NAME, forumEditPage.getTitle());
        forumEditPage.setDescription(FORUM_DESCRIPTION);
        forumEditPage.clickSaveAndView();

        // Create new topic
        ForumViewPage forumViewPage = new ForumViewPage();
        forumViewPage.clickAddTopicActivator();
    }
}
