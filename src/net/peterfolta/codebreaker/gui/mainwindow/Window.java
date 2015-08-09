/*
 * CodeBreaker - A java implementation of the popular board game known as Mastermind.
 * Copyright (C) 2015 Peter Folta. All rights reserved.
 *
 * Project:				CodeBreaker
 * Version:				0.0.1
 * Website:				http://www.peterfolta.net/software/codebreaker
 * 
 * File:				Window.java
 * Created:				2015/8/6
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

package net.peterfolta.codebreaker.gui.mainwindow;

import net.peterfolta.codebreaker.controllers.gui.MainWindowController;
import net.peterfolta.codebreaker.main.Data;
import net.peterfolta.codebreaker.tools.WindowTools;

import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;

public class Window {
	
	private Display display;
	
	private Shell mainShell;
	
	public Window(Display display, MainWindowController mainWindowController) {
		this.display = display;
		
		mainShell = new Shell(this.display);
		mainShell.setText(Data.APP_NAME);
		
		mainShell.addShellListener(new ShellListener() {
			public void shellActivated(ShellEvent event) {
			}

			public void shellClosed(ShellEvent event) {
				event.doit = false;
			}

			public void shellDeactivated(ShellEvent event) {
			}

			public void shellDeiconified(ShellEvent event) {
			}

			public void shellIconified(ShellEvent event) {
			}
		});
		
		drawBoard();
		
		WindowTools.centerShellOnPrimaryMonitor(this.display, mainShell);
	}
	
	public Shell getMainWindow() {
		return mainShell;
	}
	
	public void setMenuBar(Menu menu) {
		mainShell.setMenuBar(menu);
	}
	
	private void drawBoard() {
		
	}
	
	public void show() {
		mainShell.open();
	}
	
}