package mcq.java;

import java.util.Set;
import java.util.TreeSet;

public class Sets {
	
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<Integer>();
		set.add(3);
		set.add(2);
		set.add("abc");   // compile-time error
		
		System.out.println(set);  
	}

}
