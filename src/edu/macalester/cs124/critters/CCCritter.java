package edu.macalester.cs124.critters;

import java.awt.Color;

import acm.graphics.GOval;
import acm.graphics.GPolygon;

public class CCCritter extends Critter {
    
    @Override
    protected void buildGraphics() {
        createLeg(-30,  10, -40,  20);
        createLeg(-34, -10, -44,   0);
        createLeg(-30, -30, -40, -20);
        createLeg( 30,  10,  40,  20);
        createLeg( 34, -10,  44,   0);
        createLeg( 30, -30,  40, -20);
        createLeg(-26,  14, -36,  24); //
        createLeg(-30, -6, -40,   4);
        createLeg(-26, -26, -36, -16);
        createLeg( 34,  14,  44,  24);
        createLeg( 38, -6,  48,   4);
        createLeg( 34, -26,  44, -16);
        createLeg(-34,  6, -44,  16); //
        createLeg(-38, -14, -48,  -4);
        createLeg(-34, -34, -44, -24);
        createLeg( 26,  6,  36,  16);
        createLeg( 30, -14,  40,   -4);
        createLeg( 26, -34,  36, -24);
        
        createTail();

        
        GOval body = new GOval(-25, -25, 50, 50);
        body.setFilled(true);
        body.setFillColor(new Color(0, 0, 0));
        getGraphics().add(body);
        
        addEye(Eye.createStandardEye(-18, 10, 10, 0.46, 0.18, Color.RED));
        addEye(Eye.createStandardEye( 18, 10, 10, 0.46, 0.18, Color.RED));
        addEye(Eye.createStandardEye( 4, -75, 4, 2.3, .9, Color.RED));

    }

    private void createLeg(double x0, double y0, double x1, double y1) {
        GPolygon legPoly = new GPolygon();
        legPoly.setColor(new Color(255, 0, 0));
        legPoly.setFilled(true);
        legPoly.setFillColor(legPoly.getColor());
        
        legPoly.addVertex(0, -2);
        legPoly.addVertex(x0, y0 - 1);
        legPoly.addVertex(x1, y1);
        legPoly.addVertex(x0, y0 + 1);
        legPoly.addVertex(0, 2);
        
        addLeg(new Leg(legPoly, 4));
    }
    
    private void createTail() {
        GPolygon tailPoly = new GPolygon();
        tailPoly.setColor(Color.black);
        tailPoly.setFilled(true);
        tailPoly.setFillColor(Color.gray);
        
        tailPoly.addVertex(0, -10);
        tailPoly.addVertex(-100, -110);
        tailPoly.addVertex(-50, -85);
        tailPoly.addVertex(0, -110);
        tailPoly.addVertex(50, -85);
        tailPoly.addVertex(100, -110);
        tailPoly.addVertex(0, -10);
        
        addLeg(new Leg(tailPoly, 1));
    }
}
