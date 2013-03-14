package edu.macalester.cs124.critters;

import java.awt.Color;

import acm.graphics.GCompound;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GPoint;

public class Eye {
    private final GObject graphics;
    private final GObject pupil;
    private final GPoint pupilRestPosition;
    private final double radius;
    
    public static Eye createStandardEye(double x, double y, double r, double pupilSize, double highlightSize, Color iris) {
        GOval white = new GOval(-r, -r, r * 2, r * 2);
        white.setFilled(true);
        white.setFillColor(Color.WHITE);
        
        GCompound pupil = new GCompound();
        
        double pupilR = r * pupilSize;
        GOval pupilMain = new GOval(-pupilR, -pupilR, pupilR * 2, pupilR * 2);
        pupilMain.setFilled(true);
        pupilMain.setFillColor(Color.BLACK);
        pupilMain.setColor(iris);
        pupil.add(pupilMain);
        
        double highlightR = r * highlightSize;
        GOval highlight = new GOval(0, -highlightR * 2, highlightR * 2, highlightR * 2);
        highlight.setColor(new Color(0, 0, 0, 0));
        highlight.setFilled(true);
        highlight.setFillColor(new Color(255, 255, 255, 200));
        pupil.add(highlight);
        
        GCompound group = new GCompound();
        group.add(white);
        group.add(pupil);
        group.setLocation(x, y);
        
        return new Eye(group, pupil, r - pupilR - 2);
    }

    public Eye(GCompound group, GObject pupil, double radius) {
        this.graphics = group;
        this.pupil = pupil;
        pupilRestPosition = pupil.getLocation();
        this.radius = radius;
    }

    public GObject getGraphics() {
        return graphics;
    }
    
    public void lookInDirectionOf(double dx, double dy, double dt) {
        double dist = Math.hypot(dx, dy);
        dx /= dist;
        dy /= dist;
        pupil.setLocation(
            CritterUtils.blend(pupil.getX(), pupilRestPosition.getX() + radius * dx, Math.pow(0.05, dt)),
            CritterUtils.blend(pupil.getY(), pupilRestPosition.getY() + radius * dy, Math.pow(0.05, dt)));
    }
}
