package main.java.service;



import java.io.IOException;
import java.util.List;

import main.java.models.KripkeStructure;
import main.java.models.State;
import main.java.subformula.CTLFormula;

public class ModelChecker {
	
	public static void main(String[] args) throws IOException {
		KripkeStructure ks = KripkeStructureReader.readFromFile(args[0]);		
		System.out.println(ks);
		
		CTLFormula formula = CTLFormulaReader.readFromFile(args[1]);
		System.out.println(formula);
		
		checkIfKripkeVerifyFormula(ks, formula);
	}
	
	public static void checkIfKripkeVerifyFormula(KripkeStructure ks, CTLFormula formula) {
		List<State> states = formula.resolve(ks);
		
		if(states.contains(ks.getInitialState())) {
			System.out.println("This Kripke Structure verifies this CTL formula");
		}
		else {
			System.out.println("This Kripke Structure does'nt verify this CTL formula");
		}
	}
	
}
