package main.java.subformula;

import java.util.ArrayList;
import java.util.List;

import main.java.models.KripkeStructure;
import main.java.models.State;

public class EX implements CTLFormula{
	
	private CTLFormula subFormula;

	@Override
	public List<State> resolve(KripkeStructure ks) {
		
		List<State> stateFormula = subFormula.resolve(ks);
		
		for( State s : ks.getStates())
		{
			for(State q : ks.getAllSuccessor(s))
			{
				if(stateFormula.contains(q))
				{
					
				}
			}
		}
		
		List<State> result = new ArrayList<State>();
		return result;
	}

}
