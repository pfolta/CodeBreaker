/*
 * CodeBreaker - A java implementation of the popular board game known as Mastermind.
 * Copyright (C) 2015 Peter Folta. All rights reserved.
 *
 * Project:				CodeBreaker
 * Version:				0.0.1
 * Website:				http://www.peterfolta.net/software/codebreaker
 * 
 * File:				HelpToolBar.java
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
import net.peterfolta.codebreaker.tools.Platform;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class HelpToolBar {
	
	private Display display;
	private HelpWindowController helpWindowController;
	private Shell parentShell;
	
	private ToolBar toolBar;
	
	private ToolItem backToolItem;
	private ToolItem forwardToolItem;
	private ToolItem homeToolItem;
	
	public HelpToolBar(Display display, HelpWindowController helpWindowController, Shell parentShell) {
		this.display = display;
		this.helpWindowController = helpWindowController;
		this.parentShell = parentShell;
		
		/*
		 * Integrate Tool Bar and Window Frame on Mac OS 
		 */
		if (Platform.isMac()) {
			toolBar = parentShell.getToolBar();
		} else {
			toolBar = new ToolBar(this.parentShell, SWT.FLAT);
			toolBar.setBackground(new Color(this.display, 255, 255, 255));
		}
		
		backToolItem = new ToolItem(toolBar, SWT.PUSH);
		backToolItem.setText("Back");
		backToolItem.setEnabled(false);
		backToolItem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				System.out.println("backToolItem clicked");
			}
		});
		
		forwardToolItem = new ToolItem(toolBar, SWT.PUSH);
		forwardToolItem.setText("Forward");
		forwardToolItem.setEnabled(false);
		forwardToolItem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				System.out.println("forwardToolItem clicked");
			}
		});
		
		homeToolItem = new ToolItem(toolBar, SWT.PUSH);
		homeToolItem.setText("Home");
		homeToolItem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				System.out.println("homeToolItem clicked");
			}
		});
	}
	
}