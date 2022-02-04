package test.java.operators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import main.java.models.KripkeStructure;
import main.java.models.State;
import main.java.subformula.AF;
import main.java.subformula.AP;
import main.java.subformula.CTLFormula;

class TestAF {
	
	private KripkeStructure ks;
	private CTLFormula formula;

	@Test
	void AFCOnS1S2() {
		ks = GenerateTestKripkeStructures.generate1();
		formula = new AF(new AP("c"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] {new State("S1"), new State("S2")}));
	}
	
	@Test
	void AFBOnNoOne() {
		ks = GenerateTestKripkeStructures.generate1();
		formula = new AF(new AP("b"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] {}));
	}
	
	@Test
	void AFBOnNoOneWithLoop() {
		ks = GenerateTestKripkeStructures.generate3();
		formula = new AF(new AP("b"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] {}));
	}
	
	@Test
	void AFAWithComplexLoop() {
		ks = GenerateTestKripkeStructures.generate8();
		formula = new AF(new AP("a"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] {new State("S1"), new State("S2"), new State("S3"), new State("S4")}));
	}

}
