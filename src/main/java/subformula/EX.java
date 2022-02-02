package main.java.subformula;

import java.util.ArrayList;
import java.util.List;

import main.java.models.KripkeStructure;
import main.java.models.State;

public class EX implements CTLFormula{
	
	private CTLFormula subFormula;

	public EX(CTLFormula subFormula) 
	{
		this.subFormula = subFormula;
	}

	@Override
	public List<State> resolve(KripkeStructure ks) {
		
		List<State> stateFormula = subFormula.resolve(ks);
		List<State> result = new ArrayList<State>();
		
		for( State s : ks.getStates())
		{
			List<State> states = ks.getAllSuccessor(s);
			states.add(s);
			for(State q : states)
			{
				if(stateFormula.contains(q))
				{
					result.add(s);
				}
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "EX [" + subFormula + "]";
	}
}
