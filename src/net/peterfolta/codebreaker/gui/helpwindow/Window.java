/*
 * CodeBreaker - A java implementation of the popular board game known as Mastermind.
 * Copyright (C) 2015 Peter Folta. All rights reserved.
 *
 * Project:				CodeBreaker
 * Version:				0.0.1
 * Website:				http://www.peterfolta.net/software/codebreaker
 * 
 * File:				Window.java
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

import net.peterfolta.codebreaker.tools.WindowTools;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Window {
	
	private Display display;
	private Shell parentShell;
	
	private Shell helpShell;
	
	public Window(Display display, Shell parentShell) {
		this.display = display;
		this.parentShell = parentShell;
		
		helpShell = new Shell(this.display);
		helpShell.setText("Help");
		
		helpShell.pack();
		WindowTools.centerShellOnParent(helpShell, this.parentShell);
	}
	
	public Shell getHelpWindow() {
		return helpShell;
	}
	
	public void show() {
		helpShell.open();
	}
	
}