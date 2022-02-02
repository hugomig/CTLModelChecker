package main.java.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.models.KripkeStructure;
import main.java.models.State;

public class KripkeStructureReader {
	
	public static KripkeStructure readFromFile(String filename) throws IOException {
		List<State> states = new ArrayList<State>();
		Map<State, List<String>> functions = new HashMap<State, List<String>>();
		Map<State, List<State>> relations = new HashMap<State, List<State>>();
		State initialState = new State("");
		
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		
		//Until we find the beginning line --States--
		String line = reader.readLine();
		while(line != null && !line.contains("--STATES--"))
		{
			line = reader.readLine();
		}

		//All the states (until we find line --Functions--)
		line = reader.readLine();
		while(line != null && !line.contains("--FUNCTIONS--")){
			states.add(new State(line));
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
				functions.put(states.get(states.indexOf(new State(functionLine[0]))), functionsElements);
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
				relations.put(states.get(states.indexOf(new State(relationLine[0]))), relationsElements);
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
		
		return new KripkeStructure(states, functions, relations, initialState);
	}
	
}
