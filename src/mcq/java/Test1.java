package mcq.java;

public class Test1 {
	public static void main(String[] args) {
		Subclass1 s1 = new Subclass1();
		s1.foo();  // line 7
		
		Super1 s = new Subclass1();
		s.foo(); // line 10
	}

}

class Super1 {
	private void foo() {
		System.out.println("Super");
	}
}

class Subclass1 extends Super1 {
	public void foo() { 
		System.out.println("Subclass");
	}

}
