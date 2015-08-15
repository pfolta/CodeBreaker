/*
 * CodeBreaker - A java implementation of the popular board game known as Mastermind.
 * Copyright (C) 2015 Peter Folta. All rights reserved.
 *
 * Project:				CodeBreaker
 * Version:				0.0.1
 * Website:				http://www.peterfolta.net/software/codebreaker
 * 
 * File:				AchievementsWindow.java
 * Created:				2015/8/15
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

package net.peterfolta.codebreaker.gui.achievementswindow;

import net.peterfolta.codebreaker.controllers.gui.AchievementsWindowController;
import net.peterfolta.codebreaker.main.Main;
import net.peterfolta.codebreaker.tools.WindowTools;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class AchievementsWindow {
	
	private Display display;
	private Shell parentShell;
	
	private Shell achievementsShell;
	
	private GridLayout gridLayout;
	
	public AchievementsWindow(Display display, AchievementsWindowController achievementsWindowController, Shell parentShell) {
		this.display = display;
		this.parentShell = parentShell;
		
		achievementsShell = new Shell(parentShell, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		
		achievementsShell.setText(Main.getLanguage().getContent("Achievements"));
		
		gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.horizontalSpacing = 0;
		gridLayout.verticalSpacing = 0;
		achievementsShell.setLayout(gridLayout);
		
		achievementsShell.setSize(640, 480);
		
		WindowTools.centerShellOnParent(achievementsShell, this.parentShell);
	}
	
	public Shell getAchievementsWindow() {
		return achievementsShell;
	}
	
	public void show() {
		achievementsShell.open();
	}
	
}