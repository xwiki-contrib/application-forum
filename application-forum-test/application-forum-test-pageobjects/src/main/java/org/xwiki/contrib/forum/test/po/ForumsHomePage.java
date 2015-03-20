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

import org.xwiki.test.ui.po.ViewPage;

/**
 * Represents actions that can be done on the IRC.WebHome page.
 *
 * @version $Id$
 * @since 1.9.4
 */
public class ForumsHomePage extends ViewPage
{
    /**
     * Opens the home page.
     */
    public static ForumsHomePage gotoPage()
    {
        getUtil().gotoPage(getSpace(), getPage());
        return new ForumsHomePage();
    }

    public static String getSpace()
    {
        return "Forums";
    }

    public static String getPage()
    {
        return "WebHome";
    }
    
    public static String getAppTitle()
    {
        return "Forums";
    }
}
