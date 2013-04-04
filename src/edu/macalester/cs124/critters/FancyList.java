package edu.macalester.cs124.critters;

import java.util.LinkedList;
import java.util.Random;

public class FancyList<Object> extends LinkedList<Object> implements ListUtils{

	private static final Random rand = new Random();
	
	@Override
	public void reverse() {
		LinkedList<Object> temp = new LinkedList<Object>();
		for(Object obj : this) {
			temp.add(0, obj);
		}
		clear();
		addAll(temp);
	}

	@Override
	public void shuffle() {
		LinkedList<Object> temp = new LinkedList<Object>();
		int size = size();
		for(int i = 0; i < size; i++) {
			int randInt = rand.nextInt(size());
			temp.add(get(randInt));
			remove(randInt);
		}
		clear();
		addAll(temp);
	}

}
