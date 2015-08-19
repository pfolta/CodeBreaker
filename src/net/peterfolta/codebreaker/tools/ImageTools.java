/*
 * CodeBreaker - A java implementation of the popular board game known as Mastermind.
 * Copyright (C) 2015 Peter Folta. All rights reserved.
 *
 * Project:				CodeBreaker
 * Version:				0.0.1
 * Website:				http://www.peterfolta.net/software/codebreaker
 * 
 * File:				ImageTools.java
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

package net.peterfolta.codebreaker.tools;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class ImageTools {
	
	public static Image loadImage(Display display, String filename) {
		Image tmp = null;
		
		try {
			tmp = new Image(display, "res/img/" + filename);
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		
		return tmp;
	}
	
	public static Image resizeImage(Display display, Image img, int width, int height) {
		Image newImage = new Image(display, width, height);
		GC gc = new GC(newImage);
		gc.setAntialias(SWT.ON);
		gc.setInterpolation(SWT.HIGH);
		gc.drawImage(img, 0, 0, img.getBounds().width, img.getBounds().height, 0, 0, width, height);
		gc.dispose();
		img.dispose();
		
		return newImage;
    }
	
	public static Image createHeaderBackground(Display display, Image img, int width, int height) {
		Image newImage = resizeImage(display, img, width, height);
		GC gc = new GC(newImage);
		gc.setAntialias(SWT.ON);
		gc.setInterpolation(SWT.HIGH);
		
		gc.setBackground(new Color(display, 255, 163, 0));
		gc.fillRectangle(0, height - 2, width, height - 1);
		
		gc.dispose();
		img.dispose();
		
		return newImage;
	}

}