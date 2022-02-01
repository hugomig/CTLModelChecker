package main.java.models;

public class State {
	final String name;

	public State(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "State: " + name;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o.getClass() == String.class) {
			String compare = (String) o;
			return name.equals(compare);
		}
		else if(o.getClass() == State.class) {
			State compare = (State) o;
			return name.equals(compare.getName());
		}
		else {
			return false;
		}
	}
}
