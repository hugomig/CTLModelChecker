package main.java.subformula;

import java.util.ArrayList;
import java.util.List;

import main.java.models.KripkeStructure;
import main.java.models.State;

public class EG implements CTLFormula {

	private CTLFormula subFormula;
	
	public EG(CTLFormula subFormula) {
		this.subFormula = subFormula;
	}
	
	@Override
	public List<State> resolve(KripkeStructure ks) {
		List<State> stateFormula = subFormula.resolve(ks);
		List<State> result = new ArrayList<State>();
		
		for(State s: ks.getStates()) {
			if(verify(ks, s, stateFormula)) {
				result.add(s);
			}
		}
		
		return result;
	}
	
	public boolean verify(KripkeStructure ks, State s, List<State> verified) {
		return verify(ks, s, verified, new ArrayList<State>());
	}
	
	public boolean verify(KripkeStructure ks, State s, List<State> verified, List<State> checking) {
		checking.add(s);
		if(verified.contains(s)) {
			List<State> children = ks.getChildrenOf(s);
			if(children.size() > 0) {
				for(State q: children) {
					if(checking.contains(q)) {
						return true;
					}
					if(verify(ks, q, verified, checking)) {
						return true;
					}
				}
			}
			else {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "EG["+subFormula+"]";
	}

}
