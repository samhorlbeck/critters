package edu.macalester.cs124.critters;

import java.awt.Color;

import acm.graphics.GOval;
import acm.graphics.GPolygon;

public class AntBug extends Critter {
	
	@Override
	protected void buildGraphics() {
		createLeg(-40, 0, -80, 40, 0, -2);
		createLeg(40, 0, 80, 40, 0, -2);
		createLeg(-50, -80, -100, 0, 0, -2);
		createLeg(50, -80, 100, 0, 0, -2);
		createLeg(-60, -160, -120, -100, 0, -150);
		createLeg(60, -160, 120, -100, 0, -150);
		
		GOval head = new GOval(-35, -20, 75, 75);
		head.setFilled(true);
		head.setFillColor(Color.BLACK);
		getGraphics().add(head);
		
		GOval body = new GOval(-45, -105, 90, 90);
        body.setFilled(true);
        body.setFillColor(Color.BLACK);
        getGraphics().add(body);
        
        GOval butt = new GOval(-55, -215, 110, 110);
        butt.setFilled(true);
        butt.setFillColor(Color.BLACK);
        getGraphics().add(butt);
        
        addEye(Eye.createStandardEye(-18, 40, 10, 0.46, 0.18, Color.BLUE));
        addEye(Eye.createStandardEye( 18, 40, 10, 0.46, 0.18, Color.RED));
	}

	private void createLeg(double x0, double y0, double x1, double y1, double x2, double y2) {
        GPolygon legPoly = new GPolygon();
        legPoly.setColor(new Color(95, 62, 7));
        legPoly.setFilled(true);
        legPoly.setFillColor(legPoly.getColor());
        
        legPoly.addVertex(x2, y2);
        legPoly.addVertex(x0, y0 - 1);
        legPoly.addVertex(x1, y1);
        legPoly.addVertex(x0, y0 + 1);
//        legPoly.addVertex(0, 2);
        
        addLeg(new Leg(legPoly, 4));
    }
}
