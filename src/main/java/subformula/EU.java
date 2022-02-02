package main.java.subformula;

import java.util.ArrayList;
import java.util.List;

import main.java.models.KripkeStructure;
import main.java.models.State;

public class EU implements CTLFormula{
	
	private CTLFormula subFormula1;
	private CTLFormula subFormula2;
	
	public EU(CTLFormula subFormula1, CTLFormula subFormula2) {
		this.subFormula1 = subFormula1;
		this.subFormula2 = subFormula2;
	}

	@Override
	public List<State> resolve(KripkeStructure ks) {
		
		List<State> stateFormula1 = subFormula1.resolve(ks);
		List<State> stateFormula2 = subFormula2.resolve(ks);
		
		List<State> result = new ArrayList<State>();
		
		for(State s : stateFormula1)
		{
			List<State> stateFormula1Copy = new ArrayList<State>(stateFormula1);
			
			if(verify(s, ks, stateFormula1, stateFormula2, stateFormula1Copy))
			{
				result.add(s);
			}
		}
		
		return result;
	}
	
	public boolean verify(State s, KripkeStructure ks, List<State> l1, List<State> l2, List<State> l1Copy)
	{
		if(l1Copy.contains(s))
		{
			l1Copy.remove(s);
			for(State st : ks.getChildrenOf(s))
			{	
				 if(l2.contains(st))
				{
					 return true;
				}
				if(l1.contains(st))
				{
					if(verify(st, ks, l1, l2, l1Copy)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public String toString() {
		return "E["+subFormula1+"]U["+subFormula2+"]";
	}

}
