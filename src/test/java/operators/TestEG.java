package test.java.operators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import main.java.models.KripkeStructure;
import main.java.models.State;
import main.java.subformula.AP;
import main.java.subformula.CTLFormula;
import main.java.subformula.EG;

class TestEG {
	
	private KripkeStructure ks;
	private CTLFormula formula;
	
	@Test
	void EGCOnS2S3() {
		ks = GenerateTestKripkeStructures.generate1();
		formula = new EG(new AP("c"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] {new State("S2"), new State("S3")}));
	}
	
	@Test
	void EGCOnNoOne() {
		ks = GenerateTestKripkeStructures.generate2();
		formula = new EG(new AP("c"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] {}));
	}
	
	@Test
	void EGAOnS1S2WithLoop() {
		ks = GenerateTestKripkeStructures.generate3();
		formula = new EG(new AP("a"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] {new State("S1"), new State("S2")}));
	}
	
	@Test
	void EGAOnS3S4WithLoop() {
		ks = GenerateTestKripkeStructures.generate7();
		formula = new EG(new AP("a"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] {new State("S3"), new State("S4")}));
	}

}
