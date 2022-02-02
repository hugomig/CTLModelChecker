package test.java.operators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import main.java.models.KripkeStructure;
import main.java.models.State;
import main.java.subformula.AP;
import main.java.subformula.CTLFormula;
import main.java.subformula.EX;

class TestEX {

	private KripkeStructure ks;
	private CTLFormula formula;
	
	@Test
	void EXAOnNoOne() {
		ks = GenerateTestKripkeStructures.generate1();
		formula = new EX(new AP("d"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] {}));
	}
	
	@Test
	void EXAOnS1S2S3() {
		ks = GenerateTestKripkeStructures.generate2();
		formula = new EX(new AP("a"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] {new State("S1"), new State("S2"), new State("S3")}));
	}
	
	@Test
	void EXBOnS3() {
		ks = GenerateTestKripkeStructures.generate3();
		formula = new EX(new AP("b"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] {new State("S3")}));
	}

}
