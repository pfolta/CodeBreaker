/*
 * CodeBreaker - A java implementation of the popular board game known as Mastermind.
 * Copyright (C) 2015 Peter Folta. All rights reserved.
 *
 * Project:				CodeBreaker
 * Version:				0.0.1
 * Website:				http://www.peterfolta.net/software/codebreaker
 * 
 * File:				MainMenu.java
 * Created:				2015/8/7
 * Last modified:		2015/8/7
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

package net.peterfolta.codebreaker.gui;

import net.peterfolta.codebreaker.tools.Platform;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class MainMenu {
	
	private Menu mainMenu;
	
	private Menu gameMenu;
	private MenuItem gameMenuItem;
	private MenuItem gameMenuNewGameItem;
	private MenuItem gameMenuOptionsItem;
	private MenuItem gameMenuResignItem;
	private MenuItem gameMenuExitItem;
	
	private Menu helpMenu;
	private MenuItem helpMenuItem;
	private MenuItem helpMenuAboutItem;
	
	public MainMenu(Display display, Shell parent) {
		/*
		 * Undock Menu Bar on Mac OS
		 */
		if (Platform.isMac()) {
			mainMenu = display.getMenuBar();
		} else {
			mainMenu = new Menu(parent, SWT.BAR);			
		}
		
		gameMenuItem = new MenuItem(mainMenu, SWT.CASCADE);
		gameMenuItem.setText("Game");
		
		gameMenu = new Menu(gameMenuItem);
		gameMenuItem.setMenu(gameMenu);
		
		gameMenuNewGameItem = new MenuItem(gameMenu, SWT.PUSH);
		gameMenuNewGameItem.setText("New Game");
		
		new MenuItem(gameMenu, SWT.SEPARATOR);
		
		/*
		 * Do not create "Options" Menu Item on Mac OS
		 */
		if (!Platform.isMac()) {
			gameMenuOptionsItem = new MenuItem(gameMenu, SWT.PUSH);
			gameMenuOptionsItem.setText("Options");			
		}
		
		new MenuItem(gameMenu, SWT.SEPARATOR);
		
		gameMenuResignItem = new MenuItem(gameMenu, SWT.PUSH);
		gameMenuResignItem.setText("Resign");
		
		/*
		 * Do not create "Exit" Menu Item on Mac OS
		 */
		if (!Platform.isMac()) {
			gameMenuExitItem = new MenuItem(gameMenu, SWT.PUSH);
			gameMenuExitItem.setText("Exit\tAlt+F4");
			gameMenuExitItem.setAccelerator(SWT.ALT | SWT.F4);
		}
		
		helpMenuItem = new MenuItem(mainMenu, SWT.CASCADE);
		helpMenuItem.setText("Help");
		
		helpMenu = new Menu(helpMenuItem);
		helpMenuItem.setMenu(helpMenu);
		
		/*
		 * Do not create "About CodeBreaker" Menu Item on Mac OS
		 */
		if (!Platform.isMac()) {
			helpMenuAboutItem = new MenuItem(helpMenu, SWT.PUSH);
			helpMenuAboutItem.setText("About CodeBreaker");			
		}
	}
	
	public Menu getMainMenu() {
		return mainMenu;
	}
	
}