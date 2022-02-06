package main.java.service;



import java.io.IOException;
import java.util.List;

import main.java.models.KripkeStructure;
import main.java.models.State;
import main.java.subformula.CTLFormula;

public class ModelChecker {
	
	public static void main(String[] args) throws IOException {
		KripkeStructure ks;
		CTLFormula formula;
		
		if(args.length == 2) {
			System.out.println("Kripke structure and formula readed from input files");
			ks = KripkeStructureReader.readFromFile(args[0]);
			formula = CTLFormulaReader.readFromFile(args[1]);
		}
		else {
			System.out.println("Kripke structure and formula generated randomly");
			ks = KripkeStructureRandomGenerator.generate();
			formula = CTLFormulaRandomGenerator.generate(ks.getAllAP());
		}
		
		System.out.println(ks);
		System.out.println("Formula : "+formula);
		System.out.println();
		
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
