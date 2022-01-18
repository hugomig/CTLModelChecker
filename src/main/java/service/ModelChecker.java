package main.java.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import main.java.models.KripkeStructure;

public class ModelChecker {
	
	public static void main(String[] args) throws IOException {
		System.out.println("Hello world!");
		
		read(args[0]);
	}
	
	public static KripkeStructure read(String filename) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		System.out.println(reader.readLine());
		
		return new KripkeStructure();
	}
}
