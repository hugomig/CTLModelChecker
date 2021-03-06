package main.java.subformula;

import java.util.ArrayList;
import java.util.List;

import main.java.models.KripkeStructure;
import main.java.models.State;

public class AP implements CTLFormula {
	
	private String function;
	
	public AP(String function) {
		this.function = function;
	}
	
	@Override
	public List<State> resolve(KripkeStructure ks){
		List<State> verifies = new ArrayList<State>();
		
		for(State s: ks.getStates()) {
			if(ks.getFunctions().containsKey(s)) {
				if(ks.getFunctions().get(s).contains(function)) {
					verifies.add(s);
				}
			}
		}
		
		return verifies;
	}
	
	@Override
	public String toString() {
		return "\""+function+"\"";
	}
}
