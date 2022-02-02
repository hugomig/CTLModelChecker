package main.java.subformula;

import java.util.ArrayList;
import java.util.List;

import main.java.models.KripkeStructure;
import main.java.models.State;

public class Not implements CTLFormula {
	
	private CTLFormula formula;
	
	public Not(CTLFormula formula) {
		this.formula = formula;
	}

	@Override
	public List<State> resolve(KripkeStructure ks) {
		List<State> verifies = new ArrayList<State>();
		
		List<State> verifyFormula = formula.resolve(ks);
		for(State s: ks.getStates()) {
			if(!verifyFormula.contains(s)) {
				verifies.add(s);
			}
		}
		
		return verifies;
	}
	
	@Override
	public String toString() {
		return "NOT["+formula+"]";
	}
	
}
