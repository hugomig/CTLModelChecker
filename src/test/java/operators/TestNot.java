package test.java.operators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import main.java.models.KripkeStructure;
import main.java.models.State;
import main.java.subformula.AP;
import main.java.subformula.CTLFormula;
import main.java.subformula.Not;
import main.java.subformula.Or;

class TestNot {
	
	private KripkeStructure ks;
	private CTLFormula formula;

	@Test
	void notCOnS1() {
		ks = GenerateTestKripkeStructures.generate1();
		formula = new Not(new AP("c"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] {new State("S1")}));
	}
	
	@Test
	void notAOrCOnNoOne() {
		ks = GenerateTestKripkeStructures.generate1();
		formula = new Not(new Or(new AP("a"), new AP("c")));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] {}));
	}
	
	@Test
	void notDOnS1S2S3() {
		ks = GenerateTestKripkeStructures.generate1();
		formula = new Not(new AP("d"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] { new State("S1"), new State("S2"), new State("S3")}));
	}

}
