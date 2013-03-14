package edu.macalester.cs124.critters;

import java.awt.Color;

import acm.graphics.*;

public class Roomba extends Critter {
    
    @Override
    protected void buildGraphics() {
        GOval topleftLeg  = new GOval(-22, -43, 15, 15);
        topleftLeg.setColor(strokeColor);
        topleftLeg.setFilled(true);
        topleftLeg.setFillColor(wheelColor);
        addLeg(new Leg(topleftLeg, 2));
        
        GOval toprightLeg = new GOval(10, -43, 15, 15);
        toprightLeg.setColor(strokeColor);
        toprightLeg.setFilled(true);
        toprightLeg.setFillColor(wheelColor);
        addLeg(new Leg(toprightLeg, 2));
        
        GOval bottomrightLeg = new GOval(10, 11, 15, 15);
        bottomrightLeg.setColor(strokeColor);
        bottomrightLeg.setFilled(true);
        bottomrightLeg.setFillColor(wheelColor);
        addLeg(new Leg(bottomrightLeg, 2));
        
        GOval bottomleftLeg = new GOval(-22, 11, 15, 15);
        bottomleftLeg.setColor(strokeColor);
        bottomleftLeg.setFilled(true);
        bottomleftLeg.setFillColor(wheelColor);
        addLeg(new Leg(bottomleftLeg, 2));
        
        GOval body = new GOval(-30, -40, 60, 60);
        body.setColor(strokeColor);
        body.setFilled(true);
        body.setFillColor(fillColor);
        getGraphics().add(body);
        
        GOval head = new GOval(-18, -28, 36, 36);
        head.setColor(strokeColor);
        head.setFilled(true);
        head.setFillColor(fillColor);
        getGraphics().add(head);
        
        addEye(Eye.createStandardEye(-9, -12, 6, 0.26, 0.18, Color.BLUE));
        addEye(Eye.createStandardEye( 9, -12, 6, 0.26, 0.18, Color.BLUE));
    }

    private static final Color
        strokeColor = new Color(40, 40, 60),
        fillColor   = new Color(135, 206, 250),
    	wheelColor = new Color(0,0,0);

}
