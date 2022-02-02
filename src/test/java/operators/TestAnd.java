package test.java.operators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import main.java.models.KripkeStructure;
import main.java.models.State;
import main.java.subformula.And;
import main.java.subformula.CTLFormula;
import main.java.subformula.AP;

class TestAnd {
	
	private KripkeStructure ks;
	private CTLFormula formula;

	@Test
	void aAndBOnS1() {
		ks = GenerateTestKripkeStructures.generate1();
		formula = new And(new AP("a"), new AP("b"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] { new State("S1")}));
	}
	
	@Test
	void aAndBOnS1AndS2() {
		ks = GenerateTestKripkeStructures.generate5();
		formula = new And(new AP("a"), new AP("b"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] { new State("S1"), new State("S2")}));
	}
	
	@Test
	void aAndBOnNoOne() {
		ks = GenerateTestKripkeStructures.generate2();
		formula = new And(new AP("a"), new AP("b"));
		assertEquals(formula.resolve(ks), new ArrayList<State>());
	}

}
