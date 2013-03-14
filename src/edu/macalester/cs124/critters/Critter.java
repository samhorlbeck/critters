package edu.macalester.cs124.critters;

import java.util.ArrayList;
import java.util.List;

import acm.graphics.GCompound;
import acm.graphics.GPoint;

public abstract class Critter {
    private final GCompound graphics;
    private double speed;
    private List<Eye> eyes;
    private List<Leg> legs;
    private GPoint goal;
    
    public Critter() {
        eyes = new ArrayList<Eye>();
        legs = new ArrayList<Leg>();
        graphics = new GCompound();
        buildGraphics();
    }

    public GCompound getGraphics() {
         return graphics;
    }

    protected abstract void buildGraphics();

    public double getSize() {
        return Math.hypot(getGraphics().getWidth(), getGraphics().getHeight());
    }

    public double getSpeed() {
        return speed;
    }
    
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
    public GPoint getGoal() {
        return goal;
    }

    public void setGoal(GPoint goal) {
        this.goal = goal;
    }

    public void moveTowardsGoal(double dt) {
        double dx = goal.getX() - getGraphics().getX(),
               dy = goal.getY() - getGraphics().getY(),
               dist = Math.hypot(dx, dy);
        moveBy(
            dx * getSpeed() / dist,
            dy * getSpeed() / dist,
            dt);
    }

    public void moveBy(double dx, double dy, double dt) {
        graphics.move(dx * dt, dy * dt);
        
        for(Eye eye : eyes)
            eye.lookInDirectionOf(dx, dy, dt);
        
        for(Leg leg : legs)
            leg.bodyMovedBy(dx * dt, dy * dt);
    }
    
    protected void addLeg(Leg leg) {
        getGraphics().add(leg.getGraphics());
        legs.add(leg);
        leg.setAnchored(legs.size() % 2 == 0);
    }

    protected void addEye(Eye eye) {
        getGraphics().add(eye.getGraphics());
        eyes.add(eye);
    }
}
