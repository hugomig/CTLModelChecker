package main.java.subformula;

import java.util.List;

import main.java.models.KripkeStructure;
import main.java.models.State;

public interface CTLFormula {
	public List<State> resolve(KripkeStructure ks);
}
