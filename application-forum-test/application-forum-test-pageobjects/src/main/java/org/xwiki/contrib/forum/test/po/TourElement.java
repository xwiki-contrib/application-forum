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

import org.openqa.selenium.By;
import org.xwiki.test.ui.po.BaseElement;

/**
 * Represents the tour displayed on the Forum pages.
 * 
 * @version $Id$
 * @since 2.3.14
 */
public class TourElement extends BaseElement
{
    private static final String NEXT = "next";

    private static final String END = "end";

    /**
     * Navigates through all the steps of the tour and closes it.
     * 
     * @param stepsCount the number of steps of the tour
     */
    public void view(int stepsCount)
    {
        for (int step = 0; step < stepsCount - 1; step++) {
            clickButton(step, NEXT);
        }
        clickButton(stepsCount - 1, END);
        // Wait for all the tour elements to disappear instead of the last one because the order varies.
        getDriver().waitUntilElementDisappears(By.className("tour-backdrop"));
        getDriver().waitUntilElementDisappears(By.className("tour-step-background"));
        getDriver().waitUntilElementDisappears(By.cssSelector("[id^='step-']"));
    }

    private void clickButton(int step, String action)
    {
        String stepSelector = "#step-" + step;
        // The tour binds the actions of the buttons only after the step is completely shown, which is also when it
        // sets the padding of the step title. Clicking a button before that does nothing.
        getDriver().waitUntilElementIsVisible(By.cssSelector(stepSelector + " .popover-title[style*='padding-right']"));
        getDriver().findElement(By.cssSelector(stepSelector + " #bootstrap_tour_" + action)).click();
    }
}
