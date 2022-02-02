package test.java.operators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import main.java.models.KripkeStructure;
import main.java.models.State;
import main.java.subformula.AP;
import main.java.subformula.CTLFormula;
import main.java.subformula.EU;

class TestEU {

	private KripkeStructure ks;
	private CTLFormula formula;
	
	@Test
	void EbUcOnS1S2() {
		ks = GenerateTestKripkeStructures.generate1();
		formula = new EU(new AP("b"), new AP("c"));
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] { new State("S1"), new State("S2")}));
	}
	
	@Test
	void EaUcOnNoOne() {
		ks = GenerateTestKripkeStructures.generate2();
		formula = new EU(new AP("a"), new AP("c"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] { }));
	}
	
	@Test
	void EaUbOnS3S4WithLoop() {
		ks = GenerateTestKripkeStructures.generate7();
		formula = new EU(new AP("a"), new AP("b"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] { new State("S3"), new State("S4")}));
	}
}
