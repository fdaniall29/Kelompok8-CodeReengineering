public class Main {
	public static void main(String[] args) {
		mercedes Mercedes = new mercedes();
		ducati Ducati = new ducati();
		
		Mercedes.stock();
		Mercedes.model();
		Mercedes.color();
		System.out.println(" ");
		Ducati.stock();
		Ducati.model();
		Ducati.color();
		Ducati.cylinderCapacity();
	}
	
}

abstract class vehicle{
	abstract void model();
	abstract void color();
	public void stock() {
		System.out.println("available");
	}
}

abstract class motorcycle{
	abstract void model();
	abstract void color();
	public void stock() {
		System.out.println("available");
	}
	abstract void cylinderCapacity();\
}

class mercedes extends vehicle{
	public void model() {
		System.out.println("e320");
	}
	public void color() {
		System.out.println("silver");
	}
}

class ducati extends motorcycle{
	public void model() {
		System.out.println("v4S");
	}
	public void color() {
		System.out.println("red");
	}
	public void cylinderCapacity() {
		System.out.println("1103cc");
	}
}