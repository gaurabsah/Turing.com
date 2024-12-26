package mcq.java;

public class Test {
	public static void main(String[] args) {
		Super s = new Subclass();
		s.foo();
	}

}

class Super {
	void foo() {
		System.out.println("Super");
	}
}

class Subclass extends Super {
	static void foo() {                         // compile-time error because of static
		System.out.println("Subclass");
	}
}
