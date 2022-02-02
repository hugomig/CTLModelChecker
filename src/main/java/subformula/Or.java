package main.java.subformula;

import java.util.ArrayList;
import java.util.List;

import main.java.models.KripkeStructure;
import main.java.models.State;

public class Or implements CTLFormula {
	
	private CTLFormula subFormula1;
	private CTLFormula subFormula2;

	public Or(CTLFormula subFormula1, CTLFormula subFormula2) {
		this.subFormula1 = subFormula1;
		this.subFormula2 = subFormula2;
	}
	
	@Override
	public List<State> resolve(KripkeStructure ks) {
		List<State> subFormulaStates1 = subFormula1.resolve(ks);
		List<State> subFormulaStates2 = subFormula2.resolve(ks);
		
		List<State> result = new ArrayList<State>(subFormulaStates1);
		for(State s: subFormulaStates2) {
			if(!result.contains(s)) {
				result.add(s);
			}
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		return "["+subFormula1+"] OR ["+subFormula2+"]";
	}

}
