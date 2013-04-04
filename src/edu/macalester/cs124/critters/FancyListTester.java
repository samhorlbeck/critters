package edu.macalester.cs124.critters;

public class FancyListTester {
	public static void main(String[] args) {
		FancyList<String> fancy = new FancyList<String>();
		
		fancy.add("test1");
		fancy.add("test2");
		fancy.add("test3");
		fancy.add("test4");
		fancy.add("test5");
		fancy.add("test6");
		
		fancy.reverse();
		System.out.println(fancy);
		
		fancy.shuffle();
		System.out.println(fancy);
	}
}
