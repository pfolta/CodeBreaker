/*
 * CodeBreaker - A java implementation of the popular board game known as Mastermind.
 * Copyright (C) 2015 Peter Folta. All rights reserved.
 *
 * Project:				CodeBreaker
 * Version:				0.0.1
 * Website:				http://www.peterfolta.net/software/codebreaker
 * 
 * File:				MainWindow.java
 * Created:				2015/8/6
 * Last modified:		2015/8/6
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

import net.peterfolta.codebreaker.enums.ExitCode;
import net.peterfolta.codebreaker.main.Main;

import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;

public class MainWindow {
	
	private Shell mainShell;
	
	public MainWindow(Display display) {
		mainShell = new Shell(display);
		
		mainShell.setText("CodeBreaker");
		
		mainShell.addShellListener(new ShellListener() {
			public void shellActivated(ShellEvent event) {
			}

			public void shellClosed(ShellEvent event) {
				Main.exit(ExitCode.OK);
			}

			public void shellDeactivated(ShellEvent event) {
			}

			public void shellDeiconified(ShellEvent event) {
			}

			public void shellIconified(ShellEvent event) {
			}
		});
		
		drawBoard();
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