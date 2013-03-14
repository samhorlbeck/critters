package edu.macalester.cs124.critters;

import java.awt.Color;

import java.util.Random;

import acm.graphics.GOval;
import acm.graphics.GArc;


public class LadybugBot extends Critter{
	
	@Override
	protected void buildGraphics() {
		
		createLeg(-25,  30);
        createLeg(-34, 0);
        createLeg(-25, -20);
        createLeg( 30,  30);
        createLeg( 40, 0);
        createLeg( 30, -20);
		
		GOval body = new GOval(-25, -25, 70, 80);
		body.setFilled(true);
        body.setFillColor(Color.RED);
        getGraphics().add(body);
        
		createSpot(body, 18, 9);
        createSpot(body, 10, 26);
        createSpot(body, 15, 43);
        createSpot(body, 41, 9);
        createSpot(body, 45, 26);
        createSpot(body, 43, 43);
		
        GOval head = new GOval(-10, 30, 40, 30);
        head.setFilled(true);
        head.setFillColor(Color.GRAY);
        getGraphics().add(head);
        
        addEye(Eye.createStandardEye( 0, 45, 10, 0.46, 0.18, Color.BLACK));
        addEye(Eye.createStandardEye( 20, 45, 10, 0.46, 0.18, Color.BLACK));
        
        createAntenna(20, 25, 40, 120);
        createAntenna(0, 20, 40, 130);
	}
	
	
	private void createSpot(GOval body, double xdist, double ydist) {
		Random rand = new Random();
		double size = rand.nextInt(6);
		double xcor = body.getX();
		double ycor = body.getY();
		GOval spot = new GOval(10 + size, 10 + size);
		spot.setFilled(true);
		spot.setFillColor(Color.BLACK);
		spot.setLocation(xcor + xdist, ycor + ydist);
		getGraphics().add(spot);
	}
	
	private void createLeg(double x, double y) {
        GOval legOval = new GOval(15, 15);
        legOval.setFilled(true);
        legOval.setFillColor(Color.BLACK);
        legOval.setLocation(x,y);
        
        addLeg(new Leg(legOval, 4));
    }
	
	private void createAntenna(double x, double y, double start, double sweep) {
		GArc antenna = new GArc(x, y, 50, 30, start, sweep);
        antenna.setFilled(false);
        antenna.getEndPoint();
        
        GOval antennaTop = new GOval(x+40, y+5, 6, 6);
        antennaTop.setFilled(true);
        antennaTop.setFillColor(Color.BLACK);
        
        getGraphics().add(antennaTop);
        getGraphics().add(antenna);
	}
}
