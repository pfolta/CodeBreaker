/*
 * CodeBreaker - A java implementation of the popular board game known as Mastermind.
 * Copyright (C) 2015 Peter Folta. All rights reserved.
 *
 * Project:				CodeBreaker
 * Version:				0.0.1
 * Website:				http://www.peterfolta.net/software/codebreaker
 * 
 * File:				MainCocoaSystemMenu.java
 * Created:				2015/8/8
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

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class MainCocoaSystemMenu {
	
	Menu cocoaSystemMenu;
	
	MenuItem aboutItem;
	MenuItem preferencesItem;
	MenuItem quitItem;
	
	public MainCocoaSystemMenu(Menu cocoaSystemMenu, Shell parent) {
		this.cocoaSystemMenu = cocoaSystemMenu;
		
		this.cocoaSystemMenu.setEnabled(true);
		
		aboutItem = getMenuItem(SWT.ID_ABOUT);
		aboutItem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				System.out.println("aboutItem clicked");
			}
		});
		
		preferencesItem = getMenuItem(SWT.ID_PREFERENCES);
		preferencesItem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				System.out.println("preferencesItem clicked");
			}
		});
		
		quitItem = getMenuItem(SWT.ID_QUIT);
		quitItem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				System.out.println("quitItem clicked");
				
				event.doit = false;
			}
		});
	}
	
	private MenuItem getMenuItem(int id) {
		MenuItem[] items = cocoaSystemMenu.getItems();
		
		for (int i = 0; i < items.length; i++) {
			if (items[i].getID() == id) {
				return items[i];
			}
		}
		
		return null;
	}
	
	
	
}