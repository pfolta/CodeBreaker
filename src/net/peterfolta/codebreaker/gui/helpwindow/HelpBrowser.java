/*
 * CodeBreaker - A java implementation of the popular board game known as Mastermind.
 * Copyright (C) 2015 Peter Folta. All rights reserved.
 *
 * Project:				CodeBreaker
 * Version:				0.0.1
 * Website:				http://www.peterfolta.net/software/codebreaker
 * 
 * File:				HelpBrowser.java
 * Created:				2015/8/9
 * Last modified:		2015/8/9
 * Author:				Peter Folta <mail@peterfolta.net>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.peterfolta.codebreaker.gui.helpwindow;

import net.peterfolta.codebreaker.controllers.gui.HelpWindowController;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class HelpBrowser {
	
	private HelpWindowController helpWindowController;
	private Shell helpWindow;
	
	private Browser helpBrowser;
	
	private GridData gridData;
	
	public HelpBrowser(Display display, HelpWindowController helpWindowController, Shell helpWindow) {
		this.helpWindowController = helpWindowController;
		this.helpWindow = helpWindow;
		
		helpBrowser = new Browser(this.helpWindow, SWT.NONE);
		
		helpBrowser.addProgressListener(new ProgressListener() {
			public void changed(ProgressEvent event) {
			}

			public void completed(ProgressEvent event) {
				HelpBrowser.this.helpWindowController.completeNavigation();
			}
		});
		
		gridData = new GridData(GridData.FILL_BOTH);
		helpBrowser.setLayoutData(gridData);
		
		helpBrowser.setFocus();
	}
	
	public Browser getBrowser() {
		return helpBrowser;
	}
	
}