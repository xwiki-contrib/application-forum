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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.xwiki.contrib.forum.test.po.ForumEditPage;
import org.xwiki.contrib.forum.test.po.ForumViewPage;
import org.xwiki.contrib.forum.test.po.ForumsHomePage;
import org.xwiki.contrib.forum.test.po.TopicAddElement;
import org.xwiki.panels.test.po.ApplicationsPanel;
import org.xwiki.test.docker.junit5.UITest;
import org.xwiki.test.ui.TestUtils;
import org.xwiki.test.ui.po.ViewPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * UI tests for the Forum application.
 *
 * @version $Id$
 * @since 1.9.4
 */
@UITest(properties = {
    // The Forum application needs programming rights, for instance to display its panel on a newly created forum.
    "xwikiPropertiesAdditionalProperties=test.prchecker.excludePattern=.*:(ForumCode|Forums)\\..*"
}, extraJARs = {
    // Solr is needed by the Ratings Application and installing it as an extension fails: the parent POM of Solr
    // cannot be resolved at runtime.
    "org.xwiki.platform:xwiki-platform-search-solr-api"
}, resolveExtraJARs = true)
class ForumsIT
{
    private static final String FORUM_TITLE = "MyForum";

    private static final String FORUM_DESCRIPTION = "MyForum Description";

    private static final String TOPIC_TITLE = "MyTopic";

    private static final String TOPIC_DESCRIPTION = "MyTopic Description";

    @BeforeEach
    void setUp(TestUtils setup)
    {
        setup.loginAsSuperAdmin();
    }

    @Test
    @Order(1)
    void applicationPanelLinksToForumsHomePage()
    {
        ApplicationsPanel applicationPanel = ApplicationsPanel.gotoPage();
        ViewPage vp = applicationPanel.clickApplication(ForumsHomePage.getAppTitle());

        assertEquals(ForumsHomePage.getSpace(), vp.getMetaDataValue("space"));
        assertEquals(ForumsHomePage.getPage(), vp.getMetaDataValue("page"));
    }

    @Test
    @Order(2)
    void createForumEntities()
    {
        ForumsHomePage forumsHomePage = ForumsHomePage.gotoPage();
        // View Forums homepage tour
        forumsHomePage.viewTour();
        // Create new forum
        forumsHomePage.clickAddForumButton();
        forumsHomePage.setAddForumEntryInput(FORUM_TITLE);

        ForumEditPage forumEditPage = forumsHomePage.clickAddForumEntryButton();
        assertEquals(FORUM_TITLE, forumEditPage.getTitle());
        forumEditPage.setDescription(FORUM_DESCRIPTION);
        forumEditPage.clickSaveAndView();

        ForumViewPage forumViewPage = new ForumViewPage();
        assertEquals(FORUM_TITLE, forumViewPage.getDocumentTitle());
        assertEquals(FORUM_DESCRIPTION, forumViewPage.getDescription());

        // View Forum tour
        forumViewPage.viewTour();
        // Create new topic
        TopicAddElement topicAddForm = forumViewPage.clickAddTopicActivator();
        topicAddForm.getEditForm().setTitle(TOPIC_TITLE);
        topicAddForm.getEditForm().setDescription(TOPIC_DESCRIPTION);
        topicAddForm.clickAddTopicButton();

        // TODO: Test the visit on Topic page + creation of Answers and Comments after
        // http://jira.xwiki.org/browse/XAFORUM-222 is fixed
        // Topic page can't be visited due the fact that the name contains timestamp(no static value can be taken).

        // Delete the forum and verify that it has been deleted.
        forumsHomePage = ForumsHomePage.gotoPage();
        forumsHomePage.deleteForumPage(FORUM_TITLE);
        assertTrue(forumsHomePage.getNotification().contains("Forum deleted"));
    }
}
