package mcq.java;

import java.util.Set;
import java.util.TreeSet;

public class TreeSets {
	
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<Integer>();
		set.add(3);
		set.add((int)3.0);
		set.add(2);
		set.add(new Integer(2));
		set.add(Integer.parseInt("2"));
		
		System.out.println(set);
	}

}
