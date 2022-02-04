package main.java.subformula;

import java.util.ArrayList;
import java.util.List;

import main.java.models.KripkeStructure;
import main.java.models.State;

public class AG implements CTLFormula {

	private CTLFormula subFormula;
	
	public AG(CTLFormula subFormula) {
		this.subFormula = subFormula;
	}
	
	@Override
	public List<State> resolve(KripkeStructure ks) {
		List<State> stateFormula = subFormula.resolve(ks);
		List<State> dont = new ArrayList<State>(ks.getStates());
		List<State> result = new ArrayList<State>(ks.getStates());
		
		for(State s: stateFormula) {
			dont.remove(s);
		}
		
		for(State s: ks.getStates()) {
			if(dont.contains(s)) {
				result.remove(s);
			}
			else {
				for(State q: ks.getAllSuccessor(s)) {
					if(dont.contains(q)) {
						result.remove(s);
						break;
					}
				}
			}
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		return "AG["+subFormula+"]";
	}

}
