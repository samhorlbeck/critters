package edu.macalester.cs124.critters;

import java.awt.Color;

import acm.graphics.GOval;
import acm.graphics.GPolygon;

public class RoundBug extends Critter {
    
    @Override
    protected void buildGraphics() {
        createLeg(-30,  10, -40,  20);
        createLeg(-34, -10, -44,   0);
        createLeg(-30, -30, -40, -20);
        createLeg( 30,  10,  40,  20);
        createLeg( 34, -10,  44,   0);
        createLeg( 30, -30,  40, -20);
        
        GOval body = new GOval(-25, -25, 50, 50);
        body.setFilled(true);
        body.setFillColor(new Color(158, 103, 12));
        getGraphics().add(body);
        
        addEye(Eye.createStandardEye(-18, 10, 10, 0.46, 0.18, Color.GREEN));
        addEye(Eye.createStandardEye( 18, 10, 10, 0.46, 0.18, Color.GREEN));
    }

    private void createLeg(double x0, double y0, double x1, double y1) {
        GPolygon legPoly = new GPolygon();
        legPoly.setColor(new Color(95, 62, 7));
        legPoly.setFilled(true);
        legPoly.setFillColor(legPoly.getColor());
        
        legPoly.addVertex(0, -2);
        legPoly.addVertex(x0, y0 - 1);
        legPoly.addVertex(x1, y1);
        legPoly.addVertex(x0, y0 + 1);
        legPoly.addVertex(0, 2);
        
        addLeg(new Leg(legPoly, 4));
    }
}
