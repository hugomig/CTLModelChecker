package main.java.subformula;

import java.util.ArrayList;
import java.util.List;

import main.java.models.KripkeStructure;
import main.java.models.State;

public class AX implements CTLFormula {
	private CTLFormula subFormula;
	
	public AX(CTLFormula subFormula) {
		this.subFormula = subFormula;
	}
	
	@Override
	public List<State> resolve(KripkeStructure ks){
		List<State> statesFormula = subFormula.resolve(ks);
		List<State> result = new ArrayList<State>(ks.getStates());
		
		for(State s: ks.getStates()) {
			List<State> children = ks.getChildrenOf(s);
			if(children.size() > 0) {
				for(State q: children) {
					if(!statesFormula.contains(q)) {
						result.remove(s);
						break;
					}
				}
			}
			else {
				result.remove(s);
			}
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		return "AX["+subFormula+"]";
	}
}
