package main.java.subformula;

import java.util.ArrayList;
import java.util.List;

import main.java.models.KripkeStructure;
import main.java.models.State;

public class And implements CTLFormula {
	
	private CTLFormula subFormula1;
	private CTLFormula subFormula2;
	
	public And(CTLFormula subFormula1, CTLFormula subFormula2) {
		this.subFormula1 = subFormula1;
		this.subFormula2 = subFormula2;
	}

	@Override
	public List<State> resolve(KripkeStructure ks) {
		List<State> stateFormula1 = subFormula1.resolve(ks);
		List<State> stateFormula2 = subFormula2.resolve(ks);
		
		List<State> result = new ArrayList<State>();
		for(State s: ks.getStates()) {
			if(stateFormula1.contains(s) && stateFormula2.contains(s)) {
				result.add(s);
			}
		}
		
		return result;
	}
	
}
