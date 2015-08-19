/*
 * CodeBreaker - A java implementation of the popular board game known as Mastermind.
 * Copyright (C) 2015 Peter Folta. All rights reserved.
 *
 * Project:				CodeBreaker
 * Version:				0.0.1
 * Website:				http://www.peterfolta.net/software/codebreaker
 * 
 * File:				ProfileWindow.java
 * Created:				2015/8/15
 * Last modified:		2015/8/17
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

package net.peterfolta.codebreaker.gui.profilewindow;

import net.peterfolta.codebreaker.controllers.gui.ProfileWindowController;
import net.peterfolta.codebreaker.gui.HeaderPane;
import net.peterfolta.codebreaker.tools.WindowTools;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class ProfileWindow {
	
	private Display display;
	private Shell parentShell;
	
	private Shell profileShell;
	
	private GridLayout gridLayout;
	private GridData gridData;
	
	private HeaderPane headerPane;
	
	private Composite contentComposite;
	
	private TabFolder tabFolder;
	private TabItem profileTabItem;
	private TabItem statisticsTabItem;
	private TabItem achievementsTabItem;
	
	private Composite buttonComposite;
	private Button okButton;
	private Button cancelButton;
	
	public ProfileWindow(Display display, ProfileWindowController achievementsWindowController, Shell parentShell) {
		this.display = display;
		this.parentShell = parentShell;
		
		profileShell = new Shell(parentShell, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.SHEET);
		
		gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.horizontalSpacing = 0;
		gridLayout.verticalSpacing = 0;
		profileShell.setLayout(gridLayout);
		
		headerPane = new HeaderPane(display, profileShell, SWT.NONE, "general_48x48.png", "Profile", new String[] { "Description", "Desc2" });
		
		gridLayout = new GridLayout();
		gridLayout.marginHeight = 10;
		gridLayout.marginWidth = 10;
		
		gridData = new GridData(GridData.FILL_BOTH);
		
		contentComposite = new Composite(profileShell, SWT.NONE);
		contentComposite.setLayout(gridLayout);
		contentComposite.setLayoutData(gridData);
		
		tabFolder = new TabFolder(contentComposite, SWT.NONE);
		tabFolder.setLayoutData(gridData);
		tabFolder.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				switch(tabFolder.getSelectionIndex()) {
				case 0:
					headerPane.setIcon("profile.png");
					headerPane.setTitle("Profile");
					headerPane.setDescription("Profile Desc");
					break;
				case 1:
					headerPane.setIcon("statistics.png");
					headerPane.setTitle("Statistics");
					headerPane.setDescription("Statistics Description");
					break;
				case 2:
					headerPane.setIcon("statistics.png");
					headerPane.setTitle("Achievements");
					headerPane.setDescription("Achievements Pane");
					break;
				}
			}
		});
		
		profileTabItem = new TabItem(tabFolder, SWT.NONE);
		profileTabItem.setText("Profile");
		
		statisticsTabItem = new TabItem(tabFolder, SWT.NONE);
		statisticsTabItem.setText("Statistics");
		
		achievementsTabItem = new TabItem(tabFolder, SWT.NONE);
		achievementsTabItem.setText("Achievements");
		
		gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.makeColumnsEqualWidth = true;
		gridLayout.marginTop = 10;
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.RIGHT;
		
		buttonComposite = new Composite(contentComposite, SWT.NONE);
		buttonComposite.setLayout(gridLayout);
		buttonComposite.setLayoutData(gridData);
		
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.minimumWidth = 75;
		
		okButton = new Button(buttonComposite, SWT.PUSH);
		okButton.setText("OK");
		okButton.setLayoutData(gridData);
		okButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
			}
		});
		
		cancelButton = new Button(buttonComposite, SWT.PUSH);
		cancelButton.setText("Cancel");
		cancelButton.setLayoutData(gridData);
		cancelButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
			}
		});
		
		profileShell.setDefaultButton(okButton);
		cancelButton.setFocus();
		
		profileShell.setSize(800, 600);
		
		WindowTools.centerShellOnParent(profileShell, this.parentShell);
	}
	
	public Shell getProfileWindow() {
		return profileShell;
	}
	
	public void show() {
		headerPane.setBackgroundImage();
		
		profileShell.open();
	}
	
}