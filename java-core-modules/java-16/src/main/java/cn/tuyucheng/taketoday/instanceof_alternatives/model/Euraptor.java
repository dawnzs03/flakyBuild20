package cn.tuyucheng.taketoday.instanceof_alternatives.model;

public class Euraptor extends Dinosaur {
	// polymorphism
	@Override
	public String move() {
		return "flying";
	}

	// non-polymorphism
	public String flies() {
		return "flying";
	}
}