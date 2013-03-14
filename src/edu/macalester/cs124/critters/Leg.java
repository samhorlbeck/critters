package edu.macalester.cs124.critters;

import acm.graphics.GObject;
import acm.graphics.GPoint;

public class Leg {
    private final GObject graphics;
    private final GPoint restPosition;
    private double rangeOfMotion;
    private boolean anchored;
    
    /**
     * Critters should instantiate legs from their createGraphics() methods.
     * 
     * @param graphics         The visual representation of the leg, positioned at rest.
     * @param rangeOfMotion    How far away from its rest position the leg is allowed to move.
     */
    public Leg(GObject graphics, double rangeOfMotion) {
        this.graphics = graphics;
        this.restPosition = graphics.getLocation();
        this.rangeOfMotion = rangeOfMotion;
    }

    public GObject getGraphics() {
        return graphics;
    }
    
    /**
     * Called after the body has moved to update the leg motion accordingly.
     * This method does not use a particularly convincing leg motion algorithm;
     * low-budgets Saturday morning cartoons would be proud.
     */
    public void bodyMovedBy(double dx, double dy) {
        if(anchored) {
            graphics.move(-dx, -dy);
        } else {
            double speed = Math.hypot(dx, dy),
                   targetX = restPosition.getX() + dx / speed * rangeOfMotion,
                   targetY = restPosition.getY() + dy / speed * rangeOfMotion,
                   toTargetX = targetX - graphics.getX(),
                   toTargetY = targetY - graphics.getY(),
                   distToTarget = Math.hypot(toTargetX, toTargetY);
            graphics.move(
                toTargetX / distToTarget * speed * 1.5,
                toTargetY / distToTarget * speed * 1.5);
        }
        
        double distention = Math.hypot(graphics.getX() - restPosition.getX(), graphics.getY() - restPosition.getY());
        if(distention >= rangeOfMotion)
            anchored = !anchored;
    }
    
    /**
     * An anchored leg roughly retains its current absolute position on the screen.
     * An unanchored leg quickly moves ahead of the current motion.
     */
    public boolean isAnchored() {
        return anchored;
    }

    public void setAnchored(boolean anchored) {
        this.anchored = anchored;
    }
}
