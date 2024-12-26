package mcq.java;

public class MyClass {
	public static void main(String[] args) {
		int x, y, z;
		x = 9;
		y = 10;
		z = ++x + y++;
		System.out.println("x: " + x); // 10
		System.out.println("y: " + y); // 11
		System.out.println("z: " + z); // 20
	}

}
