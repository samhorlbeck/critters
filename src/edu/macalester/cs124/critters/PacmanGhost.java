package edu.macalester.cs124.critters;

import java.awt.Color;
import java.util.Random;

import acm.graphics.GArc;
import acm.graphics.GCompound;
import acm.graphics.GOval;
import acm.graphics.GPolygon;

public class PacmanGhost extends Critter {
    
	private Color bodyColor;
	private Random rand;
	
    @Override
    protected void buildGraphics() {
    	rand = new Random();
    	chooseColor();
    	
        createLeg(-27);
        createLeg(-9);
        createLeg(9);
        
        GCompound body = new GCompound();
        GOval topHalf = new GOval(-25, -25, 50, 50);
        topHalf.setFilled(true);
        topHalf.setColor(bodyColor);
        topHalf.setFillColor(bodyColor);
        body.add(topHalf);
        GPolygon bottomHalf = new GPolygon();
        bottomHalf.addVertex(0, 0);
        bottomHalf.addVertex(-2, 30);
        bottomHalf.addVertex(52, 30);
        bottomHalf.addVertex(50, 0);
        bottomHalf.setFilled(true);
        bottomHalf.setColor(bodyColor);
        bottomHalf.setFillColor(bodyColor);
        bottomHalf.setLocation(-25, 0);
        body.add(bottomHalf);
        getGraphics().add(body);
        
        addEye(Eye.createStandardEye(-12, 2, 8, 0.46, 0.18, Color.BLUE));
        addEye(Eye.createStandardEye( 12, 2, 8, 0.46, 0.18, Color.BLUE));
    }

    private void createLeg(double x) {
    	GArc legArc = new GArc(x, 19, 18, 20, 180, 180);
    	legArc.setFillColor(bodyColor);
    	legArc.setColor(bodyColor);
    	legArc.setFilled(true);
    	addLeg(new Leg(legArc, 1));
//        GPolygon legPoly = new GPolygon();
//        legPoly.setColor(new Color(95, 62, 7));
//        legPoly.setFilled(true);
//        legPoly.setFillColor(legPoly.getColor());
//        
//        legPoly.addVertex(0, -2);
//        legPoly.addVertex(x0, y0 - 1);
//        legPoly.addVertex(x1, y1);
//        legPoly.addVertex(x0, y0 + 1);
//        legPoly.addVertex(0, 2);
//        
//        addLeg(new Leg(legPoly, 4));
    }
    
    private void chooseColor() {
    	switch(rand.nextInt(4)) {
    	case 0:
    		bodyColor = Color.red;
    		break;
    	case 1:
    		bodyColor = Color.orange;
    		break;
    	case 2:
    		bodyColor = Color.cyan;
    		break;
    	case 3:
    		bodyColor = Color.pink;
    		break;
    	}
    }
}
