/*
 * CodeBreaker - A java implementation of the popular board game known as Mastermind.
 * Copyright (C) 2015 Peter Folta. All rights reserved.
 *
 * Project:				CodeBreaker
 * Version:				0.0.1
 * Website:				http://www.peterfolta.net/software/codebreaker
 * 
 * File:				HelpWindow.java
 * Created:				2015/8/9
 * Last modified:		2015/8/10
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
import net.peterfolta.codebreaker.main.Main;
import net.peterfolta.codebreaker.tools.WindowTools;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class HelpWindow {
	
	private Display display;
	private Shell parentShell;
	
	private Shell helpShell;
	
	private GridLayout gridLayout;
	
	public HelpWindow(Display display, HelpWindowController helpWindowController, Shell parentShell) {
		this.display = display;
		this.parentShell = parentShell;
		
		helpShell = new Shell(this.display);
		
		helpShell.setText(Main.getLanguage().getContent("Help"));
		
		helpShell.setBackground(new Color(this.display, 255, 255, 255));
		
		gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.horizontalSpacing = 0;
		gridLayout.verticalSpacing = 0;
		helpShell.setLayout(gridLayout);
		
		helpShell.setSize(600, 800);
		
		WindowTools.centerShellOnParent(helpShell, this.parentShell);
	}
	
	public Shell getHelpWindow() {
		return helpShell;
	}
	
	public void show() {
		helpShell.open();
	}
	
}