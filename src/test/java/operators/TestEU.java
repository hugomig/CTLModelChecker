package test.java.operators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import main.java.models.KripkeStructure;
import main.java.models.State;
import main.java.subformula.AP;
import main.java.subformula.And;
import main.java.subformula.CTLFormula;
import main.java.subformula.EU;

class TestEU {

	private KripkeStructure ks;
	private CTLFormula formula;
	
	@Test
	void EaUb1() {
		ks = GenerateTestKripkeStructures.generate1();
		formula = new EU(new AP("b"), new AP("b"));
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] { new State("S1")}));
	}
	
	@Test
	void EaUc2() {
		ks = GenerateTestKripkeStructures.generate2();
		formula = new EU(new AP("a"), new AP("c"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] { }));
	}
}
