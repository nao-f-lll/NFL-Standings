package com.standings.model;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JCheckBox;

public class CustomCheckBox extends JCheckBox {

	private static final long serialVersionUID = -7104751621123160976L;
	private final int border = 4;
	
	public CustomCheckBox() {
		
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setOpaque(false);
		setBackground(new Color(69, 124, 235));
		setFocusable(false);
		
	}
	
	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int yCordinate = (getHeight() - 16 ) / 2;
		if (isSelected()) {
			if (isEnabled()) {
				graphics2d.setColor(getBackground());
			} else {
				graphics2d.setColor(Color.GREEN);
			}
			
			graphics2d.fillRoundRect(1, yCordinate, 16, 16, border, border);
			
			int px[] = {4, 8, 14, 12, 8 ,6};
			int py[] = {yCordinate + 8, yCordinate + 14, yCordinate + 5, yCordinate + 3, yCordinate + 10, yCordinate + 6};
			graphics2d.setColor(Color.WHITE);
			graphics2d.fillPolygon(px, py, px.length);
			
		} else {
			graphics2d.setColor(Color.GRAY);
			graphics2d.fillRoundRect(1, yCordinate, 16, 16, border, border);
			graphics2d.setColor(Color.WHITE);
			graphics2d.fillRoundRect(2, yCordinate + 1, 14, 14, border, border);
			
		}
	}
}
