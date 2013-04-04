package edu.macalester.cs124.critters;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.reflections.Reflections;

import acm.program.GraphicsProgram;

public class CritterParade extends GraphicsProgram{
	
	private static final Random rand = new Random();
	
	private FancyList<Critter> fancy;
	private List<Class<? extends Critter>> critterClasses;

	
	public void run() {
		loadCritterClasses();
		fancy = new FancyList<Critter>();
		for(Class<? extends Critter> c : critterClasses) {
			try {
				fancy.add(c.newInstance());
			} catch (Exception e) {
	            throw new RuntimeException("Cannot instantiate " + c, e);
			}
		}
		addFromCritterList();
		pause (5000);
		fancy.reverse();
		addFromCritterList();
		pause (5000);
		fancy.shuffle();
		addFromCritterList();
		
	}
	
	private void addFromCritterList() {
		removeAll();
		for(Critter c : fancy)
			add(c.getGraphics(), fancy.indexOf(c) * 150 + 70, 500);
	}

	
	private Critter createRandomCritter() {
        Class<? extends Critter> critterClass = critterClasses.get(rand.nextInt(critterClasses.size()));
        try {
            return critterClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Cannot instantiate " + critterClass, e);
        }
    }
	
	private void loadCritterClasses() {
        Reflections reflections = new Reflections(getClass().getPackage().getName());
        critterClasses = new ArrayList<Class<? extends Critter>>(
            reflections.getSubTypesOf(Critter.class));
    }
}
