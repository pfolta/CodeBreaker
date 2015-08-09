/*
 * CodeBreaker - A java implementation of the popular board game known as Mastermind.
 * Copyright (C) 2015 Peter Folta. All rights reserved.
 *
 * Project:				CodeBreaker
 * Version:				0.0.1
 * Website:				http://www.peterfolta.net/software/codebreaker
 * 
 * File:				MainWindowController.java
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

package net.peterfolta.codebreaker.controllers.gui;

import net.peterfolta.codebreaker.gui.mainwindow.MainCocoaSystemMenu;
import net.peterfolta.codebreaker.gui.mainwindow.MainMenuBar;
import net.peterfolta.codebreaker.gui.mainwindow.MainWindow;
import net.peterfolta.codebreaker.tools.Platform;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MainWindowController {
	
	private GUIController guiController;
	private Display display;
	
	private MainWindow mainWindow;
	private MainMenuBar mainMenu; 
	
	public MainWindowController(GUIController guiController, Display display) {
		this.guiController = guiController;
		this.display = display;
		
		mainWindow = new MainWindow(this.display, this);
		mainMenu = new MainMenuBar(this.display, this, mainWindow.getMainWindow());
		
		/*
		 * Attach Menu Bar to Main Window unless running on Mac OS
		 */
		if (!Platform.isMac()) {
			mainWindow.setMenuBar(mainMenu.getMainMenu());			
		}
		
		/*
		 * 
		 */
		if (Platform.isMac()) {
			new MainCocoaSystemMenu(this.display.getSystemMenu(), mainWindow.getMainWindow());
		}
	}
	
	public void showMainWindow() {
		mainWindow.show();
	}
	
	public Shell getMainWindow() {
		return mainWindow.getMainWindow();
	}
	
	public void showHelpWindow() {
		guiController.showHelpWindow();
	}
	
}