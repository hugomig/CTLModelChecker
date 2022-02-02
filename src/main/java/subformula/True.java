package main.java.subformula;

import java.util.ArrayList;
import java.util.List;

import main.java.models.KripkeStructure;
import main.java.models.State;

public class True implements CTLFormula {
	
	private String function;
	
	public True(String function) {
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
}
