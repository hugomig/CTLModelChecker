package main.java.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import main.java.subformula.AF;
import main.java.subformula.AG;
import main.java.subformula.AP;
import main.java.subformula.AU;
import main.java.subformula.AX;
import main.java.subformula.And;
import main.java.subformula.CTLFormula;
import main.java.subformula.EF;
import main.java.subformula.EG;
import main.java.subformula.EU;
import main.java.subformula.Not;
import main.java.subformula.Or;

public class CTLFormulaRandomGenerator {
	
	private static final List<String> FORMULAS = Arrays.asList(new String[] {
		"NOT",
		"EX",
		"EF",
		"EG",
		"AX",
		"AF",
		"AG",
		"AND",
		"OR",
		"EU",
		"AU",
		"AP"
	});
	
	private static final int MIN_FORMULA = 2;
	private static final int MAX_FORMULA = 5;

	public static CTLFormula generate(List<String> AP) {
		Random rand = new Random();
		int numberOfFormula = MIN_FORMULA + rand.nextInt(MAX_FORMULA - MIN_FORMULA);
		
		return generateFormulaRecursive(AP, numberOfFormula);
	}
	
	public static CTLFormula generateFormulaRecursive(List<String> APs, int numberOfFormula) {
		Random rand = new Random();
		if(numberOfFormula > 1) {
			int formulaIndex = rand.nextInt(FORMULAS.size() - 1);
			switch(FORMULAS.get(formulaIndex)) {
			case "NOT":
				return new Not(generateFormulaRecursive(APs, numberOfFormula-1));
			case "AND":
				return new And(generateFormulaRecursive(APs, numberOfFormula-1), generateFormulaRecursive(APs, numberOfFormula-1));
			case "OR":
				return new Or(generateFormulaRecursive(APs, numberOfFormula-1), generateFormulaRecursive(APs, numberOfFormula-1));
			case "EX":
				return new EF(generateFormulaRecursive(APs, numberOfFormula-1));
			case "EU":
				return new EU(generateFormulaRecursive(APs, numberOfFormula-1), generateFormulaRecursive(APs, numberOfFormula-1));
			case "EF":
				return new EF(generateFormulaRecursive(APs, numberOfFormula-1));
			case "EG":
				return new EG(generateFormulaRecursive(APs, numberOfFormula-1));
			case "AX":
				return new AX(generateFormulaRecursive(APs, numberOfFormula-1));
			case "AU":
				return new AU(generateFormulaRecursive(APs, numberOfFormula-1), generateFormulaRecursive(APs, numberOfFormula-1));
			case "AF":
				return new AF(generateFormulaRecursive(APs, numberOfFormula-1));
			case "AG":
				return new AG(generateFormulaRecursive(APs, numberOfFormula-1));
			}
		}
		String atomic = "a";
		if(APs.size() > 1) {
			atomic = APs.get(rand.nextInt(APs.size()-1));
		}
		return new AP(atomic);
	}
}
