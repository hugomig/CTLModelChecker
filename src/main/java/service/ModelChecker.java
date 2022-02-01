package main.java.service;



import java.io.IOException;

import main.java.models.KripkeStructure;

public class ModelChecker {
	
	public static void main(String[] args) throws IOException {
		System.out.println("Hello world!");
		
		read(args[0]);

	}
	
	public static KripkeStructure read(String filename) throws IOException {
		
		
		  return new KripkeStructure(filename);
	}
}
