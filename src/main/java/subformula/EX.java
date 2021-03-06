package main.java.subformula;

import java.util.ArrayList;
import java.util.List;

import main.java.models.KripkeStructure;
import main.java.models.State;

public class EX implements CTLFormula {
	
	private CTLFormula subFormula;

	public EX(CTLFormula subFormula) {
		this.subFormula = subFormula;
	}
	
	@Override
	public List<State> resolve(KripkeStructure ks) {
		List<State> statesFormula = subFormula.resolve(ks);
		List<State> result = new ArrayList<State>();
		
		for(State s: ks.getStates()) {
			for(State q: ks.getChildrenOf(s)) {
				if(statesFormula.contains(q)) {
					result.add(s);
					break;
				}
			}
		}
		
		return result;
	}
	
	public String toString() {
		return "EX["+subFormula+"]";
	}

}
