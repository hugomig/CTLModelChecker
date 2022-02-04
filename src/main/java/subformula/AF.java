package main.java.subformula;

import java.util.ArrayList;
import java.util.List;

import main.java.models.KripkeStructure;
import main.java.models.State;

public class AF implements CTLFormula {

	private CTLFormula subFormula;
	
	public AF(CTLFormula subFormula) {
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
	
	public boolean verify(KripkeStructure ks, State s, List<State> verifies) {
		return verify(ks, s, verifies, new ArrayList<State>());
	}
	
	public boolean verify(KripkeStructure ks, State s, List<State> verifies, List<State> checking) {
		checking.add(s);
		List<State> children = ks.getChildrenOf(s);
		if(children.size() < 1) {
			return false;
		}
		for(State q: children) {
			if(!verifies.contains(q)) {
				if(!checking.contains(q)) {
					if(!verify(ks, q, verifies, checking)) {
						return false;
					}
				}
				else {
					boolean findVerif = false;
					for(State p: ks.getAllSuccessor(q)) {
						if(verifies.contains(p)) {
							findVerif = true;
							break;
						}
					}
					if(!findVerif) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "AF["+subFormula+"]";
	}

}
