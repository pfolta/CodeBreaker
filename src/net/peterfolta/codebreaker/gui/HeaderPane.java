/*
 * CodeBreaker - A java implementation of the popular board game known as Mastermind.
 * Copyright (C) 2015 Peter Folta. All rights reserved.
 *
 * Project:				CodeBreaker
 * Version:				0.0.1
 * Website:				http://www.peterfolta.net/software/codebreaker
 * 
 * File:				HeaderPane.java
 * Created:				2015/8/17
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

package net.peterfolta.codebreaker.gui;

import net.peterfolta.codebreaker.tools.ImageTools;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;

public class HeaderPane extends Composite {
	
	private Display display;
	
	private GridLayout gridLayout;
	private GridData mainGridData;
	private GridData gridData;
	
	private Label headerIcon;
	private Label headerTitle;
	private Label headerDescription;

	public HeaderPane(Display display, Composite parent, int style, String icon, String title) {
		this(display, parent, style, icon, title, new String[] { "" });
	}
	
	public HeaderPane(Display display, Composite parent, int style, String icon, String title, String[] descriptions) {
		super(parent, style);
		
		this.display = display;
		
		gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.horizontalSpacing = 20;
		gridLayout.verticalSpacing = 0;
		gridLayout.marginBottom = 24;
		gridLayout.marginTop = 20;
		gridLayout.marginLeft = 20;
		
		int[] tmpint = new int[descriptions.length];
		
		for(int i = 0; i < descriptions.length; i++) {
			tmpint[i] = descriptions[i].length();
		}
		
		int max = 0;
		
		mainGridData = new GridData(GridData.FILL_HORIZONTAL);
		mainGridData.minimumWidth = 400;
		
		this.setBackgroundMode(SWT.INHERIT_DEFAULT);
		this.setLayout(gridLayout);
		this.setLayoutData(mainGridData);

		gridData = new GridData();
		gridData.verticalSpan = 2;
		
		headerIcon = new Label(this, SWT.NONE);
		headerIcon.setImage(ImageTools.loadImage(display, icon));
		headerIcon.setLayoutData(gridData);
		
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		
		headerTitle = new Label(this, SWT.NONE);
		headerTitle.setText(title);
		headerTitle.setForeground(new Color(display, 255, 255, 255));
		headerTitle.setFont(new Font(display, headerTitle.getFont().getFontData()[0].getName(), headerTitle.getFont().getFontData()[0].getHeight() + 10, SWT.BOLD));
		headerTitle.setLayoutData(gridData);
		
		gridData = new GridData(GridData.FILL_HORIZONTAL);
	//	gridData.horizontalIndent = 20;
		
		headerDescription = new Label(this, SWT.NONE);
		headerDescription.setText(descriptions[max]);
		headerDescription.setForeground(new Color(display, 255, 255, 255));
		headerDescription.setLayoutData(gridData);
		
		int width = headerDescription.computeSize(SWT.DEFAULT, SWT.DEFAULT).x + 48 + 40 + 20 + 20;
		
		if(width > mainGridData.minimumWidth) {
			mainGridData.minimumWidth = width;
		}
		
		parent.addListener(SWT.Resize, new Listener() {
			public void handleEvent(Event event) {
				try {
					setBackgroundImage();					
				} catch(Exception exception) {
					
				}
			}
		});
	}
	
	public void setBackgroundImage() {
		super.setBackgroundImage(ImageTools.createHeaderBackground(display, ImageTools.loadImage(display, "header.png"), this.getSize().x, this.getSize().y));
	}
	
	public void setIcon(String icon) {
		headerIcon.setImage(ImageTools.loadImage(display, icon));
	}
	
	public void setTitle(String title) {
		headerTitle.setText(title);
	}
	
	public void setDescription(String description) {
		headerDescription.setText(description);
	}

}