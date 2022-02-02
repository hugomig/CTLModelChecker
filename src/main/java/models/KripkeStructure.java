package main.java.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class KripkeStructure {
	
    private  List<State> states;
    private  Map<State, List<String>> functions;
    private  Map<State, List<State>> relations;
    private  State initialState;
    
	public KripkeStructure(List<State> states, Map<State, List<String>> functions, Map<State, List<State>> relations, State initialState) {
		this.states = states;
		this.functions = functions;
		this.relations = relations;
		this.initialState = initialState;
	}
	
	public List<State> getChildrenOf(State s) {
		List<State> children = new ArrayList<State>();
		
		if(relations.containsKey(states.get(states.indexOf(s)))) {
			children.addAll(relations.get(states.get(states.indexOf(s))));
		}
		
		return children;
	}
	
	public List<State> getParentsOf(State s) {
		List<State> parents = new ArrayList<State>();
		
		for(State verif: states) {
			if(relations.containsKey(verif)) {
				if(relations.get(verif).contains(s)) {
					parents.add(verif);
				}
			}
		}
		
		return parents;
	}
	
	public List<State> getStates(){
		return states;
	}
	
	public Map<State, List<String>> getFunctions(){
		return functions;
	}
	
	public Map<State, List<State>> getRelations(){
		return relations;
	}
	
	public State getInitialState() {
		return initialState;
	}
	
	@Override
	public String toString() {
		return ("Kripke: ["
			+ "\n\tStates: "+ states.toString()
			+ "\n\tFunctions: " + functions.toString()
			+ "\n\tRelations: " + relations.toString()
			+ "\n\tInitial: " + initialState.toString()
			+ "\n]");
	}

}
