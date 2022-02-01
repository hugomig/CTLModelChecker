package main.java.models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class KripkeStructure {
	

	

    private  List<State> states;

    private  List<State> initialStates;

    private  Map<State, List<State>> relations;

    private  Map<State, List<String>> functions;

	public KripkeStructure(String fileName) throws IOException {

		this.states = new ArrayList<State>();

		this.functions = new HashMap<State, List<String>>();

		this.relations = new HashMap<State, List<State>>();

		this.initialStates = new ArrayList<State>();



		
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = reader.readLine();
		System.out.println(line);
		
		while(!line.contains("--STATES--") && line != null)
		{
			
			line = reader.readLine();

			
		}
		
		System.out.println(line);

		while(!line.contains("--FUNCTIONS--")  && line != null){
			line = reader.readLine();
			System.out.println(line);
			this.states.add(new State(line));
			
		}
		System.out.print(states.toString());
		while(!line.contains("--RELATIONS--")  && line != null){
			line = reader.readLine();
			System.out.println(line);
			String functionLine[] = line.split(" ");
			List<String> functionElement = new ArrayList<String>();
			for(int i = 1; i < functionLine.length; i++)
			{
				functionElement.add(functionLine[i]);
			}
			this.functions.put(new State(functionLine[0]), functionElement);
			
		}
		System.out.print(functions.toString());

		while(!line.contains("--INIT--")   && line != null){
			line = reader.readLine();
			System.out.println(line);
			String relationLine[] = line.split(" ");
			List<State> relationElement = new ArrayList<State>();
			for(int i = 1; i < relationLine.length; i++)
			{
				relationElement.add(new State(relationLine[i]));
			}
			this.relations.put(new State(relationLine[0]), relationElement);
		}
		System.out.print(relations.toString());
		while(line != null){
			line = reader.readLine();
			System.out.println(line);
			String initialsStatesLine[] = line.split(" ");
			for(int i = 1; i < initialsStatesLine.length; i++)
			{
				initialStates.add(new State(initialsStatesLine[i]));
			}
			
		}
		
		System.out.print(states.toString());
		System.out.print(functions.toString());
		System.out.print(relations.toString());
		System.out.print(initialStates.toString());
	}
	

}
