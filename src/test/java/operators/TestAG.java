package test.java.operators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import main.java.models.KripkeStructure;
import main.java.models.State;
import main.java.subformula.AG;
import main.java.subformula.AP;
import main.java.subformula.CTLFormula;

class TestAG {

	private KripkeStructure ks;
	private CTLFormula formula;
	
	@Test
	void AGCOnS2S3() {
		ks = GenerateTestKripkeStructures.generate1();
		formula = new AG(new AP("c"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] {new State("S2"), new State("S3")}));
	}
	
	@Test
	void AGOnNoOneWithLoop() {
		ks = GenerateTestKripkeStructures.generate5();
		formula = new AG(new AP("a"));
		
		assertEquals(formula.resolve(ks), Arrays.asList(new State[] {}));
	}

}
