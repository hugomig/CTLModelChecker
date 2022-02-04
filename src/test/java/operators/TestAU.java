package test.java.operators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import main.java.models.KripkeStructure;
import main.java.models.State;
import main.java.subformula.AP;
import main.java.subformula.AU;
import main.java.subformula.CTLFormula;
import main.java.subformula.EU;

class TestAU {

	private KripkeStructure ks;
	private CTLFormula formula;
	
	@Test
	void AbUcOnS1S2() {
		ks = GenerateTestKripkeStructures.generate1();
		formula = new AU(new AP("b"), new AP("c"));
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] { new State("S1"), new State("S2")}));
	}
	
	@Test
	void AaUcOnNoOne() {
		ks = GenerateTestKripkeStructures.generate2();
		formula = new AU(new AP("a"), new AP("c"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] { }));
	}
	
	@Test
	void AaUbOnS3S4WithLoop() {
		ks = GenerateTestKripkeStructures.generate7();
		formula = new AU(new AP("a"), new AP("b"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] { }));
	}

}
