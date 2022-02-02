package test.java.operators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import main.java.models.KripkeStructure;
import main.java.models.State;
import main.java.subformula.AP;
import main.java.subformula.CTLFormula;
import main.java.subformula.Or;

class TestOr {
	
	private KripkeStructure ks;
	private CTLFormula formula;

	@Test
	void aOrBOnS1() {
		ks = GenerateTestKripkeStructures.generate6();
		formula = new Or(new AP("a"), new AP("b"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] {new State("S1")}));
	}
	
	@Test
	void aOrCOnS1S2S3() {
		ks = GenerateTestKripkeStructures.generate6();
		formula = new Or(new AP("a"), new AP("c"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] { new State("S1"), new State("S2"), new State("S3")}));
	}
	
	@Test
	void aOrBOrCOnNoOne() {
		ks = GenerateTestKripkeStructures.generate4();
		formula = new Or(new AP("a"), new Or(new AP("b"), new AP("c")));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] {}));
	}

}
