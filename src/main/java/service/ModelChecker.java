package main.java.service;



import java.io.IOException;
import java.util.List;

import main.java.models.KripkeStructure;
import main.java.models.State;
import main.java.subformula.CTLFormula;
import main.java.subformula.Not;
import main.java.subformula.True;

public class ModelChecker {
	
	public static void main(String[] args) throws IOException {
		KripkeStructure ks = KripkeStructureReader.readFromFile(args[0]);		
		System.out.println(ks);
		
		True test = new True("a");
		System.out.println(test.resolve(ks));
		
		Not test2 = new Not(test);
		System.out.println(test2.resolve(ks));
		
		CTLFormula verify = CTLFormulaReader.readFromFile(args[1]);
		List<State> states = verify.resolve(ks);
		
		System.out.println(states);
		
		if(states.contains(ks.getInitialState())) {
			System.out.println("This Kripke Structure verifies this CTL formula");
		}
		else {
			System.out.println("This Kripke Structure does'nt verify this CTL formula");
		}
	}
	
}
