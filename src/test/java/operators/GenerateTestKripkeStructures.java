package test.java.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.models.KripkeStructure;
import main.java.models.State;

public class GenerateTestKripkeStructures {
	public static KripkeStructure generate1() {
		List<State> states = new ArrayList<State>();
		Map<State, List<String>> functions = new HashMap<State, List<String>>();
		Map<State, List<State>> relations = new HashMap<State, List<State>>();
		State initialState;
		
		State s1 = new State("S1");
		State s2 = new State("S2");
		State s3 = new State("S3");
		
		states.add(s1);
		states.add(s2);
		states.add(s3);

		functions.put(s1, Arrays.asList(new String[] {"a", "b"}));
		functions.put(s2, Arrays.asList(new String[] {"b", "c"}));
		functions.put(s3, Arrays.asList(new String[] {"c"}));
		
		relations.put(s1, Arrays.asList(new State[] {s2, s3}));
		relations.put(s2, Arrays.asList(new State[] {s3}));
		
		initialState = s1;
		
		return new KripkeStructure(states, functions, relations, initialState);
	}
	
	public static KripkeStructure generate2() {
		List<State> states = new ArrayList<State>();
		Map<State, List<String>> functions = new HashMap<State, List<String>>();
		Map<State, List<State>> relations = new HashMap<State, List<State>>();
		State initialState;
		
		State s1 = new State("S1");
		State s2 = new State("S2");
		State s3 = new State("S3");
		
		states.add(s1);
		states.add(s2);
		states.add(s3);

		functions.put(s1, Arrays.asList(new String[] {"a"}));
		functions.put(s2, Arrays.asList(new String[] {"b"}));
		functions.put(s3, Arrays.asList(new String[] {"c"}));
		
		relations.put(s1, Arrays.asList(new State[] {s2}));
		relations.put(s2, Arrays.asList(new State[] {s3}));
		relations.put(s3, Arrays.asList(new State[] {s1}));
		
		initialState = s1;
		
		return new KripkeStructure(states, functions, relations, initialState);
	}
	
	public static KripkeStructure generate3() {
		List<State> states = new ArrayList<State>();
		Map<State, List<String>> functions = new HashMap<State, List<String>>();
		Map<State, List<State>> relations = new HashMap<State, List<State>>();
		State initialState;
		
		State s1 = new State("S1");
		State s2 = new State("S2");
		State s3 = new State("S3");
		
		states.add(s1);
		states.add(s2);
		states.add(s3);

		functions.put(s1, Arrays.asList(new String[] {"a"}));
		functions.put(s2, Arrays.asList(new String[] {"a"}));
		functions.put(s3, Arrays.asList(new String[] {"b"}));
		
		relations.put(s1, Arrays.asList(new State[] {s2}));
		relations.put(s2, Arrays.asList(new State[] {s1}));
		relations.put(s3, Arrays.asList(new State[] {s1}));
		
		initialState = s1;
		
		return new KripkeStructure(states, functions, relations, initialState);
	}
	
	public static KripkeStructure generate4() {
		List<State> states = new ArrayList<State>();
		Map<State, List<String>> functions = new HashMap<State, List<String>>();
		Map<State, List<State>> relations = new HashMap<State, List<State>>();
		State initialState;
		
		State s1 = new State("S1");
		State s2 = new State("S2");
		State s3 = new State("S3");
		
		states.add(s1);
		states.add(s2);
		states.add(s3);

		functions.put(s1, Arrays.asList(new String[] {}));
		functions.put(s2, Arrays.asList(new String[] {}));
		functions.put(s3, Arrays.asList(new String[] {}));
		
		relations.put(s1, Arrays.asList(new State[] {s2, s3}));
		relations.put(s2, Arrays.asList(new State[] {s3}));
		
		initialState = s1;
		
		return new KripkeStructure(states, functions, relations, initialState);
	}
	
	public static KripkeStructure generate5() {
		List<State> states = new ArrayList<State>();
		Map<State, List<String>> functions = new HashMap<State, List<String>>();
		Map<State, List<State>> relations = new HashMap<State, List<State>>();
		State initialState;
		
		State s1 = new State("S1");
		State s2 = new State("S2");
		State s3 = new State("S3");
		
		states.add(s1);
		states.add(s2);
		states.add(s3);

		functions.put(s1, Arrays.asList(new String[] {"a","b"}));
		functions.put(s2, Arrays.asList(new String[] {"a","b"}));
		functions.put(s3, Arrays.asList(new String[] {"c"}));
		
		relations.put(s1, Arrays.asList(new State[] {s2, s3}));
		relations.put(s2, Arrays.asList(new State[] {s3}));
		
		initialState = s1;
		
		return new KripkeStructure(states, functions, relations, initialState);
	}
	
	public static KripkeStructure generate6() {
		List<State> states = new ArrayList<State>();
		Map<State, List<String>> functions = new HashMap<State, List<String>>();
		Map<State, List<State>> relations = new HashMap<State, List<State>>();
		State initialState;
		
		State s1 = new State("S1");
		State s2 = new State("S2");
		State s3 = new State("S3");
		
		states.add(s1);
		states.add(s2);
		states.add(s3);

		functions.put(s1, Arrays.asList(new String[] {"a"}));
		functions.put(s2, Arrays.asList(new String[] {"c"}));
		functions.put(s3, Arrays.asList(new String[] {"c"}));
		
		relations.put(s1, Arrays.asList(new State[] {s2, s3}));
		relations.put(s2, Arrays.asList(new State[] {s3}));
		
		initialState = s1;
		
		return new KripkeStructure(states, functions, relations, initialState);
	}
	
	public static KripkeStructure generate7() {
		List<State> states = new ArrayList<State>();
		Map<State, List<String>> functions = new HashMap<State, List<String>>();
		Map<State, List<State>> relations = new HashMap<State, List<State>>();
		State initialState;
		
		State s1 = new State("S1");
		State s2 = new State("S2");
		State s3 = new State("S3");
		State s4 = new State("S4");
		
		states.add(s1);
		states.add(s2);
		states.add(s3);
		states.add(s4);

		functions.put(s1, Arrays.asList(new String[] {"b"}));
		functions.put(s2, Arrays.asList(new String[] {"c"}));
		functions.put(s3, Arrays.asList(new String[] {"a"}));
		functions.put(s4, Arrays.asList(new String[] {"a"}));
		
		relations.put(s1, Arrays.asList(new State[] {s4}));
		relations.put(s2, Arrays.asList(new State[] {s1}));
		relations.put(s3, Arrays.asList(new State[] {s1, s2, s4}));
		relations.put(s4, Arrays.asList(new State[] {s3}));
		
		initialState = s1;
		
		return new KripkeStructure(states, functions, relations, initialState);
	}
}
