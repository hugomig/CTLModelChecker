package test.java.operators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import main.java.models.KripkeStructure;
import main.java.models.State;
import main.java.subformula.CTLFormula;
import main.java.subformula.AP;

class TestAP {

	private KripkeStructure ks;
	private CTLFormula formula;
	
	@Test
	void apAOnS1() {
		ks = GenerateTestKripkeStructures.generate1();
		formula = new AP("a");
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] { new State("S1")}));
	}
	
	@Test
	void apAOnS1AndS2() {
		ks = GenerateTestKripkeStructures.generate3();
		formula = new AP("a");
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] { new State("S1"), new State("S2")}));
	}
	
	@Test
	void apAOnNoOne() {
		ks = GenerateTestKripkeStructures.generate4();
		formula = new AP("a");
		
		assertEquals(formula.resolve(ks), new ArrayList<State>());
	}

}
