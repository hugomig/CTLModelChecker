package main.java.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.java.subformula.And;
import main.java.subformula.CTLFormula;
import main.java.subformula.EU;
import main.java.subformula.EF;
import main.java.subformula.EG;
import main.java.subformula.Not;
import main.java.subformula.Or;
import main.java.subformula.AF;
import main.java.subformula.AG;
import main.java.subformula.AP;
import main.java.subformula.AU;
import main.java.subformula.AX;

public class CTLFormulaReader {
	
	public static CTLFormula readFromFile(String filename) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String textFormula = reader.readLine();
		reader.close();
		
		return parse(textFormula);
	}
	
	public static CTLFormula parse(String textFormula) throws IOException {
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
		if(count < 0) {
			throw new IOException("Error parsing formula "+textFormula+"\nMore closing parenthesis than opening ones");
		}
		else if (count > 0){
			throw new IOException("Error parsing formula "+textFormula+"\nMore opening parenthesis than closing ones");
		}
		
		switch (operator) {
		case "NOT":
		case "EX":
		case "EF":
		case "EG":
		case "AX":
		case "AF":
		case "AG":
			if(subFormulas.size() != 1) {
				throw new IOException("Error parsing formula : "+ textFormula+" incorect number of arguments for '"+operator+"', expected 1");
			}
			break;
		case "AND":
		case "OR":
		case "EU":
		case "AU":
			if(subFormulas.size() != 2) {
				throw new IOException("Error parsing formula : "+ textFormula+" incorect number of arguments for '"+operator+"', expected 2");
			}
			break;
		}
		
		switch(operator) {
		case "NOT":
			return new Not(parse(subFormulas.get(0)));
		case "AND":
			return new And(parse(subFormulas.get(0)), parse(subFormulas.get(1)));
		case "OR":
			return new Or(parse(subFormulas.get(0)), parse(subFormulas.get(1)));
		case "EX":
			return new EF(parse(subFormulas.get(0)));
		case "EU":
			return new EU(parse(subFormulas.get(0)), parse(subFormulas.get(1)));
		case "EF":
			return new EF(parse(subFormulas.get(0)));
		case "EG":
			return new EG(parse(subFormulas.get(0)));
		case "AX":
			return new AX(parse(subFormulas.get(0)));
		case "AU":
			return new AU(parse(subFormulas.get(0)), parse(subFormulas.get(1)));
		case "AF":
			return new AF(parse(subFormulas.get(0)));
		case "AG":
			return new AG(parse(subFormulas.get(0)));
		default:
			if(subFormulas.size() > 0) {
				if(operator.equals("")) {
					throw new IOException("No operator detected outside parenthesis for "+textFormula+" check the parenthesis please");
				}
				throw new IOException("Error parsing "+textFormula+"\nThe formula "+operator+" is not implemented");
			}
			return new AP(textFormula);
		}
	}
	
}
