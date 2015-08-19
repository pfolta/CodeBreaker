/*
 * CodeBreaker - A java implementation of the popular board game known as Mastermind.
 * Copyright (C) 2015 Peter Folta. All rights reserved.
 *
 * Project:				CodeBreaker
 * Version:				0.0.1
 * Website:				http://www.peterfolta.net/software/codebreaker
 * 
 * File:				MainMenuBar.java
 * Created:				2015/8/7
 * Last modified:		2015/8/15
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
import net.peterfolta.codebreaker.main.Main;
import net.peterfolta.codebreaker.tools.Platform;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class MainMenuBar {
	
	private Display display;
	private MainWindowController mainWindowController;
	private Shell parentShell;
	
	private Menu mainMenu;
	
	private Menu gameMenu;
	private MenuItem gameMenuItem;
	private MenuItem gameMenuNewGameItem;
	private MenuItem gameMenuProfileItem;
	private MenuItem gameMenuStatisticsItem;
	private MenuItem gameMenuAchievementsItem;
	private MenuItem gameMenuOptionsItem;
	private MenuItem gameMenuResignItem;
	private MenuItem gameMenuExitItem;
	
	private Menu helpMenu;
	private MenuItem helpMenuItem;
	private MenuItem helpMenuHelpItem;
	private MenuItem helpMenuAboutItem;
	
	public MainMenuBar(Display display, MainWindowController mainWindowController, Shell parentShell) {
		this.display = display;
		this.mainWindowController = mainWindowController;
		this.parentShell = parentShell;
		
		/*
		 * Undock Menu Bar on Mac OS
		 */
		if (Platform.isMac()) {
			mainMenu = this.display.getMenuBar();
		} else {
			mainMenu = new Menu(this.parentShell, SWT.BAR);			
		}
		
		gameMenuItem = new MenuItem(mainMenu, SWT.CASCADE);
		gameMenuItem.setText(Main.getLanguage().getContent("Game"));
		
		gameMenu = new Menu(gameMenuItem);
		gameMenuItem.setMenu(gameMenu);
		
		gameMenuNewGameItem = new MenuItem(gameMenu, SWT.PUSH);
		gameMenuNewGameItem.setText(Main.getLanguage().getContent("NewGame"));
		
		if (Platform.isMac()) {
			gameMenuNewGameItem.setAccelerator(SWT.COMMAND | 'N');
		} else {
			gameMenuNewGameItem.setText(gameMenuNewGameItem.getText() + "\tCtrl+N");
			gameMenuNewGameItem.setAccelerator(SWT.CTRL + 'N');
		}
		
		gameMenuNewGameItem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				System.out.println("gameMenuNewGameItem clicked");
			}
		});
		
		new MenuItem(gameMenu, SWT.SEPARATOR);
		
		gameMenuProfileItem = new MenuItem(gameMenu, SWT.PUSH);
		gameMenuProfileItem.setText(Main.getLanguage().getContent("Profile"));
		gameMenuProfileItem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				MainMenuBar.this.mainWindowController.showProfileWindow();
			}
		});
		
		gameMenuStatisticsItem = new MenuItem(gameMenu, SWT.PUSH);
		gameMenuStatisticsItem.setText(Main.getLanguage().getContent("Statistics"));
		gameMenuStatisticsItem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				System.out.println("gameMenuStatisticsItem clicked");
			}
		});
		
		gameMenuAchievementsItem = new MenuItem(gameMenu, SWT.PUSH);
		gameMenuAchievementsItem.setText(Main.getLanguage().getContent("Achievements"));
		gameMenuAchievementsItem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				System.out.println("gameMenuAchievementsItem clicked");
			}
		});
		
		/*
		 * Do not create "Options" Menu Item on Mac OS
		 */
		if (!Platform.isMac()) {
			new MenuItem(gameMenu, SWT.SEPARATOR);
			
			gameMenuOptionsItem = new MenuItem(gameMenu, SWT.PUSH);
			gameMenuOptionsItem.setText(Main.getLanguage().getContent("Options"));
			gameMenuOptionsItem.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					System.out.println("gameMenuOptionsItem clicked");
				}
			});
		}
		
		new MenuItem(gameMenu, SWT.SEPARATOR);
		
		gameMenuResignItem = new MenuItem(gameMenu, SWT.PUSH);
		gameMenuResignItem.setText(Main.getLanguage().getContent("Resign"));
		gameMenuResignItem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				System.out.println("gameMenuResignItem clicked");
			}
		});
		
		/*
		 * Do not create "Exit" Menu Item on Mac OS
		 */
		if (!Platform.isMac()) {
			gameMenuExitItem = new MenuItem(gameMenu, SWT.PUSH);
			gameMenuExitItem.setText(Main.getLanguage().getContent("Exit") + "\tAlt+F4");
			gameMenuExitItem.setAccelerator(SWT.ALT | SWT.F4);
			gameMenuExitItem.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					System.out.println("gameMenuExitItem clicked");
				}
			});
		}
		
		helpMenuItem = new MenuItem(mainMenu, SWT.CASCADE);
		helpMenuItem.setText(Main.getLanguage().getContent("Help"));
		
		helpMenu = new Menu(helpMenuItem);
		helpMenuItem.setMenu(helpMenu);
		
		helpMenuHelpItem = new MenuItem(helpMenu, SWT.PUSH);
		helpMenuHelpItem.setText(Main.getLanguage().getContent("Help"));
		
		if (Platform.isMac()) {
			helpMenuHelpItem.setAccelerator(SWT.COMMAND | '?');
		} else {
			helpMenuHelpItem.setText(helpMenuHelpItem.getText() + "\tF1");
			helpMenuHelpItem.setAccelerator(SWT.F1);
		}
		
		helpMenuHelpItem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				MainMenuBar.this.mainWindowController.showHelpWindow();
			}
		});
		
		/*
		 * Do not create "About CodeBreaker" Menu Item on Mac OS
		 */
		if (!Platform.isMac()) {
			new MenuItem(helpMenu, SWT.SEPARATOR);
			
			helpMenuAboutItem = new MenuItem(helpMenu, SWT.PUSH);
			helpMenuAboutItem.setText(Main.getLanguage().getContent("About"));
			helpMenuAboutItem.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					System.out.println("helpMenuAboutItem clicked");
				}
			});
		}
	}
	
	public Menu getMainMenu() {
		return mainMenu;
	}
	
}