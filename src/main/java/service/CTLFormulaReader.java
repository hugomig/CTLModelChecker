package main.java.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.java.subformula.And;
import main.java.subformula.CTLFormula;
import main.java.subformula.Not;
import main.java.subformula.True;

public class CTLFormulaReader {
	
	public static CTLFormula readFromFile(String filename) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String textFormula = reader.readLine();
		reader.close();
		
		return parse(textFormula);
	}
	
	public static CTLFormula parse(String textFormula) {
		List<String> subFormulas = new ArrayList<String>();
		String operator = "";
		
		int start = 0;
		int end = 0;
		//Count is used to know how much parenthesis we are inside
		int count = 0;
		//Separate the operator and the subFormula(s) inside parenthesis
		for(int i=0; i<textFormula.length(); i++) {
			if(textFormula.charAt(i) == '(') {
				if(count == 0) {
					start = i;
				}
				count++;
			}
			else if(textFormula.charAt(i) == ')') {
				count--;
				if(count == 0) {
					end = i;
					String subFormula = "";
					for(int j=start+1; j<end; j++) {
						subFormula += textFormula.charAt(j);
					}
					subFormulas.add(subFormula);
				}
			}
			else if(count == 0) {
				operator += textFormula.charAt(i);
			}
		}
		
		System.out.println(operator);
		System.out.println(subFormulas);
		
		switch(operator) {
		case "NOT":
			return new Not(parse(subFormulas.get(0)));
		case "AND":
			return new And(parse(subFormulas.get(0)), parse(subFormulas.get(1)));
		default:
			return new True(textFormula);
		}
	}
	
}
