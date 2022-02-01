package main.java.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class KripkeStructure {
	
    private  List<State> states;
    private  Map<State, List<String>> functions;
    private  Map<State, List<State>> relations;
    private  State initialState;
    
	public KripkeStructure(String fileName) throws IOException {
		this.states = new ArrayList<State>();
		this.functions = new HashMap<State, List<String>>();
		this.relations = new HashMap<State, List<State>>();
		
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		
		//Until we find the beginning line --States--
		String line = reader.readLine();
		while(line != null && !line.contains("--STATES--"))
		{
			line = reader.readLine();
		}

		//All the states (until we find line --Functions--)
		line = reader.readLine();
		while(line != null && !line.contains("--FUNCTIONS--")){
			this.states.add(new State(line));
			line = reader.readLine();
		}

		//All the functions (until we find line --Relations--)
		line = reader.readLine();
		while(line != null && !line.contains("--RELATIONS--")){
			String functionLine[] = line.split(" ");
			List<String> functionsElements = new ArrayList<String>();
			for(int i = 1; i < functionLine.length; i++)
			{
				functionsElements.add(functionLine[i]);
			}
			if(states.contains(new State(functionLine[0]))) {
				this.functions.put(states.get(states.indexOf(new State(functionLine[0]))), functionsElements);
				line = reader.readLine();
			}
			else {
				reader.close();
				throw new IOException("Error in parsing --FUNCTIONS-- line : " + line
						+ "\nThe state " + functionLine[0] + " doesn't exist");
			}
		}

		//All the relations (until we find line --Init--)
		line = reader.readLine();
		while(line != null && !line.contains("--INIT--")){
			String relationLine[] = line.split(" ");
			List<State> relationsElements = new ArrayList<State>();
			for(int i = 1; i < relationLine.length; i++)
			{
				if(states.contains(new State(relationLine[i]))) {
					relationsElements.add(states.get(states.indexOf(new State(relationLine[i]))));
				}
				else {
					reader.close();
					throw new IOException("Error in parsing --FUNCTIONS-- line : " + line
							+ "\nThe state " + relationLine[i] + " doesn't exist");
				}
			}
			if(states.contains(new State(relationLine[0]))) {
				this.relations.put(states.get(states.indexOf(new State(relationLine[0]))), relationsElements);
				line = reader.readLine();
			}
			else {
				reader.close();
				throw new IOException("Error in parsing --RELATIONS-- line : " + line
						+ "\nThe state " + relationLine[0] + " doesn't exist");
			}
		}
		
		//The initial state
		line = reader.readLine();
		if(line != null){
			if(states.contains(new State(line))) {
				initialState = states.get(states.indexOf(new State(line)));
			}
			else {
				reader.close();
				throw new IOException("Error in parsing --INIT-- line : " + line
						+ "\nThis is not a state");
			}
		}
		
		reader.close();
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
