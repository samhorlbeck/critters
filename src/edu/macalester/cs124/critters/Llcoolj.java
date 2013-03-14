package edu.macalester.cs124.critters;

import java.awt.Color;
import java.io.IOException;

import javax.imageio.ImageIO;

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.graphics.GImage;

public class Llcoolj extends Critter{
	
	@Override
	protected void buildGraphics() {
		
		GRect leftLeg  = new GRect(35, 200, 35, 150);
        leftLeg.setColor(strokeColor);
        leftLeg.setFilled(true);
        leftLeg.setFillColor(strokeColor);
        addLeg(new Leg(leftLeg, 2));
        
        GRect rightLeg  = new GRect(75, 200, 35, 150);
        rightLeg.setColor(strokeColor);
        rightLeg.setFilled(true);
        rightLeg.setFillColor(strokeColor);
        addLeg(new Leg(rightLeg, 2));
        
       
		GImage LlcoolJ = null;
		try {
			LlcoolJ = new GImage(ImageIO.read(getClass().getResource("/LLCOOLJ.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		getGraphics().add(LlcoolJ);
		
		
		addEye(Eye.createStandardEye(95, 20, 10, 0.26, 0.18, Color.RED));
		addEye(Eye.createStandardEye(110, 30, 10, 0.26, 0.18, Color.RED));
		
		
	}
	
	
	private static final Color		
		strokeColor = new Color(0, 0, 0),
		fillColor = new Color(100, 0,0);
}
