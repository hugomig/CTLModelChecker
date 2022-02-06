package main.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import main.java.models.KripkeStructure;
import main.java.models.State;

public class KripkeStructureRandomGenerator {
	
	private static final int MIN_STATES = 2;
	private static final int MAX_STATES = 10;
	
	public static KripkeStructure generate() {
		List<State> states = new ArrayList<State>();
		Map<State, List<String>> functions = new HashMap<State, List<String>>();
		Map<State, List<State>> relations = new HashMap<State, List<State>>();
		State initialState;
		
		Random rand = new Random();

		//States
		int numberOfStates = MIN_STATES + rand.nextInt(MAX_STATES - MIN_STATES);
		for(int i=0; i<numberOfStates; i++) {
			State state = new State("S"+i);
			states.add(state);
		}
		
		for(int i=0; i<numberOfStates; i++) {
			State state = states.get(states.indexOf(new State("S"+i)));
			
			//Functions
			int numberOfFunctions = rand.nextInt(numberOfStates);
			char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			
			List<String> APs = new ArrayList<String>();
			for(int j=0; j<numberOfFunctions; j++) {
				String function;
				do {
					function = ""+alphabet[rand.nextInt(numberOfStates)];
				} while(APs.contains(function));
				APs.add(function);
			}
			functions.put(state, APs);
			
			//Relations
			int numberOfRelations = rand.nextInt(numberOfStates);
			
			if(numberOfRelations == numberOfStates) {
				relations.put(state, states);
			}
			else if (numberOfRelations > 0){
				List<State> stateRelations = new ArrayList<State>();
				for(int j=0; j<numberOfRelations; j++) {
					State relationTo;
					do {
						relationTo = states.get(rand.nextInt(numberOfStates));
					} while(stateRelations.contains(relationTo));
					
					stateRelations.add(relationTo);
				}
				relations.put(state, stateRelations);
			}
		}
		
		//Initial state
		initialState = states.get(rand.nextInt(numberOfStates));
		
		
		//Check if all states are reachable from initial state
		KripkeStructure kripke = new KripkeStructure(states, functions, relations, initialState);
		List<State> accessibleFromInitial = kripke.getAllSuccessor(initialState);
		if(!accessibleFromInitial.contains(initialState)) {
			accessibleFromInitial.add(initialState);
		}
		if(!relations.containsKey(initialState)) {
			relations.put(initialState, new ArrayList<State>());
		}
		for(State s: states) {
			if(!accessibleFromInitial.contains(s)) {
				State parent;
				if(accessibleFromInitial.size() == 1) {
					parent = initialState;
				}
				else {
					do {
						parent = accessibleFromInitial.get(rand.nextInt(accessibleFromInitial.size()));
					} while(!relations.containsKey(parent));
				}
				List<State> parentRelations = relations.get(parent);
				parentRelations.add(s);
				relations.put(parent, parentRelations);
			}
		}
		
		return new KripkeStructure(states, functions, relations, initialState);
	}
}
