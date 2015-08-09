/*
 * CodeBreaker - A java implementation of the popular board game known as Mastermind.
 * Copyright (C) 2015 Peter Folta. All rights reserved.
 *
 * Project:				CodeBreaker
 * Version:				0.0.1
 * Website:				http://www.peterfolta.net/software/codebreaker
 * 
 * File:				HelpWindowController.java
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

package net.peterfolta.codebreaker.controllers.gui;

import net.peterfolta.codebreaker.gui.helpwindow.HelpBrowser;
import net.peterfolta.codebreaker.gui.helpwindow.HelpToolBar;
import net.peterfolta.codebreaker.gui.helpwindow.HelpWindow;
import net.peterfolta.codebreaker.tools.ResourceLoader;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class HelpWindowController {
	
	private Display display;
	
	private String homeURL;
	
	private HelpWindow helpWindow;
	private HelpToolBar helpToolBar;
	private HelpBrowser helpBrowser;
	
	public HelpWindowController(Display display, Shell mainShell) {
		this.display = display;
		
		homeURL = ResourceLoader.getHelp("en");
		
		helpWindow = new HelpWindow(this.display, mainShell);
		helpToolBar = new HelpToolBar(display, this, helpWindow.getHelpWindow());
		helpBrowser = new HelpBrowser(display, this,helpWindow.getHelpWindow());
		
		goHome();
	}
	
	public void showHelpWindow() {
		helpWindow.show();
	}
	
	public Shell getHelpWindow() {
		return helpWindow.getHelpWindow();
	}
	
	public void goBack() {
		helpBrowser.getBrowser().back();
	}
	
	public void goForward() {
		helpBrowser.getBrowser().forward();
	}
	
	public void goHome() {
		helpBrowser.getBrowser().setUrl(homeURL);
	}
	
	public void completeNavigation() {
		helpToolBar.setBackButtonEnabled(helpBrowser.getBrowser().isBackEnabled());
		helpToolBar.setForwardButtonEnabled(helpBrowser.getBrowser().isForwardEnabled());
	}
	
}