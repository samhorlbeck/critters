package edu.macalester.cs124.critters;

import java.awt.Color;

import acm.graphics.GRect;

public class BoxBot extends Critter {
    
    @Override
    protected void buildGraphics() {
        GRect leftLeg  = new GRect(-16, 0, 10, 40);
        leftLeg.setColor(strokeColor);
        leftLeg.setFilled(true);
        leftLeg.setFillColor(fillColor);
        addLeg(new Leg(leftLeg, 2));
        
        GRect rightLeg = new GRect( 6, 0, 10, 40);
        rightLeg.setColor(strokeColor);
        rightLeg.setFilled(true);
        rightLeg.setFillColor(fillColor);
        addLeg(new Leg(rightLeg, 2));
        
        GRect body = new GRect(-20, -30, 40, 40);
        body.setColor(strokeColor);
        body.setFilled(true);
        body.setFillColor(fillColor);
        getGraphics().add(body);
        
        GRect head = new GRect(-18, -56, 36, 20);
        head.setColor(strokeColor);
        head.setFilled(true);
        head.setFillColor(fillColor);
        getGraphics().add(head);
        
        addEye(Eye.createStandardEye(-10, -46, 6, 0.26, 0.18, Color.BLUE));
        addEye(Eye.createStandardEye( 10, -46, 6, 0.26, 0.18, Color.BLUE));
    }

    private static final Color
        strokeColor = new Color(40, 40, 60),
        fillColor   = new Color(160, 172, 182);

}
