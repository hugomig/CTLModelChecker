package test.java.operators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import main.java.models.KripkeStructure;
import main.java.models.State;
import main.java.subformula.AP;
import main.java.subformula.AX;
import main.java.subformula.CTLFormula;

class TestAX {

	private KripkeStructure ks;
	private CTLFormula formula;
	
	@Test
	void AXOnNoOne() {
		ks = GenerateTestKripkeStructures.generate1();
		formula = new AX(new AP("b"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] {}));
	}
	
	@Test
	void AXOnS1S2() {
		ks = GenerateTestKripkeStructures.generate1();
		formula = new AX(new AP("c"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] {new State("S1"), new State("S2")}));
	}
	
	@Test
	void AXOnS1S2S3WithLoop() {
		ks = GenerateTestKripkeStructures.generate3();
		formula = new AX(new AP("a"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] {new State("S1"), new State("S2"), new State("S3")}));
	}

}
